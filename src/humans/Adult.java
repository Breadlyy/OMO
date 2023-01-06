package humans;

import animals.Pet;
import food.Food;
import home.Home;
import home.Room;
import home.stuff.*;
import tasks.*;
import transport.Transport;

import java.time.LocalDateTime;
import java.util.*;


public abstract class Adult extends Human {


    private int busyCount;
    private Queue<Task> taskQueue;
    Task open;
    Task close;

    int rand;


    //passNo = id


    public Adult(String name, String surname, long pass) {
        super(name, surname, pass);
        taskQueue = new PriorityQueue<>(1, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.priority > o2.priority) return 1;
                if (o1.priority == o2.priority) return 0;
                return -1;
            }
        });
    }

    public void enqueueTask(Task t) {
        taskQueue.add(t);
    }

    public void run() {
        if (busyCount != 0) {
            System.out.println(name + "is busy");
            busyCount--;
        } else if (!taskQueue.isEmpty()) {
            Task task = taskQueue.remove();
            System.out.println(name + " got task " + task.getClass().getSimpleName());
            busyCount = task.getComplexity();
            task.run();
        } else {
            rand = (int) (Math.random() * 8);
            switch (rand) {
                case 0:
                    GasHeater gasHeater = getRandomHeater();
                    if (gasHeater == null) return;
                    moveTo(gasHeater.getRoom());
                    turnHeatingOn(gasHeater);
                    // System.out.println(this.name + " has turned on the gasheater " + gasHeater.getId());
                    close = new CloseHeaterTask(this, 1, 2, gasHeater);
                    System.out.println(this.name + " is gonna to turn the heater off");
                    taskQueue.add(close);
                    break;
                case 1:
                    Tap tap = getRandomTap();
                    if (tap == null) return;
                    moveTo(tap.getRoom());
                    turnWaterOn(tap);
                    //System.out.println(this.name + " has opened the tap " + tap.getId());
                    close = new CloseTapTask(this, 1, 5, tap);
                    System.out.println(this.name + " is gonna to close the tap");
                    taskQueue.add(close);
                    break;
                case 2:
                    Window window = getRandomWindow();
                    if (window == null) return;
                    moveTo(window.getRoom());
                    openWindow(window);
                    //System.out.println(this.name + " has opened the window " + window.getId());
                    close = new CloseWindowTask(this, 1, 2, window);
                    System.out.println(this.name + " is gonna close the window");

                    taskQueue.add(close);
                    break;
                case 3:
                    Oven oven = getRandomOven();
                    if (oven == null) return;
                    moveTo(oven.getRoom());
                    oven.turnOn();
                    System.out.println(this.name + " turned on Oven " + oven.getId());
                    close = new CloseOvenTask(this, 1, 2, oven);
                    System.out.println(this.name + " is gonna turn off the Oven");

                    taskQueue.add(close);
                    break;
                default:
                    System.out.println(this.name + " is chilling'");
            }
        }
    }




    public void eat(Fridge fridge) {
        System.out.println(name + "ate " + fridge.getFood().get(0) + " from fridge " + fridge.getId());
        fridge.eat(fridge.getFood().get(0));
    }

    public void goForFood(Fridge f) {
        for (int i = 0; i < 5; i++) f.put(new Food());
    }

    public void feedPet(Pet p) {
        Fridge f = findNonEmptyFridge();
        if (f == null) {
            f = findAnyFridge();
            if (f == null) {
                System.out.println("Sorry, we have no fridges");
            } else {
                Task t = new GoForFoodTask(this, 4, 2, f);
            }
        } else {
            System.out.println(name + " feed pet " + p.getName());
            moveTo(f.getRoom());
            f.eat(f.getFood().get(0));
        }
    }

    public void openWindow(Window window) {

        System.out.println(name + "opened window " + window.getId());
        window.open();
    }

    public void closeWindow(Window window) {

        System.out.println(name + "closed window " + window.getId());
        window.close();
    }

    public void ride(Transport transport) {
        System.out.println(name + " rides " + transport.getClass().getSimpleName());
    }


    public void turnHeatingOn(GasHeater heater) {
        System.out.println(name + " turned on gasHeater " + heater.getId());
        heater.turnOn();
    }


    public void turnHeatingOff(GasHeater heater) {
        System.out.println(name + " turned off gasHeater " + heater.getId());
        heater.turnOff();
    }


    public void turnWaterOn(Tap tap) {
        System.out.println(name + " opened tap " + tap.getId());
        tap.turnOn();

    }


    public void turnWaterOff(Tap tap) {
        System.out.println(name + " closed tap " + tap.getId());
        tap.turnOff();
    }

    public Fridge findNonEmptyFridge() {
        for (Stuff s = home.iterator.begin(); s != null; s = home.iterator.next()) {
            if (s instanceof Fridge) {
                if (!((Fridge) s).empty()) {
                    moveTo(s.getRoom());
                    return (Fridge) s;
                }
            }
        }
        return null;
    }

    public Fridge findAnyFridge() {
        for (Stuff s = home.iterator.begin(); s != null; s = home.iterator.next()) {
            if (s instanceof Fridge) {
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
        System.out.println(name + " feed child " + c.name);
        c.eat();
    }

    public void eat() {
        Fridge f = findNonEmptyFridge();
        if (f == null) {
            f = findAnyFridge();
            if (f != null) {
                enqueueTask(new GoForFoodTask(this, 4, 3, f));
                enqueueTask(new EatTask(this, 2, 3));
            } else {
                System.out.println("Why don't we have fridges?");
            }
        } else {
            eat(f);
            System.out.println("Adult " + name + " ate");
        }

    }

    private Tap getRandomTap() {
        List<Tap> w = new ArrayList<>();
        Stuff tap = home.iterator.begin();
        while (tap != null) {
            if (tap instanceof Tap && !tap.active()) {
                w.add ((Tap) tap);
            }
            tap = home.iterator.next();
        }
        if(!w.isEmpty()) return w.get((int)(Math.random()*(w.size()-1)));
        return null;
    }

    private GasHeater getRandomHeater() {
        List<GasHeater> w = new ArrayList<>();
        Stuff gasHeater = home.iterator.begin();
        while (gasHeater != null) {
            if (gasHeater instanceof GasHeater && !gasHeater.active()) {
                w.add ((GasHeater) gasHeater);
            }
            gasHeater = home.iterator.next();
        }
        if(!w.isEmpty()) return w.get((int)(Math.random()*(w.size()-1)));
        return null;
    }

    private Window getRandomWindow() {

        List<Window> w = new ArrayList<>();
        Stuff window = home.iterator.begin();
        while (window != null) {
            if (window instanceof Window && !window.active()) {
                w.add ((Window) window);
            }
            window = home.iterator.next();
        }
        if(!w.isEmpty()) return w.get((int)(Math.random()*(w.size()-1)));
        return null;
    }

    private Oven getRandomOven() {
        List<Oven> w = new ArrayList<>();
        Stuff oven = home.iterator.begin();
        while (oven != null) {
            if (oven instanceof Oven) {
                w.add ((Oven) oven);
            }
            oven = home.iterator.next();
        }
        if(!w.isEmpty()) return w.get((int)(Math.random()*(w.size()-1)));
        return null;
    }

    public void playWith(Child c) {
        System.out.println(name + " played with " + c.name);
    }

    public void repair(Stuff s) {
        System.out.println("Dad repaired " + s.getName() + " with id " + s.getId());
        s.repairThis();
    }
}
