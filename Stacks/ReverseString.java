/*
 * IDE:         IntelliJ
 */


import java.util.Scanner;

public class ReverseString {


    public static void main (String[] args)
    {
        MyStack<String> stack = new MyStack<>();//creates an string stack using my generic MyStack class

        int option = 0; //initialize option variable for main menu choice
        Scanner scanner = new Scanner (System.in); //create scanner
        String newString = ""; //initialize a new string

        while(option != 3){ //while the user hasn't selected option #3 (exit program)

            mainMenu(); //display main menu and prompt user to enter an option

            option = scanner.nextInt(); //User input for menu choice
            scanner.nextLine();//consumes leftover newline

            switch (option) { //does an action/operation based on the option variable
                case 1 -> {
                    //option #1 – Read input string of words
                    System.out.print("\nEnter a string: "); // Prompt user to input string of words
                    newString = scanner.nextLine(); //the user's string
                    System.out.println(); //creates new line
                }
                case 2 -> {
                    //option #2 - Reverse string and display outputs

                    if(newString.isEmpty()){//if the user has not entered a string
                        System.out.println("\nPlease enter a string first.\n"); //tell them that they need to enter a string
                    }else{ //they have entered a string
                        System.out.println("\nEntered string:   " + newString); //Informs the user that thet are viewing their entered string
                        String[] words = newString.split(" "); //creates an array called words that holds the words that make of the string

                        for(String word : words){ //goes through every element in the array words from start to finish
                            stack.push(word); //pushing each word starting at the first one onto the stack
                        }

                        System.out.print("Reversed string:  "); //informs user that they are viewing their string but in reverse

                        while(!stack.empty()){ //while the stack is not empty
                            System.out.print(stack.top() + " "); //print out the current top element
                            stack.pop(); //then pop it
                        }
                        System.out.println("\n"); //create new line

                    }



                }

                case 3 -> {
                    // option #3 - Exit program

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
        System.out.println("-----------------MAIN MENU---------------");
        System.out.println("1 – Read input string of words");
        System.out.println("2 – Reverse string and display outputs");
        System.out.println("3 - Exit program");

        System.out.print("\nEnter option number: "); //prompt user to enter an option


    }
}

