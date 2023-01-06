package home.stuff.state;

import home.stuff.Stuff;

public class StuffState {
    private enum State
    {
        WORK,
        IDLE,
        OFF,
        BROKE
    }

    public StuffState() {
       state = State.IDLE;
    }

    private State state;

    public void handle(Stuff stuff)
    {
        if(state==State.WORK) stuff.runEnabled();
    }

    public void turnOn()
    {
        if(state==State.IDLE) state = State.WORK;
    }

    public void turnOff() {
        if(state==State.WORK) state = State.IDLE;
    }

    public void powerOn() {
        if(state==State.IDLE) state = State.IDLE;
    }

    public void powerOff() {
        if(state==State.IDLE || state==State.WORK) state = State.OFF;
    }

    public void breakThing() {
        state = State.BROKE;
    }

    public void repair() {
        if(state==State.BROKE) state = State.OFF;
    }

    public boolean active()
    {
        return state==State.WORK;
    }


}
