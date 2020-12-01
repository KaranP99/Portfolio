// CO551 - Data Structures and Algorithms

/**
 * Simple class to test a linked list implementation.
 * 
 * @author Fernando Otero
 * @version 1.0
 */
public class ListTest
{
    public static void main(String[] args)
    {
        List<Integer> list = new List<Integer>();
        list.add(3);
        list.add(2);
        list.add(1);
        // this should print [1, 2, 3]
        list.print();
        
        list.remove(3);
        // this should print [1, 2]
        list.print();
        
        list.reverse();
        // this should print [2, 1]
        list.print();
    }
}