
/**
 * Write a description of class MediaItemPArtial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MediaItemPArtial
{
    // instance variables - replace the example below with your own
    public String title;
    private String comment;
    private boolean gotIt;

    /**
     * Constructor for objects of class MediaItemPArtial
     */
    public MediaItemPArtial(String theTitle)
    {
        
        this.title = theTitle;
        gotIt = false;
        comment = "";
        
       
    }

    public String getTitle()
    {
        return title;
    }
}
