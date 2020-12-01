public class Book extends MediaItemPArtial
{
    public int numberOfPages;
    private String title;
    private int libraryCode;
    private String author;
    
    public Book(String theTitle, String author)
    {
        super(theTitle);
        this.author = author;
    }

    public String tostring(){
        
        return super.getTitle() + "by" + author;
    }
    
    public int getNoOfPages()
    {
        return numberOfPages;
    }


    public void setLibraryCode(int code)
    {
        int adjCode = code * 4;
        if(code < 20) {
            libraryCode = code;
        }
        else {
            libraryCode = adjCode;
        }
    }

    
    
    
}