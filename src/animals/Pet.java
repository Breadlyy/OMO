package animals;

public abstract class Pet implements IPet {
    private String name;
    int i;
    public void say()
    {
        System.out.println("base");
    }
    public void wantFood()
    {
        System.out.println("Want to eat");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void run()
    {
        i = (int)(Math.random() * 3);
        if(i == 0)
        {
            wantFood();
        }

    }
}
