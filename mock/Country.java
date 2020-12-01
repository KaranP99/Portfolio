import java.util.ArrayList;
/**
 * Write a description of class Country here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Country
{
    private String name;
    private ArrayList<City> cities;
    /**
     * Constructor for objects of class Country
     */
    public Country(String name)
    {
        this.name = name;
        ArrayList<City> cities = new ArrayList <> ();
    }

    
    public void addCity(City newcity)
    {
        if (newcity == null)
        {
            
        } else{
            cities.add(newcity);
        } 
        
    }
    
    public void printBigCities(int NumberOfCities)
    {
       if (NumberOfCities >= cities.size()) 
       {
           cities.get(NumberOfCities);
           System.out.println(cities);
       }
    }
    
    public void deleteSmallCities(int CitiesToDelete)
    {
        if (CitiesToDelete < cities.size())
        {
            cities.remove(CitiesToDelete);
            System.out.println(CitiesToDelete);
        }
    }
    
}
