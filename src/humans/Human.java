package humans;

import home.Home;
import home.Room;
import home.stuff.Window;
import home.stuff.Fridge;
import home.stuff.GasHeater;
import home.stuff.Tap;
import transport.Transport;

import java.time.LocalDateTime;
import java.util.Random;

public abstract class Human implements Adult{
    int rand;
    private Random random;
    private LocalDateTime bday;

    private String name;
    private String surname;

    //passNo = id
    private long passNo;
    private Room room;
    private Home home;


    public Human(String name, String surname, long pass) {
        this.name = name;
        this.surname = surname;
        this.passNo = pass;
    }

    public void eat(Fridge fridge)
    {

    }


    public void feed_pet()
    {

    }
    public void open_window(Window window)
    {
        window.open();
    }
    public void close_window(Window window)
    {
        window.close();
    }
    public void ride(Transport transport)
    {

    }

    @Override
    public void turn_heating_on(GasHeater heater)
    {
        heater.start_heating();
    }
    @Override
    public void turn_heating_off(GasHeater heater)
    {
        heater.stop_heating();
    }
    @Override
    public void turn_water_on(Tap tap)
    {
        tap.open_water();
    }
    @Override
    public void turn_water_off(Tap tap)
    {
        tap.close_water();
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

    public void screw_up()
    {
        rand = (int) (Math.random() * 5);
        switch (rand)
        {
            case 1: home.getFire().occur();
            case 2: home.getGasLeak().occur();
            case 3: home.getShortCircuit().occur();
            case 4: home.getShortCircuit().occur();
            case 5: home.getWindBlow().occur();
        }
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passNo=" + passNo +
                '}';
    }
}
