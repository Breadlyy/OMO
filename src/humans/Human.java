package humans;

import com.google.common.collect.ForwardingQueue;
import food.Food;
import home.Home;
import home.Room;
import home.stuff.Window;
import home.stuff.Fridge;
import home.stuff.GasHeater;
import home.stuff.Tap;
import transport.Transport;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public abstract class Human implements Adult{

    private class Task
    {
        private final int complexity;
        private final Future task;
        private final int priority;

        public Task(int complexity, Future task, int priority) {
            this.complexity = complexity;
            this.task = task;
            this.priority = priority;
        }

        public int getComplexity() {
            return complexity;
        }

        public Future getTask() {
            return task;
        }

        public int getPriority() {
            return priority;
        }
    }
    private int busyCount;
    private Queue<Task> taskQueue = new PriorityQueue<>(0, new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            if (o1.priority>o2.priority)return 1;
            if(o1.priority==o2.priority)return 0;
            return -1;
        }
    });


    int rand;
    private Random random;
    private LocalDateTime bday;

    private String name;
    private String surname;
    private List<Transport> transports = new ArrayList<>();

    //passNo = id
    private long passNo;
    private Room room;
    private Home home;


    public  void  addTransport(Transport t)
    {
        transports.add(t);
        t.addOwner(this);
    }


    public Human(String name, String surname, long pass) {
        this.name = name;
        this.surname = surname;
        this.passNo = pass;
    }

    public void enqueueTask(Future task, int complexity, int priority)
    {
        taskQueue.add(new Task(complexity, task, priority));
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
            try {
                task.getTask().wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("Seems like an adult "+this.name+" is dead. Cancelling simulation");
            }
        }
        else
        {

        }
    }


    public void eat(Fridge fridge)
    {
        if(fridge.empty())
        {

            Callable c = (Callable) () -> {
                goForFood(fridge);
                return 0;
            };
            Future f = new FutureTask(c);
            taskQueue.add(new Task(4, f, 2));
        }
        else {
            fridge.eat(fridge.getFood().get(0));
        }
    }

public void goForFood(Fridge f)
{
    for(int i = 0; i < 5; i++) f.put(new Food());
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

    public void setHome(Home home)
    {
        this.home = home;
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
