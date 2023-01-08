package main.java.parser;

import main.java.home.HouseBuilder;


import main.java.home.Floor;
import main.java.home.Home;
import main.java.home.Room;
import main.java.home.StuffFactory;
import main.java.home.sensor.*;
import main.java.home.stuff.*;
import main.java.humans.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import main.java.sport.Cycle;
import main.java.sport.Ski;
import main.java.sport.SportStuff;
import main.java.transport.Car;


import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import java.util.Map;
import java.util.logging.Logger;

public class Parser {
    private final static int NFRIDGE = 1, NGAS = 2, NMICROWAVE = 3, NSHUTTER = 4, NWINDOW = 5, NTAP = 6, NOVEN = 7;
    private final static int NGASSENSOR = 1, NELECTRICITYSENSOR = 2, NSMOKESENSOR = 3, NWATERSENSOR = 4, NWINDSENSOR = 5;
    private static final Logger log = Logger.getLogger(Parser.class.getName());


    private JSONObject jsonObject;
    private JSONArray jsonArray;

    private Map<Long, Human> human = new HashMap<>();
    private Map<Long, Stuff> allstuff = new HashMap<>();
    private Map<Long, SportStuff> sportstuff = new HashMap<>();
    private Map<Integer, Floor> floors = new HashMap<>();
    private Map<Integer, Room> rooms = new HashMap<>();
    private Map<Long, Sensor> sensors = new HashMap<>();
    private StuffFactory factory = new StuffFactory();

    /**
     * Main method, returns house that is ready to simulation
     *
     * @return
     */
    public Home getHome() {
        JSONParser jsonParser = new JSONParser();
        JSONObject wholeFile;
        try {
            FileReader reader = new FileReader("src/main/java/parser/base/classes.json");
            wholeFile = (JSONObject) jsonParser.parse(reader);
            HouseBuilder builder = new HouseBuilder();
            getHumans(wholeFile, builder);
            getCars(wholeFile);
            getFloors(wholeFile, builder);
            getRooms(wholeFile, builder);
            getStuff(wholeFile);
            getSensors(wholeFile, builder);
            getSportStuff(wholeFile, builder);
            for (Human h : human.values()) {
                h.setRoom(rooms.get(0));
            }
            return builder.getHome();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Sorry, your file is broken. Can not open it");
        } catch (ParseException e) {
            System.out.println(e.getStackTrace());
            System.out.println("Sorry, can not parse your file.");
        }
        return null;
    }

    /**
     * adds people to the house
     *
     * @param wholeFile
     * @param builder
     */
    public void getHumans(JSONObject wholeFile, HouseBuilder builder) {

        jsonArray = (org.json.simple.JSONArray) wholeFile.get("men");
        jsonObject = (JSONObject) jsonArray.get(0);
        Human men = new Men(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(),
                (long) jsonObject.get("pass_no"));
        builder.setFather((Men) men);

        jsonArray = (org.json.simple.JSONArray) wholeFile.get("woman");
        jsonObject = (JSONObject) jsonArray.get(0);
        Human woman = new Woman(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(),
                (long) jsonObject.get("pass_no"));
        builder.setMother((Woman) woman);

        jsonArray = (org.json.simple.JSONArray) wholeFile.get("child");
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            Child child = new Child(jsonObject.get("name").toString(),
                    jsonObject.get("surname").toString(),
                    (long) jsonObject.get("pass_no"));
            builder.addChild(child);
            human.put(child.getPassNo(), child);
        }
        human.put(men.getPassNo(), men);
        human.put(woman.getPassNo(), woman);
        log.info("Family was created");
    }

    /**
     * adds cars to the house
     *
     * @param wholeFile
     */
    public void getCars(JSONObject wholeFile) {
        long pass_no;
        jsonArray = (JSONArray) wholeFile.get("cars");
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            Car car = new Car((long) jsonObject.get("speed"),
                    jsonObject.get("brand").toString());
            //owner is presented by passnum
            JSONArray arr = (JSONArray) jsonObject.get("owners");
            for (int q = 0; q < arr.size(); q++) {
                jsonObject = (JSONObject) arr.get(q);
                pass_no = (Long) jsonObject.get("pass_no");
                (human.get(pass_no)).addTransport(car);
                //human.stream().filter(person -> person.getPassNo() == (long)o).forEach(person -> person.addTransport(car));
            }
        }
        log.info("Cars were created and attached to the people");
    }

    /**
     * Create a floor
     * attach to the house
     * <p>
     * Json structure:
     * num: Integer //floor number
     *
     * @param builder
     * @throws IOException
     * @throws ParseException
     */
    public void getFloors(JSONObject wholeFile, HouseBuilder builder) {

        jsonArray = (org.json.simple.JSONArray) wholeFile.get("floors");
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            Floor f = new Floor(builder.getHome(), (Long) jsonObject.get("num")); //Is it correct to use build here?
            builder.addFloor(f);
            int q = (int) f.getNumber();
            floors.put(q, f);
        }
        log.info("Floors appeared inda house");
    }

    /**
     * Create a room.
     * <p>
     * Json structure
     * floor: Integer
     * height: Integer
     * length: Integer
     * height: Integer
     * id: Integer
     * <p>
     * Then assign room to floor
     * Add to rooms list with room id
     *
     * @throws IOException
     * @throws ParseException
     */
    public void getRooms(JSONObject wholeFile, HouseBuilder builder) {
        jsonArray = (org.json.simple.JSONArray) wholeFile.get("rooms");
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            long width = (Long) ((JSONObject) jsonObject).get("width");
            long lenght = (Long) ((JSONObject) jsonObject).get("length");
            long height = (Long) ((JSONObject) jsonObject).get("height");
            long q = (Long) jsonObject.get("floor");
            int x = (int) q;
            Floor f = floors.get(x);
            Room room = new Room(height, width, lenght, f);
            rooms.put(i, room);
            builder.addRoom(room, f);
        }
        log.info("rooms are added to the floors");
    }


    /**
     * Define stuff
     * Based on typeNum create specific type of stuff
     * assign stuff to room via roomId
     * Add to allstuff list with stuffId
     * <p>
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

        jsonArray = (org.json.simple.JSONArray) wholeFile.get("stuff");
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            Stuff s;
            long x = (Long) jsonObject.get("num");
            int typeNum = (int) x;
            switch (typeNum) {
                case NFRIDGE: {
                    s = factory.createFridge();
                    break;
                }
                case NGAS: {
                    s = factory.createGasHeater();
                    break;
                }
                case NMICROWAVE: {
                    s = factory.createMicrowave();
                    break;
                }
                case NSHUTTER: {
                    s = factory.createShutter();
                    break;
                }
                case NWINDOW: {
                    s = factory.createWindow();
                    break;
                }
                case NTAP: {
                    long watercons = (Long) jsonObject.get("waterconsumption");
                    int waterconsumption = (int) watercons;

                    s = factory.createTap(waterconsumption);
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
            s.setEnergyConsumption((double) jsonObject.get("energyconsumption"));
            s.setName((String) jsonObject.get("_comment"));
            allstuff.put(s.getId(), s);
            long y = (Long) jsonObject.get("room");
            int room = (int) y;
            room--;
            rooms.get(room).addStuff(s);
            System.out.println();
        }
        log.info("Stuff was created");
    }


    /**
     * define sensor
     * Based on typeNum create specific type of sensor
     * Attach sensor to observed stuff
     * End
     * <p>
     * Json structure
     * type: Integer
     * observes: List[Integer] // stuff id
     * id: Integer
     *
     * @throws IOException
     * @throws ParseException
     */
    public void getSensors(JSONObject wholeFile, HouseBuilder builder) {


        jsonArray = (org.json.simple.JSONArray) wholeFile.get("sensor");

        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            long typeNum = (Long) jsonObject.get("type");
            long y = (Long) jsonObject.get("observe");


            Sensor s;
            switch ((int) typeNum) {
                case NGASSENSOR: {
                    s = new GasSensor();
                    long v = (Long) jsonObject.get("id");
                    builder.getHome().getGasLeak().attachSensor((GasSensor) s);
                    sensors.put(v, s);
                    ((GasSensor) s).add((GasHeater) allstuff.get(y));
                    break;
                }
                case NELECTRICITYSENSOR: {
                    s = new Fuse();
                    long v = (Long) jsonObject.get("id");
                    builder.getHome().getShortCircuit().attachSensor((Fuse) s);
                    sensors.put(v, s);
                    ((Fuse) s).add((ElectricStuff) allstuff.get(y));
                    break;
                }
                case NSMOKESENSOR: {
                    s = new SmokeDetector();
                    builder.getHome().getFire().attachSensor((SmokeDetector) s);
                    long v = (Long) jsonObject.get("id");
                    sensors.put(v, s);
                    ((SmokeDetector) s).add((Stuff) allstuff.get(y));
                    break;
                }
                case NWATERSENSOR: {
                    s = new WaterSensor();
                    long v = (Long) jsonObject.get("id");
                    builder.getHome().getWaterLeak().attachSensor((WaterSensor) s);
                    sensors.put(v, s);
                    ((WaterSensor) s).add((Tap) allstuff.get(y));
                    break;
                }
                case NWINDSENSOR: {
                    s = new WindSensor();
                    long v = (Long) jsonObject.get("id");
                    builder.getHome().getWindBlow().attachSensor((WindSensor) s);
                    sensors.put(v, s);
                    ((WindSensor) s).add((Window) allstuff.get(y));
                    break;
                }
                default:
                    continue;
            }
            s.setId((long) jsonObject.get("id"));
        }
        log.info("Sensors were created and attached to the stuff");
    }

    /**
     * adds sport stuff to the house
     *
     * @param wholeFile
     * @param builder
     */
    public void getSportStuff(JSONObject wholeFile, HouseBuilder builder) {
        jsonArray = (JSONArray) wholeFile.get("sport");
        long q;
        long v;
        JSONObject jsonObject1;

        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            q = (Long) jsonObject.get("own");
            long typeNum = (Long) jsonObject.get("type");
            SportStuff stuff;
            if (typeNum == 1) {
                stuff = new Ski();
                stuff.setId(i + 1);
                v = (Long) stuff.getId();
                sportstuff.put((Long) stuff.getId(), stuff);
                builder.getHome().getSportStuff().add(stuff);
            }
            if (typeNum == 2) {
                stuff = new Cycle();
                stuff.setId(i + 1);
                v = (Long) stuff.getId();
                sportstuff.put((Long) stuff.getId(), stuff);
                builder.getHome().getSportStuff().add(stuff);
            }

        }
        log.info("Cars were created and attached to the people");

    }

    public Map<Long, Human> getHuman() {
        return human;
    }

}