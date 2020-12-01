// CO551 - Data Structures and Algorithms

/**
 * A simple dynamic array.
 * 
 * @author Scott Owens
 * @author Stefan Kahrs
 */
public class GrowArray
{
    // the size of the array
    private int size;
    // its contents
    private String[] contents;

    public GrowArray() {
        size = 0;
        contents = new String[2];
    }

    public int size() {
        return size;
    }

    public String get(int i) {
        if (i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return contents[i];
    }

    public void add(String s) {
        if (size < contents.length) {
            contents[size] = s;
            size++;
        } else {
            String[] contents2 = new String [size*2];

            for (int i = 0; i < contents.length; i++) {
                contents2[i] = contents[i];
            }

            contents2[size] = s;
            size++;
            contents = contents2;
        }
    }

    // Some simple tests
    public static void main(String[] args) {
        GrowArray g = new GrowArray();
        g.add("a");
        g.add("b");
        g.add("c");
        g.add("d");
        for (int i = 0; i < g.size; i++) {
            System.out.println(i + ": " + g.get(i));
        }

    }

    public void set(int pos, String value){
        if (pos <= contents.length){
            contents[pos]= value;

        } else{
            String[] contents3 = new String [size*2];

            for (int i = 0; i < contents.length; i++) {
                contents3[i] = contents[i];
            }

            contents3[pos] = value;
            size++;
            contents = contents3;

        }

    }
    
    
}