package main.java.home.stuff;

import main.java.home.Home;
import main.java.parser.Parser;

import java.util.logging.Logger;

public class StuffIterator
{
    private int floornum=0, roomnum=0, stuffnum=0;
    private final Home home;
    private static final Logger log = Logger.getLogger(Parser.class.getName());

    public StuffIterator(Home home) {
        this.home = home;
    }

    public boolean hasNext() {
        //System.out.println(main.java.home.getFloors().get(floornum).getRooms().get(roomnum).getStuff().size()+">"+(stuffnum+1));
        if(home.getFloors().get(floornum).getRooms().get(roomnum).getStuff().size()>stuffnum+1) return true;
        for(int tfloornum=floornum; tfloornum < home.getFloors().size(); tfloornum++)
        {
            for(int troomnum=floornum==tfloornum?(roomnum+1):0; troomnum < home.getFloors().get(tfloornum).getRooms().size(); troomnum++)
            {
                if(home.getFloors().get(tfloornum).getRooms().get(troomnum).getStuff().size()>0) return true;
            }
        }
        return false;
    }

    public Stuff begin() {
        for (int tfloornum = 0; tfloornum < home.getFloors().size(); tfloornum++) {
            for (int troomnum = 0; troomnum < home.getFloors().get(tfloornum).getRooms().size(); troomnum++) {
                if (home.getFloors().get(tfloornum).getRooms().get(troomnum).getStuff().size() > 0) {
                    floornum = tfloornum;
                    roomnum = troomnum;
                    stuffnum = 0;
                    return home.getFloors().get(tfloornum).getRooms().get(troomnum).getStuff().get(0);
                }
            }
        }
        log.info("Iterator wasn't started");
        return null;
    }

    public Stuff next() {
        if(home.getFloors().get(floornum).getRooms().get(roomnum).getStuff().size()>stuffnum+1)
        {
            stuffnum++;
            return home.getFloors().get(floornum).getRooms().get(roomnum).getStuff().get(stuffnum);
        }
        for(int tfloornum=floornum; tfloornum < home.getFloors().size(); tfloornum++)
        {
            if(tfloornum!=floornum) roomnum=0;
            for(int troomnum=roomnum; troomnum < home.getFloors().get(tfloornum).getRooms().size(); troomnum++)
            {
                if(troomnum!=roomnum || tfloornum!=floornum) stuffnum=-1;
                for(int tstuffnum=stuffnum+1; tstuffnum < home.getFloors().get(tfloornum).getRooms().get(troomnum).getStuff().size(); tstuffnum++)
                {
                    floornum=tfloornum;
                    roomnum=troomnum;
                    stuffnum=tstuffnum;
                    return home.getFloors().get(floornum).getRooms().get(roomnum).getStuff().get(stuffnum);
                }
            }
        }
        log.info("Iterator have no more stuff");
        return null;
    }
}

