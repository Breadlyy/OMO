import java.util.Random;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args) {
//        Test t = new Test();
//        t.run();
    }
    int b = 0;
    private class Klistener extends Thread
    {
        Scanner myObj = new Scanner(System.in);
        public void run()
        {

            System.out.println("Started waiting...");
            while (true)
            {
                int a = myObj.nextInt();
                b=a;
            }
        }
    }

    public void run()
    {
        int cooldown = 0;
        Klistener kl = new Klistener();
        kl.run();
        while (true)
        {
            if(b!=0)
            {
                System.out.println("b = "+b+"\nStopping....");
                cooldown = 100;
            }
            if(cooldown==0) System.out.println("running");
            else cooldown--;
        }
    }
}
