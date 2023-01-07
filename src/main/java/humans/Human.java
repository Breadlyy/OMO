package main.java.humans;

import main.java.home.Home;
import main.java.home.Room;
import main.java.transport.Transport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Human {
    protected LocalDateTime bday;

    protected int hungerRate = 100;
    protected String name;
    protected String surname;
    protected Room room;
    protected Home home;
    protected long passNo;
    protected List<Transport> transports = new ArrayList<>();
    public Human(String name, String surname, long pass) {
        this.name = name;
        this.surname = surname;
        this.passNo = pass;
    }

    /**
     * addds transport owned
     * @param t
     */
    public  void  addTransport(Transport t)
    {
        transports.add(t);
        t.addOwner(this);
    }

    /**
     * moves to other room
     * @param room
     */
    public void moveTo(Room room)
    {
        System.out.println(name + " moved to floor " + room.getFloor().getNumber());
        this.room = room;
    }

    /**
     * returns actual floor where human is
     * @return
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Used in builder. Sets people's room, but without writing to console
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * assigns people to home
     * @param home
     */
    public void setHome(Home home)
    {
        this.home = home;
    }

    public long getPassNo() {
        return passNo;
    }


    public void setPassNo(int passNo) {
        this.passNo = passNo;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBday() {
        return bday;
    }

    public void setBday(LocalDateTime bday) {
        this.bday = bday;
    }

    /**
     * Overrided
     */
    public void eat()
    {
        return;
    }

    /**
     * returns actual information about person.
     * @return
     */
    public String generateReport()
    {
        return getClass().getSimpleName() + " "+ name + " " + surname + " born in " + getBday() + " passNum "+ getPassNo() + " actually on the " + getRoom().getFloor() + " hunger rate "+ hungerRate+"\n";
    }
}
