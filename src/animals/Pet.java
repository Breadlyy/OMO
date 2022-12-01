package animals;

public abstract class Pet implements IPet {
    private String name;
    public void say()
    {
        System.out.println("base");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
