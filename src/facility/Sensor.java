package facility;

import events.*;

import java.util.Random;

public class Sensor {
    public Sensor()
    {
       this.waterSensor = new WaterSensor();
       this.fuse = new Fuse();
       this.windSensor = new WindSensor();
       this.gasSensor = new GasSensor();
        eventOccur();
    }
        private IEvent event;
        Random random = new Random();
        int num;
        private ISensor waterSensor;
        private ISensor windSensor;
        private ISensor gasSensor;
        private ISensor fuse;
        public void setEvent(IEvent event) {
                this.event = event;
        }
        public void eventOccur()
        {
            num = this.random.nextInt(3);
            if(num == 0) setEvent(new WaterLeak());
            if(num == 1) setEvent(new GasLeak());
            if(num == 2) setEvent(new ShortCircuit());
            if(num == 3) setEvent(new WindBlow());
            triggerSomeSensor();
        }
        public void triggerSomeSensor() {
            if(event instanceof WaterLeak) waterSensor.triggered();
            else if(event instanceof GasLeak) gasSensor.triggered();
            else if(event instanceof WindBlow) windSensor.triggered();
            else if(event instanceof ShortCircuit) fuse.triggered();
        }
}
