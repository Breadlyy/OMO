package parser;

import events.Event;
import events.Fire;
import home.Home;
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

public class Parser {
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject;
    JSONArray jsonArray;
    public Home getHome() throws IOException, ParseException {
        Home home = Home.getExample("new_home");

        return home;
    }
    public   ArrayList<Human> getHumans() throws IOException, ParseException {
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
        humans.add(men);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("woman");
        jsonObject = (JSONObject) jsonArray.get(0);
        Human woman = new Woman(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(),
                (long)jsonObject.get("pass_no"));
        humans.add(woman);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("Child");
        jsonObject = (JSONObject) jsonArray.get(0);
        Human child = new Child(jsonObject.get("name").toString(),
                jsonObject.get("surname").toString(),
                (long)jsonObject.get("pass_no"));
        humans.add(child);
        return humans;
    }
    public ArrayList<Car> getCars() throws IOException, ParseException {
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
          cars.add(car);
        }
        return cars;
    }
    public ArrayList<Stuff> getStuff() throws IOException, ParseException {
        ArrayList<Stuff> stuffs = new ArrayList<>();
        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("stuff");
        for (int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);

            if( (long)jsonObject.get("num") == 1)
            {
                Fridge fridge = new Fridge();
                fridge.setId((long) jsonObject.get("id"));
                stuffs.add(fridge);
            }
            if( (long)jsonObject.get("num") == 2)
            {
                GasHeater gasHeater = new GasHeater();
                gasHeater.setId((long) jsonObject.get("id"));
                stuffs.add(gasHeater);
            }
            if( (long)jsonObject.get("num") == 3)
            {
                Microwave microwave = new Microwave();
                microwave.setId((long) jsonObject.get("id"));
                stuffs.add(microwave);
            }
            if( (long)jsonObject.get("num") == 4)
            {
                Shutter shutter = new Shutter();
                shutter.setId((long) jsonObject.get("id"));
                stuffs.add(shutter);
            }
            if( (long)jsonObject.get("num") == 5)
            {
                Window window = new Window();
                window.setId((long) jsonObject.get("id"));
                long q = (long)jsonObject.get("shutter_id");
                int k = (int)q - 1;
                window.setShutter((Shutter) stuffs.get(k));
                stuffs.add(window);
            }
            if( (long)jsonObject.get("num") == 6)
            {
                Tap tap = new Tap();
                tap.setId((long) jsonObject.get("id"));
                stuffs.add(tap);
            }
            if( (long)jsonObject.get("num") == 7)
            {
                Oven oven = new Oven();
                oven.setId((long) jsonObject.get("id"));
                stuffs.add(oven);
            }
        }
        return stuffs;
    }
    public ArrayList<Sensor> getSensors() throws IOException, ParseException {
        ArrayList<Sensor> sensors = new ArrayList<>();
        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
        jsonObject = (org.json.simple.JSONObject)object;
        jsonArray = (org.json.simple.JSONArray)jsonObject.get("sensor");
        for (int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);
            if((long)jsonObject.get("num") == 1)
            {
                Sensor gasSensor = new GasSensor();
                gasSensor.setId((long)jsonObject.get("id"));
                gasSensor.setObserve((long)jsonObject.get("observe"));
                sensors.add(gasSensor);
            }
            if((long)jsonObject.get("num") == 2)
            {
                Sensor fuse = new Fuse();
                fuse.setId((long)jsonObject.get("id"));
                fuse.setObserve((long)jsonObject.get("observe"));
                sensors.add(fuse);
            }
            if((long)jsonObject.get("num") == 3)
            {
                Sensor smokeDetector = new SmokeDetector();
                smokeDetector.setId((long)jsonObject.get("id"));
                smokeDetector.setObserve((long)jsonObject.get("observe"));
                sensors.add(smokeDetector);
            }
            if((long)jsonObject.get("num") == 4)
            {
                Sensor waterSensor = new WaterSensor();
                waterSensor.setId((long)jsonObject.get("id"));
                waterSensor.setObserve((long)jsonObject.get("observe"));
                sensors.add(waterSensor);
            }
            if((long)jsonObject.get("num") == 5)
            {
                Sensor windSensor = new WindSensor();
                windSensor.setId((long)jsonObject.get("id"));
                windSensor.setObserve((long)jsonObject.get("observe"));
                sensors.add(windSensor);
            }
        }
        return sensors;
    }


}