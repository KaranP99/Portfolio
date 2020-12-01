import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

/**
 * CO551 - 2019 Assessment 1.
 *
 * @version 1.1
 */
public class Coursework {
    /**
     * Method to test the implemenation of the tasks. Note that this
     * are just examples, your implementation must work with any
     * valid input.
     */
    public static void main(String[] args) {
        // Task 1
        int[] array1 = {5, 4, 4, 5, 7, 3, 4, 8};
        System.out.print("Task 1: [");

        // should print [ 5 7 3 ]
        for (Integer i : averageSubarray(array1)) {
            System.out.print(" ");
            System.out.print(i);
        }

        System.out.println(" ]");

        // should print [ 1 3 ] or [ 2 2 ]
        int[] array2 = {2, 1, 3, 2, 2};
        System.out.print("Task 1: [ ");

        for (Integer i : averageSubarray(array2)) {
            System.out.print(" ");
            System.out.print(i);
        }

        System.out.println(" ]");

        // Task 2
        System.out.println("Task 2 (true): " + checkExpression("[[x+y]+z+(a-b)]"));
        System.out.println("Task 2 (false): " + checkExpression("[(x+y]+z)"));
        System.out.println("Task 2 (false): " + checkExpression(")x+y("));
        System.out.println("Task 2 (false): " + checkExpression("[x+y]+(a-b)"));
    }

    //-----------------------------------------------------------------//

    /**
     * Task 1.
     */
    public static int[] averageSubarray(int[] original) {
        // TODO: change this to return the correct value

        int array2Size = 1;
        while (array2Size <= original.length) {
            int[] array2 = new int[array2Size];
            int x = 0;
            while (x < original.length - array2Size) {
                System.arraycopy(original, x, array2, 0, array2Size);
                int averageA = 0;
                int averageB = 0;
                int i = 0;
                while ( i<original.length ;){
                    averageA = averageA + i;
                }
                int j = 0;
                while ( j<array2.length ;){
                    averageB = averageB + i;
                    if ((averageA / original.length) == (averageB / array2.length)) {
                        return array2;
                    }
                    x++
                }
                array2Size++;
            }
        }

        /**
         * Task 2.
         */
        public static boolean checkExpression (String expression){
            // TODO: change this to return the correct value
            Stack stack = new Stack();
            int i = 0;
            while (i < expression.length()) {
                String digit = expression.substring(i, i + 1);
                if (digit.contains("(") || digit.contains("[") || digit.contains(")") || digit.contains("]")) {
                    if (stack.empty() && (digit.contains(")") || digit.contains("]"))) {
                        return false;
                    } else {
                        stack.push(digit);
                    }

                    if (stack.size() == 3) {
                        String two = (String) stack.get(1);
                        String three = (String) stack.get(2);
                        if ((two.contains("(") && three.contains(")")) || (two.contains("[") && three.contains("]"))) {
                            stack.pop();
                            stack.pop();
                        } else {

                            return false;
                        }
                    }
                }

            }

            if (stack.size() <= 1) {
                return false;
            } else {

                String two = (String) stack.get(0);
                String three = (String) stack.get(1);
                if ((two.contains("(") && three.contains(")")) || (two.contains("[") && three.contains("]"))) {
                    stack.pop();
                    stack.pop();
                    return true;
                } else {
                    return false;
                }
            }

        }
        i++
    }

}
//References:
// https://docs.oracle.com/javase/7/docs/api/java/lang/System.html
//https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
//https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html

