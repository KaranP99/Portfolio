import shed.mbed.*;

/**
 * @author ash
 * @version 2016-01-05
 *
 * This example reads the temperature from the temperature sensor
 * every second. If the tempertaure is too high, the led turns
 * red. Otherwise it is blue.
 *
 * Your task is to chage the current program so that if the
 * temperature is above 27 degress, set the board led is red, if
 * the temperature is equal to or below 24 it turns blue, and is
 * green if it is between these two thresholds.
 * 
 */
public class Program {
    // The object for interacting with the FRDM/MBED.
    private MBed mbed;
    
    /**
     * Open a connection to the MBED.
     */
    public Program()
    {
        mbed = MBedUtils.getMBed();
    }
    
    /**
     * The starting point for the interactions.
     */
    public void run()
    {
        LCD lcd = mbed.getLCD();
        lcd.print(0, 0, "Driving Test C");
        LED led = mbed.getLEDBoard();
        Thermometer therm = mbed.getThermometer();

        while(mbed.isOpen()) {
            double temperature = therm.getTemperature();
            
            if(temperature>27.0) // Why do you like things so hot? ~Tim
                led.setColor(LEDColor.RED);
            else if(temperature<=24.0)
                led.setColor(LEDColor.BLUE);
            else 
                led.setColor(LEDColor.GREEN);
            
            lcd.print(0, 14, temperature+"C");
            
            sleep(1000);
        }
    }
    
    /**
     * Close the connection to the MBED.
     */
    public void finish()
    {
        mbed.close();
    }
    
    /**
     * A simple support method for sleeping the program.
     * @param millis The number of milliseconds to sleep for.
     */
    private void sleep(int millis)
    {
        try {
            Thread.sleep(millis);
        } 
        catch (InterruptedException ex) {
            // Nothing we can do.
        }
    }
    
}
