// IDE Name:	    Intellij


import java.util.Scanner; //import scanner for user input

public class myTest_No_HT
{
   public static void main (String[] args)
   {
       LinkedList_No_HT myList = new LinkedList_No_HT(); //create a list object
       int option = 0; //initialize option variable for main menu choice
       Scanner scanner = new Scanner (System.in); //create scanner

       while(option != 10){ //while the user hasn't selected option #10 (exit program)

           mainMenu(); //display main menu and prompt user to enter an option

           option = scanner.nextInt(); //User input for menu choice
           scanner.nextLine();//consumes leftover newline

           switch (option) { //does an action/operation based on the option variable
               case 1 -> {
                   // option #1 - Add First Node

                   // Calls the addNode function
                   addNode(1, scanner, myList);
               }
               case 2 -> {
                   // option #2 - Add Last Node

                   // Calls the addNode function
                   addNode(2, scanner, myList);
               }

               case 3 -> {
                   // option #3 - Add at index  Node

                   // Calls the addNode function
                   addNode(3, scanner, myList);
               }
               case 4 -> {
                   // option #4 - Remove First Node

                   // Calls the removeNode function
                   removeNode(4, scanner, myList);
               }

               case 5 -> {
                   // option #5 - Remove Last Node

                   // Calls the removeNode function
                   removeNode(5, scanner, myList);
               }
               case 6 -> {
                   // option #6 - Remove At Index

                   // Calls the removeNode function
                   removeNode(6, scanner, myList);
               }
               case 7 -> {
                   // option #7 – Print List Size

                   System.out.println("\nList size:  " + myList.countNodes()); //Shows the user the size of the linked list
                   System.out.println(); //creates new lines
               }
               case 8 -> {
                   // option #8 – Print List Forward


                   if(myList.isEmpty()){ //if the list is empty
                       System.out.println("\nThere is no list content to print.\n"); //tell the user that there is nothing to print
                   }
                   else{//the list is not empty
                       System.out.print("\nList content:  "); //Tells the user that they are viewing the current list contents
                       myList.printList(); //Calls the printList method of linked list object myList.
                       System.out.println("\n"); //creates new lines
                   }
               }
               case 9 -> {
                   // option #9 – Print List In Reverse


                   if(myList.isEmpty()){//if the list is empty
                       System.out.println("\nThere is no list content to print.\n");//tell the user that there is nothing to print
                   }
                   else{//the list is not empty
                       System.out.print("\nList content in reverse:  " ); //Tells the user that they are viewing the current list contents in reverse
                       myList.printInReverseRecursive(myList.ListName); //Calls printInReverseRecursive to display the elements of the linked list in reverse order
                       System.out.println("\n");//creates new lines
                   }

               }
               case 10 -> {
                   // option #10 - Exit program

                   System.out.println("\nClosing the program..."); //informs the user that program is closing
                   scanner.close(); //shut down the scanner
               }
               default -> {
                   //invalid number entered

                   System.out.println("\nThat is not a valid option!\n");//informs user of invalid input
               }
           }
       }
   }



    public static int getValidIndex(Scanner scanner, int index, LinkedList_No_HT myList, boolean allowEnd){
        // Gets a valid index value from user input
        // index    = location of the node to be removed or added
        // scanner  = scanner object used to read input for the nodes's value
        // myList   = linked list object; where the node will be added
        // allowEnd = flag that certifies whether the user will be allowed to enter an index value equal to the list size
        //            (used when adding a node at the end of the list)

        while(true){ //loop that ends when the user enters a valid index size
           System.out.print("Enter an index: "); // prompt user
           index = scanner.nextInt(); //user's index value

           // if the operation type allows the end index to be included use (myList.countNodes()) as the max index, if
           // not use (myList.countNodes() - 1) as the max index
           int maxIndex = allowEnd ? myList.countNodes() : myList.countNodes() - 1;

           if(index < 0 || index > maxIndex){ //if the index value is less than 0 or greater than the maxIndex
               System.out.println("\nInvalid index, try again"); //inform the user that their chosen index is invalid/out of bounds
           } else break;//User has entered a valid value, so break out of loop
       }
       return index; //return the user's index value
    }



    public static void addNode(int option, Scanner scanner, LinkedList_No_HT myList) {
        // takes in a value and adds it as either the first,last, or specified index based on the option picked in the menu
        // option  = operation type requested
        // scanner = scanner object used to read input for the nodes's value
        // myList  = linked list object; where the node will be added

        System.out.print("\nEnter a value: "); // prompt users to enter a value for the node
        int newNodeValue = scanner.nextInt(); //the value of the node that will be added

        if (option == 1) { // Option #1 - Add First Node
            System.out.println("\nAdding value " + newNodeValue + " as first node."); //Informs user that their value will be added as the first node
            System.out.print("List content before adding " + newNodeValue + " is:   "); //Informs user that they are viewing the previous list contents
            myList.printList(); //Calls the printList method of linked list object myList.

            myList.addFirstNode(newNodeValue); //adds the user's value to the first node

            System.out.print("\nList content after adding " + newNodeValue + " is:    ");//Informs user that they are viewing the new list contents
            myList.printList(); //Calls the printList method of linked list object myList.

            System.out.println("\n"); //creates new lines
        }
        else if (option == 2) { // Option #2 - Add Last Node

            System.out.println("\nAdding value " + newNodeValue + " as last node."); //Informs user that their value will be added as the last node
            System.out.print("List content before adding " + newNodeValue + " is:   "); //Informs user that they are viewing the previous list contents
            myList.printList(); //Calls the printList method of linked list object myList.

            System.out.print("\nList content after adding " + newNodeValue + " is:    "); //Informs user that they are viewing the new list contents
            myList.addLastNode(newNodeValue);//adds the user's value to the last node
            myList.printList(); //Calls the printList method of linked list object myList.

            System.out.println("\n"); //creates new lines
        }
        else if (option == 3){ // Option #3 - Add Node at Index

            int index = getValidIndex(scanner, option, myList, true); //Gets a valid index value from user input

            System.out.println("\nAdding value " + newNodeValue + " at index " + index + "."); //Informs user that their value will be added at their specified index
            System.out.print("List content before adding " + newNodeValue + " at index " + index + " is:   "); //Informs user that they are viewing the previous list contents
            myList.printList(); //Calls the printList method of linked list object myList.

            System.out.print("\nList content after adding " + newNodeValue + " at index " + index + " is:    ");//Informs user that they are viewing the new list contents
            myList.addAtIndex(index, newNodeValue); //adds the user's value to the specified index
            myList.printList(); //Calls the printList method of linked list object myList.

            System.out.println("\n"); //creates new lines
        }
    }
    public static void removeNode(int option, Scanner scanner, LinkedList_No_HT myList) {
        // Removes the node at either the first,last, or a specified index based on the option picked in the menu
        // option  = operation type requested
        // scanner = scanner object used to read input for the nodes's value
        // myList  = linked list object; where the node will be added

       if(myList.isEmpty()){ //if the linked list is empty
            System.out.println("List is Empty\n"); //inform the user that the list is empty
        }
        else{ //the list is not empty

            if (option == 4) { // Option #4 - Remove First Node

                System.out.println("\nMethod removeFirstNode()"); //Informs user that removeFirstNode() is being used
                System.out.print("List content before removing first node is:   "); //Informs user that they are viewing the previous list contents
                myList.printList(); //Calls the printList method of linked list object myList.

                System.out.print("\nList content after removing first node is:    "); //Informs user that they are viewing the new list contents
                myList.removeFirstNode(); //remove the first node
                myList.printList(); //Calls the printList method of linked list object myList.

                System.out.println("\n"); //creates new lines
            }
            else if (option == 5) { // Option #5 - Remove Last Node

                System.out.println("\nMethod removeLastNode()"); //Informs user that removeLastNode() is being used
                System.out.print("List content before removing last node is:  "); //Informs user that they are viewing the previous list contents
                myList.printList(); //Calls the printList method of linked list object myList.

                System.out.print("\nList content after removing last node is:   "); //Informs user that they are viewing the new list contents
                myList.removeLastNode(); //remove the last node
                myList.printList(); //Calls the printList method of linked list object myList.

                System.out.println("\n"); //creates new lines
            }
            else if(option == 6){ // Option #6 - Remove At Index

                int  index = getValidIndex(scanner, option, myList, false); //Gets a valid index value from user input

                System.out.println("\nMethod removeAtIndex()"); //Informs user that removeAtIndex() is being used
                System.out.print("List content before removing value at index " + index + " is:   "); //Informs user that they are viewing the previous list contents
                myList.printList(); //Calls the printList method of linked list object myList.

                System.out.print("\nList content after removing value at index " + index + " is:    ");
                myList.removeAtIndex(index); //remove the node at the specified index
                myList.printList(); //Calls the printList method of linked list object myList.

                System.out.println("\n"); //creates new lines
            }

        }



    }

    public static void mainMenu(){
        // Prints out the main menu
        System.out.println("---------MAIN MENU--------");
        System.out.println("1 – Add First Node");
        System.out.println("2 – Add Last Node");
        System.out.println("3 – Add At Index");
        System.out.println("4 – Remove First Node");
        System.out.println("5 – Remove Last Node");
        System.out.println("6 – Remove At Index");
        System.out.println("7 – Print List Size");
        System.out.println("8 – Print List Forward");
        System.out.println("9 – Print List In Reverse");
        System.out.println("10- Exit program");

        System.out.print("\nEnter option number: "); //prompt user to enter an option


   }
}
    

