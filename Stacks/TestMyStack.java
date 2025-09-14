/*
 * Class:       CS 3305/W01
 * Term:        Fall 2025
 * Name:        Justin Turner
 * Professor:   Sharon Perry
 * Assignment:  4
 * IDE:         IntelliJ
 */


import java.util.Scanner;

public class TestMyStack {
    public static void main (String[] args)
    {
        MyStack<Integer> stack = new MyStack<>();//creates an integer stack using my generic MyStack class

        int option = 0; //initialize option variable for main menu choice
        Scanner scanner = new Scanner (System.in); //create scanner

        while(option != 7){ //while the user hasn't selected option #7 (exit program)

            mainMenu(); //display main menu and prompt user to enter an option

            option = scanner.nextInt(); //User input for menu choice
            scanner.nextLine();//consumes leftover newline

            switch (option) { //does an action/operation based on the option variable
                case 1 -> {
                    //option #1 - Push element
                    System.out.print("\nEnter a value: "); // prompt users to enter a value for new element
                    int newValue = scanner.nextInt(); //the value of the element to be added to the top

                    System.out.println("\nPushing value " + newValue + " to the top of the stack."); //Informs user that their value will be added to the top
                    System.out.print("The stack before pushing " + newValue + " to the top:   "); //Informs user that they are viewing the previous stack
                    stack.printStack(); //Calls the printStack method

                    stack.push(newValue); //adds the user's value to the top of the stack

                    System.out.print("\nThe stack after pushing " + newValue + " to the top:    ");//Informs user that they are viewing the new list contents
                    stack.printStack(); //Calls the printStack method

                    System.out.println("\n"); //creates new lines
                }
                case 2 -> {
                    //option #2 - Pop element
                    if(stack.empty()){ //if the stack is empty
                        System.out.println("Stack is Empty\n"); //inform the user that the stack is empty
                    }else{ //stack is not empty
                        System.out.println("\nPopping the top element of the stack."); //Informs user that the top element will be popped
                        System.out.print("The stack before popping the top element:   "); //Informs user that they are viewing the previous stack contents
                        stack.printStack(); //Calls the printStack method

                        System.out.print("\nThe stack after popping the top element:    "); //Informs user that they are viewing the new stack contents
                        stack.pop(); //pops the top of the stack
                        stack.printStack(); //Calls the printStack method

                        System.out.println("\n"); //creates new lines
                    }

                }

                case 3 -> {
                    // option #3 - Get top element
                    if (stack.empty()){ //if the stack is empty....
                        System.out.println("\nStack is Empty\n"); //inform the user that the stack is empty, so there is no top element
                    }
                    else{ // the stack is not empty

                        System.out.println("\nTop element:    " + stack.top()); //tell the user the top element

                        System.out.print("Current stack:  "); //Lets the user know that they are viewing the stack
                        stack.printStack();//Calls the printStack method
                        System.out.println("\n"); //tell the user the top element

                    }
                }
                case 4 -> {
                    // option #4 - Get stack size
                    System.out.println("\nStack size: " + stack.size() + "\n"); //print the stack's size
                }
                // option #5 - Check if stack empty
                case 5 -> {
                    if (stack.empty()){ //if the stack is empty....
                        System.out.println("\nStack is Empty\n"); //inform the user that the stack is empty
                    }
                    else{ // the stack is not empty
                        System.out.println("\nStack is not Empty\n"); //inform the user that the stack is not empty
                    }
                }
                // option #6 - View stack
                case 6 -> {
                    if (stack.empty()){ //if the stack is empty....
                        System.out.println("The stack is empty, so there is nothing to print"); //inform the user that there is nothing to print
                    }
                    else{ // the stack is not empty
                        System.out.print("Current stack:  ");  //Lets the user know that they are viewing the stack
                        stack.printStack();//Calls the printStack method
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
        System.out.println("--------MAIN MENU-------");
        System.out.println("1 – Push element");
        System.out.println("2 – Pop element ");
        System.out.println("3 – Get top element");
        System.out.println("4 – Get stack size");
        System.out.println("5 – Is empty stack?");
        System.out.println("6 – Print stack");
        System.out.println("7 - Exit program");

        System.out.print("\nEnter option number: "); //prompt user to enter an option


    }
}
