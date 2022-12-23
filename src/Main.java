import home.sensor.Sensor;
import home.stuff.Stuff;
import humans.Human;
import humans.Men;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import parser.Parser;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, JSONException {
        Parser parser = new Parser();
        ArrayList<Stuff> stuffs = parser.getStuff();
        ArrayList<Sensor> sensors = parser.getSensors();
        System.out.println();


//         ObjectMapper objectMapper = new ObjectMapper();
//         final JsonReader jsonReader = new JsonReader();
//         JSONParser jsonParser = new JSONParser();
//
//          FileReader reader = new FileReader("src/classes.json");
//          Object object = jsonParser.parse(reader);
//          JSONArray jsonArray = (org.json.simple.JSONArray)object;
//
//          JSONObject jsonObject = (JSONObject) jsonArray.get(0);
//          String fname = (String) jsonObject.get(0);
//          System.out.println(fname);

//        Car newcar = objectMapper.readValue(br, Car.class);

//
//     result+= objectMapper.writeValueAsString(car);
//     System.out.println(result);
//     Car newcar =  objectMapper.readValue(result, Car.class);
//     System.out.println();


//        Home home = Home.getExample("f");
//        Human men = new Men();
//        SmokeDetector sensor = new SmokeDetector();
//        home.getSensors().add(sensor);
//        Stuff oven = new Oven();
//        oven.turnOn();
//        sensor.add(oven);
//        Fire fire = new Fire();
//        fire.attachSensor(sensor);
//        men.screw_up();
//            List<Stuff> stuff = new ArrayList<>();
//            Stuff stuff1 = new Fridge();
//            Stuff stuff2 = new Microwave();
//            Stuff stuff3 = new Oven();
//            Stuff stuff4 = new Tap();
//            stuff.add(stuff1);
//        stuff.add(stuff2);
//        stuff.add(stuff3);
//        stuff.add(stuff4);
//        Room room = new Room(2,3,4, new Floor(Home.getExample("1"), 1));
//        room.setStuff(stuff);
//        Room.Iterator iterator = room.getIterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.hasNext());
//            System.out.println(iterator.next());
//        }

    }
}
