package constructions;

import java.time.LocalDateTime;

public class Home {
    private static Home home;
    public String values;
    private Home(String values) {
        this.values = values;
    }
    public static Home getExample(String values) {

        if (home == null) {

            home = new Home(values);

        }
        return home;

    }
}
