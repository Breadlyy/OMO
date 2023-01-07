package main.java.humans;

import main.java.animals.Pet;
import main.java.food.Food;
import main.java.home.stuff.*;
import main.java.sport.SportStuff;
import main.java.tasks.*;
import main.java.transport.Transport;

import java.util.*;


public abstract class Adult extends Human {


    protected int busyCount;
    protected Queue<Task> taskQueue;


    int rand;


    //passNo = id


    public Adult(String name, String surname, long pass) {
        super(name, surname, pass);
        taskQueue = new PriorityQueue<>(1, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.priority < o2.priority) return 1;
                if (o1.priority == o2.priority) return 0;
                return -1;
            }
        });
    }

    /**
     * adds task to to-do list. task will be done in the next loops
     * @param t
     */
    public void enqueueTask(Task t) {
        taskQueue.add(t);
    }

    /**
     * main method for simulation. Checks if adult is busy. If not, gets next task from to-do list. If to-do is empty, eats random uses stuff or does sport
     */
    public void run() {
        hungerRate--;
        if (busyCount != 0) {
            System.out.println(name + " is busy");
            busyCount--;
        } else if (!taskQueue.isEmpty()) {
            Task task = taskQueue.remove();
            System.out.println(name + " got task " + task.getClass().getSimpleName());
            busyCount = task.getComplexity();
            task.run();
        } else {
            Task open;
            Task close;
            if (hungerRate < 20) eat();
            rand = (int) (Math.random() * 8);
            switch (rand) {
                case 0:
                    GasHeater gasHeater = home.getRandomHeater();
                    if (gasHeater == null) return;
                    moveTo(gasHeater.getRoom());
                    if(gasHeater.isOff()) gasHeater.powerOn();
                    turnHeatingOn(gasHeater);
                    // System.out.println(this.name + " has turned on the gasheater " + gasHeater.getId());
                    close = new CloseHeaterTask(this, 1, 2, gasHeater);
                    System.out.println(this.name + " is gonna to turn the heater off");
                    taskQueue.add(close);
                    break;
                case 1:
                    Tap tap = home.getRandomTap();
                    if (tap == null) return;
                    moveTo(tap.getRoom());
                    if(tap.isOff()) tap.powerOn();
                    turnWaterOn(tap);
                    //System.out.println(this.name + " has opened the tap " + tap.getId());
                    close = new CloseTapTask(this, 1, 5, tap);
                    System.out.println(this.name + " is gonna to close the tap");
                    taskQueue.add(close);
                    break;
                case 2:
                    Window window = home.getRandomWindow();
                    if (window == null) return;
                    moveTo(window.getRoom());
                    openWindow(window);
                    //System.out.println(this.name + " has opened the window " + window.getId());
                    close = new CloseWindowTask(this, 1, 2, window);
                    System.out.println(this.name + " is gonna close the window");

                    taskQueue.add(close);
                    break;
                case 3:
                    Oven oven = home.getRandomOven();
                    if (oven == null) return;
                    moveTo(oven.getRoom());
                    if(oven.isOff()) oven.powerOn();
                    oven.turnOn();
                    System.out.println(this.name + " turned on Oven " + oven.getId());
                    close = new CloseOvenTask(this, 1, 2, oven);
                    System.out.println(this.name + " is gonna turn off the Oven");

                    taskQueue.add(close);
                    break;
                case 4: {
                    SportStuff sportStuff = home.getRandomSportStuff();
                    if (sportStuff == null) {
                        System.out.println(name + " wanted to sport but there is no main.java.sport equipment ");
                        break;
                    }
                    busyCount = 4;
                    System.out.println(name + " goes sport ");
                    sportStuff.run();
                    break;
                }
                case 5:
                {
                    Microwave m = home.getRandomMicrowave();
                    if(m==null) return;
                    if(m.isOff()) m.powerOn();
                    moveTo(m.getRoom());
                    m.start();
                    System.out.println(name + " used miccrowave "+ m.getId());
                }
                default:
                    System.out.println(this.name + " is chilling'");
            }
        }
    }

    /**
     * Eats from non-empty frigde
     * @param fridge
     */
    public void eat(Fridge fridge) {
        System.out.println(name + " ate " + fridge.getFood().get(0).getClass().getSimpleName() + " from fridge " + fridge.getId());
        hungerRate+=fridge.getFood().get(0).getCooked();
        fridge.eat(fridge.getFood().get(0));
    }

    /**
     * Fills fridge
     * @param f
     */
    public void goForFood(Fridge f) {
        for (int i = 0; i < 5; i++) f.put(new Food());
    }

    /**
     * Finds food in fridge and feeds pet.
     * If there is no food in fridge, goes for food
     * If there are no fridges, adult is sad
     * @param p
     */
    public void feedPet(Pet p) {
        Fridge f = findNonEmptyFridge();
        if (f == null) {
            f = findAnyFridge();
            if (f == null) {
                System.out.println("Sorry, we have no fridges");
            } else {
                Task t = new GoForFoodTask(this, 4, 2, f);
                Task t1 = new FeedPetTask(this, 2, 2, p);
                enqueueTask(t);
                enqueueTask(t1);
            }
        } else {
            System.out.println(name + " feed pet " + p.getName());
            moveTo(f.getRoom());
            f.eat(f.getFood().get(0));
        }
    }

    /**
     * opens window
     * @param window
     */
    private void openWindow(Window window) {

        System.out.println(name + "opened window " + window.getId());
        window.open();
    }

    /**
     * closes window
     */
    public void closeWindow(Window window) {

        System.out.println(name + "closed window " + window.getId());
        window.close();
    }


    /**
     * rides transport
     * @param transport
     */
    public void ride(Transport transport) {
        System.out.println(name + " rides " + transport.getClass().getSimpleName());
    }

    /**
     * turns hesting on
     * @param heater
     */
    private void turnHeatingOn(GasHeater heater) {
        System.out.println(name + " turned on gasHeater " + heater.getId());
        heater.turnOn();
    }

    /**
     * turns heating off
     * @param heater
     */
    public void turnHeatingOff(GasHeater heater) {
        System.out.println(name + " turned off gasHeater " + heater.getId());
        heater.turnOff();
    }

    /**
     * turns water on
     * @param tap
     */
    private void turnWaterOn(Tap tap) {
        System.out.println(name + " opened tap " + tap.getId());
        tap.turnOn();

    }

    /**
     * turns water off
     * @param tap
     */
    public void turnWaterOff(Tap tap) {
        System.out.println(name + " closed tap " + tap.getId());
        tap.turnOff();
    }

    /**
     * finds non empty fridge. It there are no, returns null
     * @return
     */
    private Fridge findNonEmptyFridge() {
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

    /**
     * finds any fridge in the house. If there are no returns null
     * @return
     */
    private Fridge findAnyFridge() {
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

    /**
     * Feeds child
     */
    public void feedChild(Child c) {
        System.out.println(name + " feed child " + c.name);
        c.eat();
    }

    /**
     * Tries to find food and eats
     */
    public void eat() {
        Fridge f = findNonEmptyFridge();
        if (f == null) {
            f = findAnyFridge();
            if (f != null) {
                enqueueTask(new GoForFoodTask(this, 2, 3, f));
                enqueueTask(new EatTask(this, 1, 3));
            } else {
                System.out.println("Why don't we have fridges?");
            }
        } else {
            eat(f);
            System.out.println("Adult " + name + " ate");
        }

    }


    /**
     * Plays with child
     */
    public void playWith(Child c) {
        System.out.println(name + " played with " + c.name);
    }

    /**
     * Repairs something
     * @param s
     */
    public void repair(Stuff s) {
        System.out.println("Dad repaired " + s.getName() + " with id " + s.getId());
        s.repairThis();
    }

    /**
     * MEthod used only in tests
     * @return
     */
    public Task getTask() {
        Task t = taskQueue.peek();
        return t;
    }
}
