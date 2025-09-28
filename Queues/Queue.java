
/*
 * IDE:         IntelliJ
 */



public class Queue<T> { //declare a generic class myQueue

        private Node QueueFront = null; // holds the link to the Queue’s first element
        private int size; //holds the queue size


        public Queue(){//constructor method for Queue
            QueueFront = null; //stack starts empty
            size = 0;//initial size is 0
        }

        public boolean empty()//checks if the list is empty
        {
            // If there are no nodes, Top will be null and the method will return as true, false otherwise
            return QueueFront == null;
        }

      public void enqueue(T element) //Adds a new node to the back of the list (queue)
    {
        //data = value of the new node
        if (QueueFront == null)    //if the list is empty
        {

            QueueFront = new Node(element); //create a one node list
            size = 1; //size is now one since one element got added
        }

        else // else the list is not empty
        {
            //traverse the list until reaching the last node

            //create a temporary variable used to traverse
            Node temp = QueueFront; //it points to the start of the list

            while (temp.next != null)//keep moving the temp variable up until the next node is null
            {
                temp = temp.next; //move temp up
            }
            //once the next node is null, we know that we have reached the end of the list, so we can add our new node
            temp.next = new Node(element); //link new node to the end of the list
            size++;  //increase the size
        }
    }
    

        public void dequeue() {
            if (this.QueueFront == null) {//if the queue is empty
                System.out.println("there is nothing to remove");
            } else { //the queue is not empty
                this.QueueFront = this.QueueFront.next; //move the front of the queue to the next item, removing the old front
                size--; //decrease size
            }

        }

        public T front()
        {
            return QueueFront.data; //returns the data at the front of the queue
        }

    public int size()
    {
        return size; //returns the size of the queue

    }


    public void printQueue() //prints Queue
    {
        Node temp; //initialize temp value - used to move up the Queue
        temp = QueueFront; //start at the top of the Queue

        while (temp != null)  //while there are still elements in the list
        {
            System.out.print(temp.data + "   "); //print out the data at the current node
            temp = temp.next; //move up the next node
        }
    }
        private class Node { //defines the Node class inside MyQueue (so it’s only used by your queue).

            private T data;  //each node stores one value of type T.
            private Node next; //each node stores a reference to another Node.

            public Node(T item) { //constructor method for Node

                data = item;  // store the item in this node
                next = null; // nothing comes after it yet
            }
        }
}



