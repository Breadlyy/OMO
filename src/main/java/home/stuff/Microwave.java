package main.java.home.stuff;

public class Microwave extends ElectricStuff
{
    int cooldown = 0;
    public Microwave() {
        energyConsumption = 15;
    }

    public void start()
    {
        System.out.println("microwave started heating");
        cooldown = 5;
        turnOn();
    }


    public void run()
    {
        if(cooldown!=0)
        {
            cooldown--;
            if(cooldown==0)
            {
                turnOff();
            }
        }
        state.handle(this);
    }



}
