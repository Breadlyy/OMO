package main.java.transport;

import main.java.humans.Human;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {
    private List<Human> owner;

    public Transport() {
        this.owner = new ArrayList<>();
    }

    public void addOwner(Human h) {
        owner.add(h);
    }
}
