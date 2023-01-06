import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean wind;
    public boolean fire;
    public boolean flood;
    public boolean fourth;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case ('1'): {
                wind = true;
                break;
            }
            case ('2'): {

                fire = true;
                break;
            }
            case ('3'): {
                flood = true;
                break;
            }
            case ('4'): {
                fourth = true;
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case ('1'): {
                wind = false;
                break;
            }
            case ('2'): {
                fire = false;
                break;
            }
            case ('3'): {
                flood = false;
                break;
            }
            case ('4'): {
                fourth = false;
                break;
            }
        }
    }
}
