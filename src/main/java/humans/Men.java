package main.java.humans;

import main.java.home.stuff.Stuff;

/**
 * Men
 */
public class Men extends Adult {
        public Men(String name, String surname, long passNo) {
                super(name, surname, passNo);
        }

        public void hide() {
                busyCount += 5;
                System.out.println("Father hided");
        }

}
