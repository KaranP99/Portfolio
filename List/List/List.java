// CO551 - Data Structures and Algorithms

/**
 * Simple linked list implementation.
 * 
 * @author Fernando Otero
 * @version 1.0
 */
public class List<T>
{
    /**
     * Reference to the start of the list.
     */
    private Node<T> first;

    /**
     * Checks if the list is empty or not.
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * [Task 1] Adds a value to the start of the list.
     */
    public void add(T value)
    {
        // task: adds an element to the start of the list

        Node<T> node = new Node<T>(value, first);
        first = node;
    }

    /**
     * [Task 2] Prints the values of the list.
     */
    public void print()
    {
        // task: print the values on the list in order

        printr(first);
    }

    private void printr(Node node)
    {
        if (node == null){
            return;
        }
        System.out.println(node.head);
        printr(node.tail);

    }

    /**
     * [Task 3] Prints the values of the list in reverse order.
     */
    public void reversePrint()
    {
        // task: print the values on the list in reverse order
        // the list should not be reversed, only the print out of the values

        printrev(first);
    }

    private void printrev(Node node)
    {
        if (node == null){
            return;
        }

        printrev(node.tail);
        System.out.println(node.head);

    }

    /**
     * [Task 4] Removes a value from the list.
     */
    public void remove(T value)
    {
        //task: removes a specific value from the list
        Node<T> prevNode = null;
        for(Node<T> node = first; node!= null; node = node.tail){
            if(node.head == value){
                if(prevNode == null){
                    first = node.tail;
                }
                else{
                    prevNode.tail = node.tail;
                }

            }

            prevNode = node;
        }
    }

    /**
     * [Task 5] Removes the element a the top of the "stack" and returns its value.
     */
    public T pop()
    {
        return null;
    }

    /**
     * [Task 5] Adds an element to the top of the "stack".
     */
    public void push(T value)
    {
    }

    /**
     * [Task 6] Reverses the values in the list.
     */
    public void reverse()
    {
        // task: reverses the list
    }

    /**
     * Class to represent an individual node in the list.
     */
    private static class Node<T>
    {
        T head;
        Node<T> tail;

        Node(T h, Node<T> t)
        {
            head = h;
            tail = t;
        }
    }
}