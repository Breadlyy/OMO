package humans;

import home.Home;
import home.Room;
import sport.SportStuff;
import transport.Transport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Human {
    protected LocalDateTime bday;

    protected int hungerRate;
    protected String name;
    protected String surname;
    protected Room room;
    protected Home home;
    protected long passNo;
    protected SportStuff sportStuff;
    protected List<Transport> transports = new ArrayList<>();
    public Human(String name, String surname, long pass) {
        this.name = name;
        this.surname = surname;
        this.passNo = pass;
    }

    public  void  addTransport(Transport t)
    {
        transports.add(t);
        t.addOwner(this);
    }
    public void moveTo(Room room)
    {
        System.out.println(name + " moved to floor " + room.getFloor().getNumber());
        this.room = room;
    }
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

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
    public void setSportStuff(SportStuff sportStuff)
    {
        this.sportStuff = sportStuff;
    }
    public SportStuff getSportStuff()
    {
        return this.sportStuff;
    }

}
