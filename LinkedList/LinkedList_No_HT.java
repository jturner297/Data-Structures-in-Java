// Name:            Justin Turner
// Class:	        CS 3305/W01
// Term:		    Fall 2025
// Instructor:      S. Perry
// Assignment:      3
// IDE Name:	    Intellij


/*
  This class define a linked list that stores integer values.
  The class does NOT use Head and Tail pointer as the textbook class deos.
*/

public class LinkedList_No_HT
{
    public Node ListName;
    boolean isEmptyFlag; //flag for empty list
    //constructor method to create a list object with a specifc name.
    public LinkedList_No_HT()
    {
        ListName = null;   // list starts empty
        isEmptyFlag = true;   // flag is true when list is empty
    }

    public boolean isEmpty()//checks if the list is empty
    {
        // If there are no nodes, ListName will be null and the method will return as true, false otherwise
        return ListName == null;
    }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
       //data = value of the new node
       if (ListName == null) //if the list is empty
           ListName = new Node(data); //create a one node list
       else // else the list is not empty
       {
           //traverse the list until reaching the last node

           //create a temporary variable used to traverse
           Node temp = ListName; //it points to the start of the list

           while (temp.next != null)//keep moving the temp variable up until the next node is null
           {
               temp = temp.next; //move temp up
           }
           //once the next node is null, we know that we have reached the end of the list, so we can add our new node
           temp.next = new Node(data); //link new node to the end of the list
       }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   public void addFirstNode(int data) //Adds a new node to the front of the list
   {
       //data = value of the new node
       //complete this method

       if (ListName == null){ //if the list is empty
           ListName = new Node(data); // create the first node with the given value
       }
       else{ //list is not empty
           Node newNode = new Node(data); // create a new node with the given value


           newNode.next = ListName; // link the new node to the current first node
           ListName = newNode;// update the list to start with the new node
       }
   }

     
      
   //method #2: add node at index
   public void addAtIndex(int index, int data)
   {
       // data = value of the new node
       // index = location the new node will be added at

       //complete this method
       Node newNode = new Node(data); //create new node that holds the given value

       if (index == 0){ //if the index is 0, add the node to start/beginning
           addFirstNode(data);  // reuse the addFirstNode method
       }
       else if(index >= countNodes()){ //if the index is at or beyond the end
           addLastNode(data);// reuse the addFirstNode method
       }
       else{ //index is somewhere in the middle

           //traverse the list
           Node current = ListName;  // start at the first node

           //move up until one position before the target index
           for(int i = 1; i < index; i++){
               current = current.next; //move up
           }
           Node temp = current.next; //temporarily store the node that comes after current (like a bookmark)
           current.next = new Node(data); //link the new node after current
           current.next.next = temp;// Connect the new node to the rest of the list
       }
   }
      
      
   //method #3: remove first node
   public void removeFirstNode()
   {
       //complete this method
       if (ListName == null){ //empty list. Condition never met because the main program blocks the removeFirstNode()
                              // method from being called with an empty list. ust left in for clarity.

           System.out.println("there is nothing to remove");//there is nothing to remove
       }
       else{ //list is not empty

           ListName =  ListName.next ;  //Changes what the first node points to.
                                        // Making it point to the second node, effectively removing it

       }
   }
      
      
   //method #4: remove last node
   public void removeLastNode()
   {
         //complete this method
       if (ListName == null){//empty list. Condition never met because the main program blocks the removeLastNode()
                            // method from being called with an empty list. Just left in for clarity.

           System.out.println("Empty List"); //nothing
       }
       else if(ListName.next == null){//list has only one node
           ListName = null; //delete the one node
       }
       else //the list has more than one node
       {
           //Find the last node and delete it
           Node current = ListName; //start at the first index
           while (current.next.next != null) { //traverse the list and stop at second-to-last node
               current = current.next; //move up
           }//after loop current will now point to the node right before the last one

           // (current -> end)
           // (current.next = end)
           // delete the last node

           current.next = null;
           //end = 0;




       }
   }

    
   //method #5: remove node at index
   public void removeAtIndex(int index)
   {
       // index = position of the node to be removed

       // complete this method
       if (index == 0){ //if the index is at the start
           removeFirstNode();//reuse removeFirstNode();
       }
       else if(index == (countNodes() - 1)){//if the index is at the end
           removeLastNode(); //reuse removeLastNode();
       }
       else{ //the index is somewhere in the middle

           //create temporary value to traverse the list
           Node previous = ListName; //start at first index
           for(int i = 1; i < index; i++){ //traverse
               previous = previous.next; //move up until it stops at the node right before the one you want to delete
           } // after loop previous will point to the node right before the one to be deleted

           // (previous -> targetNode -> targetNode.next)

           Node current = previous.next;// current points to the node to be removed
           // (previous -> current -> current.next)
           previous.next = current.next; //previous.next now skips over current and points to the node after it, effectively deleting it
           // (previous  -> current.next -> current.next.next)
       }
   }
          
   //method #6: countNodes
   public int countNodes()
   {
       int listSize= 0; //tracks the size of the list as the loop traverse through it

       Node temp = ListName; //start at the first element

       while (temp != null) //traverse through the list until it reaches the end
       {
           temp = temp.next; //move up
           listSize++; //increments
       }

      
      //complete this method to return the list size.
        
      return listSize; //return the size
   }

   
   //method #7: pritnInReverse (must be a Recursive method)
   public void printInReverseRecursive(Node L)
   {
       //complete this method as recursive method to ptint the list in revers order.

       // Prints the elements of the linked list in reverse order using recursion.
       // L = current node being processed

       if(L == null){ //base case, no more nodes
           return; //end recursion
       }
       printInReverseRecursive(L.next);  // Recursive step: go to the next node
       System.out.print(L.data + "   ");// Print the current node after all subsequent nodes
   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = ListName;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

