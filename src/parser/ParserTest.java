package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import home.Floor;
import home.Home;
import home.Room;
import home.stuff.Microwave;
import humans.Men;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.Assert.assertEquals;


public class ParserTest {
    Parser sut = new Parser();
/*
    @Test
    public void microvaweTest()
    {
        Microwave m = new Microwave();
        m.setEnergyConsumption(51);
        m.setId(1);
        JSONObject j = new JSONObject();
        j.put("type", 3);
        j.put("energyconsumption", m.getEnergyConsumption());
        j.put("room", 2);
        j.put("id", m.getId());
        JSONArray arr = new JSONArray();
        arr.add(j);
        JSONObject whole = new JSONObject();
        whole.put("stuff", arr);


        sut.rooms.put(2, new Room(1,1,1,new Floor(Home.getExample(),1)));
        sut.getStuff(whole);
        Microwave result = (Microwave) sut.getAllstuff().get(m.getId());
        assertEquals(result.getId(), m.getId());
        assertEquals(result.getEnergyConsumption(), m.getEnergyConsumption(), 0.1);
    }*/
}
