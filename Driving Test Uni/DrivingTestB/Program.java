import shed.mbed.*;
/**
 * In this example, a listener is added to button SW3 making the LED
 * cycle through white and black (off).
 *
 * Your task is to add additional colours to the cycle. Your target
 * pattern is Red, Green, Blue, White, Off (Black)
 * 
 * @author djb + ash
 * @version 2016.01.05
 */
public class Program
{
    // The object for interacting with the FRDM/MBED.
    private MBed mbed;
    
    private int ledState = 0;
    
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
        lcd.print(0, 0, "Driving Test B");
        final LED led = mbed.getLEDBoard();

        mbed.getSwitch3().addListener(isPressed -> {
            if(isPressed) {
                //I've only put in the two colour states requested by the client. ~Steve
                if(ledState==0) {
                    led.setColor(LEDColor.RED);
                } else if(ledState==1) {
                    led.setColor(LEDColor.GREEN);
                } else if(ledState==2) {
                    led.setColor(LEDColor.BLUE);
                } else if(ledState==3) {
                    led.setColor(LEDColor.WHITE);
                } else if(ledState==4) {
                    led.setColor(LEDColor.BLACK);
                }
                
                ledState++;
                if(ledState>=5) ledState=0; //Remember to update this if you ever increase the number of colour states. ~Tim
            }
        });
        
        led.setColor(LEDColor.BLACK);
        
        
        while(mbed.isOpen()) {
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
