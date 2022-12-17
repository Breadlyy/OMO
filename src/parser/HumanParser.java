package parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import humans.Human;
import humans.Men;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import transport.Car;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class HumanParser {
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject;
    JSONArray jsonArray;
    public ArrayList<Men> getMens() throws IOException, ParseException {
        String name, surname;
        int pass_no;
        ArrayList<Men> mens = new ArrayList<>();
        FileReader reader = new FileReader("src/parser/base/classes.json");
        Object object = jsonParser.parse(reader);
         jsonObject = (org.json.simple.JSONObject)object;
         jsonArray = (org.json.simple.JSONArray)jsonObject.get("humans");
        for(int i = 0; i < jsonArray.size(); i++)
        {
            jsonObject = (JSONObject) jsonArray.get(i);
            Men men = new Men(jsonObject.get("name").toString(),
                    jsonObject.get("surname").toString(),
                    (long)jsonObject.get("pass_no"));
            mens.add(men);
        }
        return mens;
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

}