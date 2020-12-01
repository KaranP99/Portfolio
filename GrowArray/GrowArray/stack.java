
/**
 * Write a description of class stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class stack
{
    // the size2 of the array
    private int size2;
    // its two
    private int[] two;

    public stack() {
        size2 = 0;
        two = new int[2];
    }

    public int size2() {
        return size2;
    }

    public int pop(int i) {
        if(size2>0){
            int v = two[size2-1];
            size2 = size2 -1;
            return v;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }
    public void push(int s) {
        if (size2 < two.length) {
            two[size2] = s;
            size2++;
        } else {
            int[] two2 = new int [size2*2];

            for (int i = 0; i < two.length; i++) {
                two2[i] = two[i];
            }

            two2[size2] = s;
            size2++;
            two = two2;
        }
    }

    public void set(int pos, int value){
        if (pos <= two.length){
            two[pos]= value;

        } else{
            int[] two3 = new int [size2*2];

            for (int i = 0; i < two.length; i++) {
                two3[i] = two[i];
            }

            two3[pos] = value;
            size2++;
            two = two3;

        }

    }
}
