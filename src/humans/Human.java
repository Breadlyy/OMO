package humans;

import constructions.Window;
import facility.Fridge;
import facility.GasHeater;
import facility.Tap;
import transport.Transport;

import java.time.LocalDateTime;

public abstract class Human implements Adult{

    private LocalDateTime bday;
    private String name;
    private String surname;
    //passNo = id
    private int passNo;
    @Override
    public void eat(Fridge fridge)
    {

    }

    @Override
    public void feed_pet() {

    }

    @Override
    public void open_window(Window window)
    {

    }

    @Override
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

    public int getPassNo() {
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
}
