package parser;

import builder.HouseBuilder;
import events.Event;
import events.Fire;

import home.Floor;
import home.Home;
import home.Room;
import home.sensor.*;
import home.stuff.*;
import humans.Child;
import humans.Human;
import humans.Men;
import humans.Woman;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import transport.Car;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    private final static int NFRIDGE = 1, NGAS = 2, NMICROWAVE = 3,NSHUTTER = 4, NWINDOW = 5, NTAP = 6, NOVEN = 7;
    private final static int NGASSENSOR = 1, NELECTRICITYSENSOR = 2, NSMOKESENSOR = 3, NWATERSENSOR = 4, NWINDSENSOR = 5;

    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject;
    JSONArray jsonArray;
    Map<Long, Human> human = new HashMap<>();
    Map<Long, Stuff> allstuff = new HashMap<>();
    Map<Integer, Floor> floors = new HashMap<>();
    Map<Integer, Room> rooms = new HashMap<>();
    public Home getHome() throws IOException, ParseException {
        HouseBuilder builder = new HouseBuilder();
        getHumans(builder);
        getCars(builder);
        getFloors(builder);
        getRooms();
        getStuff();
        getSensors();
        return builder.build();
    }


    public void getHumans(HouseBuilder builder) throws IOException, ParseException {
        String name, surname;
        int pass_no;
        ArrayList<Human> humans = new ArrayList<>();
        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
         jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("Men");
        jsonObject = (JSONObject) jsonArray.get(0);
        Human men = new Men(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(),
                (long)jsonObject.get("pass_no"));
        builder.setFather((Men)men);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("woman");
        jsonObject = (JSONObject) jsonArray.get(0);
        Human woman = new Woman(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(),
                (long)jsonObject.get("pass_no"));
        builder.setMother((Woman)woman);

        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("Child");
        for(int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            Child child = new Child(jsonObject.get("name").toString(),
                    jsonObject.get("surname").toString(),
                    (long) jsonObject.get("pass_no"));
            builder.addChild(child);
            human.put(child.getPassNo(), child);
        }
        human.put(men.getPassNo(), men);
        human.put(woman.getPassNo(), woman);

    }

    public void getCars(HouseBuilder builder) throws IOException, ParseException {
        String name, surname;
        int pass_no;
        ArrayList<Car> cars = new ArrayList<>();
        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("cars");
        for(int i = 0; i < jsonArray.size(); i++)
        {
          jsonObject = (JSONObject) jsonArray.get(i);
          Car car = new Car((long)jsonObject.get("speed"),
                  jsonObject.get("brand").toString());
          //owner is presented by passnum
          JSONArray arr = (JSONArray)jsonObject.get("owners");
          for(Object o: arr)
          {
              human.get((Long)o).addTransport(car);
              //human.stream().filter(person -> person.getPassNo() == (long)o).forEach(person -> person.addTransport(car));
          }
        }

    }

    /**
     * Create a floor
     * attach to the house
     * @param builder
     * @throws IOException
     * @throws ParseException
     */
    public void getFloors(HouseBuilder builder) throws IOException, ParseException {
        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("floors");
        for(Object o: jsonArray)
        {
            Floor f = new Floor(builder.build(),  (int)((JSONObject)o).get("num")); //Is it correct to use build here?
            builder.addFloor((Floor)o);
            floors.put(f.getNumber(), f);
        }
    }

    /**
     * Create a room.
     * Then assign room to floor
     * Add to rooms list with room id
     * @throws IOException
     * @throws ParseException
     */
    public void getRooms() throws IOException, ParseException {
        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("rooms");
        for(Object o:  jsonArray)
        {
            o = (JSONObject)o;
            int width = (int)((JSONObject) o).get("width");
            int lenght = (int)((JSONObject) o).get("length");
            int height = (int)((JSONObject) o).get("height");
            Floor f = floors.get((int)((JSONObject) o).get("floor"));
            Room r = new Room(height, width, lenght, f);
        }
    }


    /**
     * Define stuff
     * Based on typeNum create specific type of stuff
     * assign stuff to room via roomId
     * Add to allstuff list with stuffId
     * @throws IOException
     * @throws ParseException
     */
    public void getStuff() throws IOException, ParseException {
        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("stuff");
        for (int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);
            Stuff s;
            int typeNum =(int)jsonObject.get("num");
            switch (typeNum) {
                case NFRIDGE: {
                    s = new Fridge();
                    break;
                }
                case NGAS: {
                    s = new GasHeater();
                    break;
                }
                case NMICROWAVE: {
                    s = new Microwave();
                    break;
                }
                case NSHUTTER: {
                    s = new Shutter();
                    break;
                }
                case NWINDOW: {
                    s = new Window();
                    break;
                }
                case NTAP: {
                    s = new Tap((int) jsonObject.get("consumption"));
                    break;
                }
                case NOVEN: {
                    s = new Oven();
                    break;
                }
                default:
                    continue;
            }
            s.setId((long) jsonObject.get("id"));
            s.setEnergyConsumption((int)jsonObject.get("energyconsumption"));
            allstuff.put(s.getId(), s);
            rooms.get((int) jsonObject.get("room")).addStuff(s);
        }
    }


    /**
     * define sensor
     * Based on typeNum create specific type of sensor
     * Attach sensor to observed stuff
     * End
     * @throws IOException
     * @throws ParseException
     */
    public void getSensors() throws IOException, ParseException {

        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("sensor");
        for (int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);
            int typeNum = (int)jsonObject.get("observer");
            JSONArray arr = (JSONArray) jsonObject.get("observes");
            Sensor s;
            switch (typeNum) {
                case NGASSENSOR: {
                    s = new GasSensor();
                    for(Object o: arr)
                    {
                        ((GasSensor)s).add((GasHeater) allstuff.get((int)o));
                    }
                    break;
                }
                case NELECTRICITYSENSOR: {
                    s = new Fuse();
                    for(Object o: arr)
                    {
                        ((Fuse)s).add((ElectricStuff) allstuff.get((int)o));
                    }
                    break;
                }
                case NSMOKESENSOR: {
                    s = new SmokeDetector();
                    for(Object o: arr)
                    {
                        ((SmokeDetector)s).add(allstuff.get((int)o));
                    }
                    break;
                }
                case NWATERSENSOR: {
                    s = new WaterSensor();
                    for(Object o: arr)
                    {
                        ((WaterSensor)s).add((Tap) allstuff.get((int)o));
                    }
                    break;
                }
                case NWINDSENSOR: {
                    s = new WindSensor();
                    for(Object o: arr)
                    {
                        ((WindSensor)s).add((Shutter) allstuff.get((int)o));
                    }
                    break;
                }
                default:
                    continue;
            }
            s.setId((long)jsonObject.get("id"));
        }

    }
}