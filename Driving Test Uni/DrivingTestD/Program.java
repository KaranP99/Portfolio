import shed.mbed.*;
/**
 * This program prints the direction of the joystick to the LCD
 * screen when it is pressed LEFT, RIGHT, or FIRE. Additionally
 * the left and right motion of the joystick also toggle the two
 * LEDs.
 *
 * Your task is to modify the program so that the left and right
 * motion now picks which LED to toggle and pressing the joystick
 * toggles that LED. Which way and if it still prints out the
 * messages to the LCD are left up to you.
 * 
 * @author djb + ash
 * @version 2015.01.05
 */
public class Program
{
    // The object for interacting with the FRDM/MBED.
    private MBed mbed;
    private boolean isLeft = true;
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
        lcd.print(0, 0, "Driving Test D");
        
        LED board = mbed.getLEDBoard();
        LED shield = mbed.getLEDShield();
        
        
        mbed.getJoystickLeft().addListener(
            isPressed -> {
                if(isPressed) {
                    lcd.print(50, 10, "LEFT   ");
                    isLeft = true;
                    
                }
            });
            
        mbed.getJoystickRight().addListener(
            isPressed -> {
                if(isPressed) {
                    lcd.print(50, 10, "RIGHT  ");
                    isLeft = false;
                }
            });
            
        mbed.getJoystickFire().addListener(
            isPressed -> {
                if(isPressed) {
                    lcd.print(50, 10, "FIRE   ");
                    if(board.getColor()==LEDColor.BLACK && isLeft==true) {
                         board.setColor(LEDColor.WHITE);
                     } else {
                         board.setColor(LEDColor.BLACK);
                    } if(shield.getColor()==LEDColor.BLACK && isLeft==false) {
                         shield.setColor(LEDColor.WHITE);
                     } else {
                         shield.setColor(LEDColor.BLACK);
                    }
                }
            });
        
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
