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


import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

public class Parser {
    private final static int NFRIDGE = 1, NGAS = 2, NMICROWAVE = 3,NSHUTTER = 4, NWINDOW = 5, NTAP = 6, NOVEN = 7;
    private final static int NGASSENSOR = 1, NELECTRICITYSENSOR = 2, NSMOKESENSOR = 3, NWATERSENSOR = 4, NWINDSENSOR = 5;


    JSONObject jsonObject;
    JSONArray jsonArray;

    Map<Long, Human> human = new HashMap<>();
    Map<Long, Stuff> allstuff = new HashMap<>();
    Map<Integer, Floor> floors = new HashMap<>();
    Map<Integer, Room> rooms = new HashMap<>();
    Map<Long, Sensor> sensors = new HashMap<>();
    public Home getHome(){
        JSONParser jsonParser = new JSONParser();
        JSONObject wholeFile;
        try
        {
            FileReader reader = new FileReader("src/parser/base/classes.json");
            wholeFile = (JSONObject) jsonParser.parse(reader);
            HouseBuilder builder = new HouseBuilder();
            getHumans(wholeFile, builder);
            getCars(wholeFile);
            getFloors(wholeFile, builder);
            getRooms(wholeFile, builder);
            getStuff(wholeFile);
            getSensors(wholeFile);
            return builder.build();
        }
        catch (IOException e)
        {
            System.out.println("Sorry, your file is broken. Can not open it");
        }
        catch (ParseException e)
        {
            System.out.println("Sorry, can not parse your file.");
        }
    return null;
    }


    public void getHumans(JSONObject wholeFile, HouseBuilder builder){

        jsonArray = (org.json.simple.JSONArray)wholeFile.get("Men");
        jsonObject = (JSONObject) jsonArray.get(0);
        Human men = new Men(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(),
                (long)jsonObject.get("pass_no"));
        builder.setFather((Men)men);

        jsonArray = (org.json.simple.JSONArray)wholeFile.get("woman");
        jsonObject = (JSONObject) jsonArray.get(0);
        Human woman = new Woman(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(),
                (long)jsonObject.get("pass_no"));
        builder.setMother((Woman)woman);

        jsonArray = (org.json.simple.JSONArray)wholeFile.get("Child");
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

    public void getCars(JSONObject wholeFile){
        long pass_no;
        jsonArray = (JSONArray) wholeFile.get("cars");
        for(int i = 0; i < jsonArray.size(); i++)
        {
          jsonObject = (JSONObject) jsonArray.get(i);
          Car car = new Car((long)jsonObject.get("speed"),
                  jsonObject.get("brand").toString());
          //owner is presented by passnum
          JSONArray arr = (JSONArray)jsonObject.get("owners");
          for(int q = 0; q < arr.size(); q++)
          {
              jsonObject = (JSONObject) arr.get(q);
              pass_no = (Long)jsonObject.get("pass_no");
              human.get(pass_no).addTransport(car);
              //human.stream().filter(person -> person.getPassNo() == (long)o).forEach(person -> person.addTransport(car));
          }
        }

    }

    /**
     * Create a floor
     * attach to the house
     *
     * Json structure:
     * num: Integer //floor number
     *
     * @param builder
     * @throws IOException
     * @throws ParseException
     */
    public void getFloors(JSONObject wholeFile,HouseBuilder builder) {

        jsonArray = (org.json.simple.JSONArray)wholeFile.get("floors");
        for(int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);
            Floor f = new Floor(builder.build(),  (Long)jsonObject.get("num")); //Is it correct to use build here?
            builder.addFloor(f);
            int q = (int)f.getNumber();
            floors.put(q, f);
        }
    }

    /**
     * Create a room.
     *
     * Json structure
     * floor: Integer
     * height: Integer
     * length: Integer
     * height: Integer
     * id: Integer
     *
     * Then assign room to floor
     * Add to rooms list with room id
     * @throws IOException
     * @throws ParseException
     */
    public void getRooms(JSONObject wholeFile, HouseBuilder builder) {
        jsonArray = (org.json.simple.JSONArray)wholeFile.get("rooms");
        for(int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);
           long width = (Long)((JSONObject) jsonObject).get("width");
           long lenght = (Long)((JSONObject) jsonObject).get("length");
           long height = (Long)((JSONObject) jsonObject).get("height");
           long q = (Long) jsonObject.get("floor");
           int x = (int)q;
            Floor f = floors.get(x);
            Room room = new Room(height, width, lenght, f);
            rooms.put(i, room);
            builder.addRoom(room, f);
        }
    }


    /**
     * Define stuff
     * Based on typeNum create specific type of stuff
     * assign stuff to room via roomId
     * Add to allstuff list with stuffId
     *
     * Json structure
     * num: Integer //type number
     * waterconsumption: Integer // optional, used only for Tap type
     * energyconsumption: Integer // has to be in any stuff, including Tap
     * id: Integer
     * room: Integer // Where it is located
     *
     * @throws IOException
     * @throws ParseException
     */
    public void getStuff(JSONObject wholeFile) {

        jsonArray = (org.json.simple.JSONArray)wholeFile.get("stuff");
        for (int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);
            Stuff s;
            long x =(Long) jsonObject.get("num");
            int typeNum = (int)x;
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
                    long watercons = (Long) jsonObject.get("waterconsumption");
                    int waterconsumption = (int)watercons;
                    s = new Tap(waterconsumption);
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
            s.setEnergyConsumption((double)jsonObject.get("energyconsumption"));
            allstuff.put(s.getId(), s);
            long y = (Long)jsonObject.get("room");
            int room = (int)y;
            rooms.get(room).addStuff(s);
        }
    }


    /**
     * define sensor
     * Based on typeNum create specific type of sensor
     * Attach sensor to observed stuff
     * End
     *
     * Json structure
     * type: Integer
     * observes: List[Integer] // stuff id
     * id: Integer
     *
     * @throws IOException
     * @throws ParseException
     */
    public void getSensors(JSONObject wholeFile) {


        jsonArray = (org.json.simple.JSONArray)wholeFile.get("sensor");
        JSONArray arr = (JSONArray) wholeFile.get("stuff");
        JSONObject jsonObject1;
        for (int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);
            long typeNum = (Long) jsonObject.get("type");
            long y = (Long)jsonObject.get("observe");
            int x = (int)y;
            x--;
            jsonObject1 = (JSONObject)arr.get(x);
            Sensor s;
            switch ((int) typeNum) {
                case NGASSENSOR: {
                    s = new GasSensor();
                    long v = (Long)jsonObject1.get("id");
                    sensors.put(v, s );
                            ((GasSensor)s).add((GasHeater) allstuff.get(x));
                    break;
                }
                case NELECTRICITYSENSOR: {
                    s = new Fuse();
                    long v = (Long)jsonObject1.get("id");
                    sensors.put(v, s );
                        ((Fuse)s).add((ElectricStuff) allstuff.get(x));
                    break;
                }
                case NSMOKESENSOR: {
                    s = new SmokeDetector();
                    long v = (Long)jsonObject1.get("id");
                    sensors.put(v, s );
                    ((SmokeDetector)s).add((ElectricStuff) allstuff.get(x));
                    break;
                }
                case NWATERSENSOR: {
                    s = new WaterSensor();
                    long v = (Long)jsonObject1.get("id");
                    sensors.put(v, s );
                    ((WaterSensor)s).add((Tap) allstuff.get(x));
                    break;
                }
                case NWINDSENSOR: {
                    s = new WindSensor();
                    long v = (Long)jsonObject1.get("id");
                    sensors.put(v, s );
                    ((WindSensor)s).add((Shutter) allstuff.get(x));
                    break;
                }
                default:
                    continue;
            }
            s.setId((long)jsonObject.get("id"));
        }

    }


    public Map<Long, Human> getHuman() {
        return human;
    }

    public Map<Long, Stuff> getAllstuff() {
        return allstuff;
    }

    public Map<Integer, Floor> getFloors() {
        return floors;
    }

    public Map<Integer, Room> getRooms() {
        return rooms;
    }
}