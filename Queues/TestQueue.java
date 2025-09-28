/*
 * IDE:         IntelliJ
 */


import java.util.Scanner;


public class TestQueue
{
    public static void main (String[] args){
        Queue<Integer> queue = new Queue<>();//create a queue object of type integer

        int option = 0; //initialize option variable for main menu choice
        Scanner scanner = new Scanner (System.in); //create scanner


        while(option != 7){ //while the user hasn't selected option #7 (exit program)

            mainMenu(); //display main menu and prompt user to enter an option

            option = scanner.nextInt(); //User input for menu choice
            scanner.nextLine();//consumes leftover newline

            switch (option) { //does an action/operation based on the option variable
                case 1 -> {
                    //option #1 - Enqueue  element
                    System.out.print("\nEnter a value: "); // prompt users to enter a value for new element
                    int newValue = scanner.nextInt(); //the value of the element to be added to the queue

                    System.out.println("\nAdding value " + newValue + " to the back of the queue."); //Informs user that their value will be added to the queue
                    System.out.print("The queue before adding " + newValue + " to the back:   "); //Informs user that they are viewing the previous queue
                    queue.printQueue(); //Calls the printQueue method

                    queue.enqueue(newValue); //adds the user's value the queue

                    System.out.print("\nThe queue after adding " + newValue + " to the back:    ");//Informs user that they are viewing the new list contents
                    queue.printQueue(); //Calls the printQueue method

                    System.out.println("\n"); //creates new lines
                }
                case 2 -> {
                    //option #2 - Dequeue element
                    if(queue.empty()){ //if the queue is empty
                        queueEmptyMessage();
                    }else{ //queue is not empty
                        System.out.println("\nRemoving the first element of the queue."); //Informs user that the first element will be popped
                        System.out.print("The queue before removing the first element:   "); //Informs user that they are viewing the previous queue contents
                        queue.printQueue(); //Calls the printQueue method

                        System.out.print("\nThe queue after removing the first element:    "); //Informs user that they are viewing the new queue contents
                        queue.dequeue(); //pops the top of the queue
                        queue.printQueue(); //Calls the printQueue method

                        System.out.println("\n"); //creates new lines
                    }

                }

                case 3 -> {
                    // option #3 - Get front element
                    if (queue.empty()){ //if the queue is empty....
                        queueEmptyMessage();
                    }
                    else{ // the queue is not empty

                        System.out.println("\nFront element:    " + queue.front()); //tell the user the top element

                        System.out.print("Current queue:  "); //Lets the user know that they are viewing the queue
                        queue.printQueue();//Calls the printQueue method
                        System.out.println("\n"); //create new line

                    }
                }
                case 4 -> {
                    // option #4 - Get queue size
                    System.out.println("\nQueue size: " + queue.size() + "\n"); //print the queue's size
                }
                // option #5 - Check if queue empty
                case 5 -> {
                    if (queue.empty()){ //if the queue is empty....
                        queueEmptyMessage();//tell user the queue is empty
                    }
                    else{ // the queue is not empty
                        System.out.println("\nQueue is not Empty\n"); //inform the user that the queue is not empty
                    }
                }
                // option #6 - View queue
                case 6 -> {
                    if (queue.empty()){ //if the queue is empty....
                        System.out.println("The queue is empty, so there is nothing to print\n"); //inform the user that there is nothing to print
                    }
                    else{ // the queue is not empty
                        System.out.print("Current queue:  ");  //Lets the user know that they are viewing the queue
                        queue.printQueue();//Calls the printQueue method
                        System.out.println("\n"); //creates new line
                    }
                }
                case 7 -> {
                    // option #7 - Exit program

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

    public static void mainMenu(){
        // Prints out the main menu
        System.out.println("--------MAIN MENU--------");
        System.out.println("1 – Enqueue element");
        System.out.println("2 – Dequeue element");
        System.out.println("3 – Get front element");
        System.out.println("4 – get queue size");
        System.out.println("5 – Is Empty queue?");
        System.out.println("6 - Print queue");
        System.out.println("7 - Exit program");

        System.out.print("\nEnter option number: "); //prompt user to enter an option


    }
    public static void queueEmptyMessage(){//message for empty queue
        System.out.println("\nQueue is Empty\n"); //inform the user that the queue is empty, so there is no top element
    }



}
