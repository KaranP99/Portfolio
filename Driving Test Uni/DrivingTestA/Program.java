import shed.mbed.*;
public class Program
{

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
        lcd.print(0, 0, "MSounds Board");
        
        //Used to test the potentiometers. No longer need ~Tim
        Potentiometer pot2 = mbed.getPotentiometer2();
        
        LED led = mbed.getLEDBoard();
        int colorIndex = 0;

        while(mbed.isOpen()) {
            
            if(colorIndex==0) {
                led.setColor(LEDColor.BLUE);
            } else if(colorIndex==1) {
                led.setColor(LEDColor.CYAN);
            } else if(colorIndex==2) {
                led.setColor(LEDColor.GREEN);
            } else if(colorIndex==3) {
                led.setColor(LEDColor.YELLOW);
            } else if(colorIndex==4) {
                led.setColor(LEDColor.RED);
            } else if(colorIndex==5) {
                led.setColor(LEDColor.MAGENTA);
            }
            colorIndex++;
            if(colorIndex>5) colorIndex=0; //reset
            
         if(pot2.getValue()>0.6) {
                led.setColor(LEDColor.OFF);
                
            } else if (pot2.getValue()>0.4){
                led.setColor(LEDColor.GREEN);
                
            } else if (pot2.getValue()<0.4) {
                led.setColor(LEDColor.RED);
                
            }
            
            sleep(100);
        }
    }
    
    public void pswitch()
    {
        Potentiometer pot2 = mbed.getPotentiometer2();
        
        LED led = mbed.getLEDBoard();
         if(pot2.getValue()>0.0 && pot2.getValue()>0.4) {
                led.setColor(LEDColor.OFF);
                
            } else if (pot2.getValue()>0.4 && pot2.getValue()<0.6){
                led.setColor(LEDColor.GREEN);
                
            } else if (pot2.getValue()>0.6 && pot2.getValue()<1.0) {
                led.setColor(LEDColor.RED);
                
            }
    }
    public final Note A0;
    public void test()
    
    {
        
         mbed.getJoystickLeft().addListener(
            isPressed -> {
                if(isPressed) {
                    Piezo.playNote(A0);
                    
                }
            });
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

