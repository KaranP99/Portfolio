public class City
    {
    private String name;
    private int size;
public City(String name)
    {
        this.name = name;
    }
    
public String getName()
    {
        return name;
    }
    
public int getSize()
    {
        return size;
    }
    
public void setSize(int value)
    {
        if (value > 0) {
            size = value;
        } else {
            size = 0;
        }
    }
}