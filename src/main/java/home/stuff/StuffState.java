package main.java.home.stuff;

import main.java.home.stuff.Stuff;

/**
 * controls  stuff behaviour
 */
public class StuffState {
    protected enum State {
        WORK,
        IDLE,
        OFF,
        BROKE
    }

    public static State getOff() {
        return State.OFF;
    }

    public static State getIdle() {
        return State.IDLE;
    }

    private State state;

    /**
     * initially stuff is in IDLE state
     */
    public StuffState() {
        state = State.IDLE;
    }


    /**
     * run based on IDLE
     *
     * @param stuff
     */
    public void handle(Stuff stuff) {
        if (state == State.WORK) stuff.runEnabled();
        else if (state == State.IDLE) stuff.runIDLE();
    }

    public void turnOn() {
        if (state == State.IDLE) state = State.WORK;
    }

    public void turnOff() {
        if (state == State.WORK) state = State.IDLE;
    }

    public void powerOn() {
        if (state == State.OFF) state = State.IDLE;
    }

    public void powerOff() {
        if (state == State.IDLE || state == State.WORK) state = State.OFF;
    }

    public void breakThing() {
        state = State.BROKE;
    }

    public void repair() {
        if (state == State.BROKE) state = State.OFF;
    }

    public boolean active() {
        return state == State.WORK;
    }

    public boolean broken() {
        return state == State.BROKE;
    }

    public State getState() {
        return state;
    }

}
