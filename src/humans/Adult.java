package humans;

import animals.Pet;
import food.Food;
import home.Home;
import home.Room;
import home.stuff.*;
import tasks.GoForFoodTask;
import tasks.Task;
import transport.Transport;

import java.time.LocalDateTime;
import java.util.*;



public abstract class Adult extends Human{


    private int busyCount;
    private Queue<Task> taskQueue;


    int rand;
    private Random random;

    private List<Transport> transports = new ArrayList<>();

    //passNo = id




    public  void  addTransport(Transport t)
    {
        transports.add(t);
        t.addOwner(this);
    }


    public Adult(String name, String surname, long pass) {
        super(name, surname,pass);
        taskQueue = new PriorityQueue<>(1, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.priority>o2.priority)return 1;
                if(o1.priority==o2.priority)return 0;
                return -1;
            }
        });
    }

    public void enqueueTask(Task t)
    {
        taskQueue.add(t);
    }

    public void run()
    {
        if(busyCount!=0)
        {
            busyCount--;
        }
        else if (!taskQueue.isEmpty())
        {
            Task task = taskQueue.remove();
            busyCount=task.getComplexity();
            task.run();
        }
        else
        {

        }
    }


    /**
     * Check if fridge is  empty
     *
     * @param fridge
     * @return
     */
    private boolean checkFridge(Fridge fridge) {
        if (fridge.empty()) {
            Task t = new GoForFoodTask(this, 4, 2, fridge);
            taskQueue.add(t);
            return false;
        }
        return true;

    }

    public void eat(Fridge fridge)
    {
    if(!checkFridge(fridge))
    {
        Task t = new GoForFoodTask(this, 2, 2, fridge);
    }
        else {
            fridge.eat(fridge.getFood().get(0));
        }
    }

public void goForFood(Fridge f)
{
    for(int i = 0; i < 5; i++) f.put(new Food());
}

    public void feedPet(Pet p)
    {
        Fridge f = findNonEmptyFridge();
        if(f==null)
        {
            f = findAnyFridge();
            if(f==null)
            {
                System.out.println("Sorry, we have no fridges");
            }
            else
            {
                Task t = new GoForFoodTask(this, 4, 2, f);
            }
        }
        else{f.eat(f.getFood().get(0));}
    }
    public void openWindow(Window window)
    {
        window.open();
    }
    public void closeWindow(Window window)
    {
        window.close();
    }
    public void ride(Transport transport)
    {

    }


    public void turnHeatingOn(GasHeater heater)
    {
        heater.start_heating();
    }


    public void turnHeatingOff(GasHeater heater)
    {
        heater.stop_heating();
    }


    public void turnWaterOn(Tap tap)
    {
        tap.open_water();
    }


    public void turnWaterOff(Tap tap)
    {
        tap.close_water();
    }



    public void screwUp()
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

    public Fridge findNonEmptyFridge()
    {
        for(Stuff s = home.iterator.begin(); s!=null; s=home.iterator.next())
        {
            if(s instanceof Fridge)
            {
                if(!((Fridge) s).empty())
                {
                    moveTo(s.getRoom());
                    return (Fridge) s;
                }
            }
        }
        return null;
    }

    public Fridge findAnyFridge()
    {
        for(Stuff s = home.iterator.begin(); s!=null; s=home.iterator.next())
        {
            if(s instanceof Fridge)
            {
                    return (Fridge) s;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Adult{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passNo=" + passNo +
                '}';
    }

    public void feedChild(Child c) {
        c.eat();
    }

    public void eat()
    {
        Fridge f = findNonEmptyFridge();
        if(f==null)
        {
            f = findAnyFridge();
            if(f!=null)
            {
                enqueueTask(new GoForFoodTask(this, 4, 3, f));
            }
            else
            {
                System.out.println("Why don;t we have fridges?");
            }
        }
        else
        {
            eat(f);
        }
    }
}
