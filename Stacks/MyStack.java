/*
 * Class:       CS 3305/W01
 * Term:        Fall 2025
 * Name:        Justin Turner
 * Professor:   Sharon Perry
 * Assignment:  4
 * IDE:         IntelliJ
 */


public class MyStack<T> { //declare a generic class myStack

    private Node StackTop;  // holds the link to the stack’s first element
    private int size; //holds the stack size

    public MyStack() //constructor method for myStack
    {
        StackTop = null; //stack starts empty
        size = 0; //initial size is 0

    }
    public boolean empty()//checks if the list is empty
    {
        // If there are no nodes, Top will be null and the method will return as true, false otherwise
        return StackTop == null;
    }

    public void push(T element) //Adds a new node to the front of the list
    {
        //element = value of the new node

        if (StackTop == null){ //if the list is empty
            StackTop = new Node(element); // create a node with one element that holds the data
            size = 1; //there is now one element in the list (stack)
        }
        else{ //list is not empty
            size++; //increase the size
            Node newNode = new Node(element); // create a new node with the given value


            newNode.next = StackTop; // link the new node to the current first node
            StackTop = newNode;// update the list to start with the new node


        }
    }
    public void pop()
    {
        //complete this method
        if (StackTop == null){ //empty list. Condition never met because the main program blocks the removeFirstNode()
            // method from being called with an empty list. just left in for clarity.

            System.out.println("there is nothing to remove");//there is nothing to remove
        }
        else{ //list is not empty

            StackTop =  StackTop.next ;  //Changes what the first node points to.
            // Making it point to the second node, effectively removing it
            size--;
        }
    }
    public T top()
    {
        return StackTop.data; //returns the data at the top of the stack

    }
    public int size()
    {
        return size; //returns the size of the stack

    }
    public void printStack() //prints stack
    {
        Node temp; //initialize temp value - used to move up the stack
        temp = StackTop; //start at the top of the stack

        while (temp != null)  //while there are still elements in the list
        {
            System.out.print(temp.data + "   "); //print out the data at the current node
            temp = temp.next; //move up the next node
        }
    }

    private class Node //defines the Node class inside MyStack (so it’s only used by your stack).
    {
        private T data;  //each node stores one value of type T.
        private  Node next; //each node stores a reference to another Node.

        public Node(T item) //constructor method for Node
        {
            data = item; // store the item in this node
            next = null;  // nothing comes after it yet
        }
    }


}
