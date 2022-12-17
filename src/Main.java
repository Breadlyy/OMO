import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.collect.ImmutableList;
import events.Fire;
import food.Food;
import home.Floor;
import home.Home;
import home.Room;
import home.sensor.Sensor;
import home.sensor.SmokeDetector;
import home.stuff.*;
import humans.Human;
import humans.Men;
import net.minidev.json.writer.JsonReader;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import parser.HumanParser;
import transport.Car;
import org.json.simple.JSONArray;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, JSONException {
        HumanParser humanParser = new HumanParser();
        ArrayList<Men> mens = humanParser.getMens();
        System.out.println(mens.get(0).getName());
        System.out.println(mens.get(0).getSurname());
        System.out.println(mens.get(0).getPassNo());
        ArrayList<Car> cars = humanParser.getCars();
        System.out.println(cars.get(0).getSpeed());
        System.out.println(cars.get(0).getBrand());
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
