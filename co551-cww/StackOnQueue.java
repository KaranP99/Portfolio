import java.util.LinkedList;
import java.util.Queue;

/**
 * CO551 - 2019 Assessment 1.
 *
 * @version 1.1
 */
public class StackOnQueue
{
    /**
     * Elements of the stack should be stored in this queue.
     */
    private Queue<Integer> queue = new LinkedList<Integer>();

    /**
     * Retrieves and removes the value at the top of the stack.
     */
    public Integer pop() {
        // TODO: Should return the element on top of the stack

        for(int i = 0;i<queue.size();i++){
            if (queue.isEmpty()){
                return 0;
            } else {
                //queue.remove();
                int last = queue.getLast();
                return first;

            }

        }
        return 0;
    }

    /**
     * Pushes a value to the top of the stack.
     */
    public void push(Integer value) {
        // TODO: Should add the value to the top of the stack
        queue.add(value);

    }

    /**
     * Checks if the stack is empty.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Method to test the implemenation of the tasks. Note that this
     * are just examples, your implementation must work with any
     * valid input.
     */
    public static void main(String[] args) {
        // Task 3
        StackOnQueue stack = new StackOnQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.print("Task 3: [");

        while (!stack.isEmpty()) {
            System.out.print(" ");
            System.out.print(stack.pop());
        }

        System.out.println(" ]");
    }
}