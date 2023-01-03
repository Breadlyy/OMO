package home.stuff;

import home.Home;

public class StuffIterator
{
    private int floornum=0, roomnum=0, stuffnum=0;
    private final Home home;

    public StuffIterator(Home home) {
        this.home = home;
    }

    public boolean hasNext() {
        if(home.getFloors().get(floornum).getRooms().get(roomnum).getStuff().size()>stuffnum+1) return true;
        for(int tfloornum=floornum; tfloornum < home.getFloors().size(); tfloornum++)
        {
            for(int troomnum=roomnum; troomnum < home.getFloors().get(tfloornum).getRooms().size(); troomnum++)
            {
                if(home.getFloors().get(tfloornum).getRooms().get(troomnum).getStuff().size()>0) return true;
            }
        }
        return false;
    }

    public Stuff begin()
    {
        for(int tfloornum=0; tfloornum < home.getFloors().size(); tfloornum++)
        {
            for(int troomnum=0; troomnum < home.getFloors().get(tfloornum).getRooms().size(); troomnum++)
            {
                if(home.getFloors().get(tfloornum).getRooms().get(troomnum).getStuff().size()>0)
                {
                    floornum=tfloornum;
                    roomnum=troomnum;
                    stuffnum=0;
                    return  home.getFloors().get(tfloornum).getRooms().get(troomnum).getStuff().get(0);
                }
            }
        }
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
            for(int troomnum=roomnum; troomnum < home.getFloors().get(tfloornum).getRooms().size(); troomnum++)
            {
                for(int tstuffnum=stuffnum; tstuffnum < home.getFloors().get(tfloornum).getRooms().get(troomnum).getStuff().size(); tstuffnum++)
                {
                    floornum=tfloornum;
                    roomnum=troomnum;
                    stuffnum=tstuffnum;
                    return home.getFloors().get(floornum).getRooms().get(roomnum).getStuff().get(stuffnum);
                }
            }
        }
        return null;
    }
}

