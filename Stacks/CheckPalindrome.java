/*
 * IDE:         IntelliJ
 */


import java.util.Scanner;

public class CheckPalindrome {


    public static void main (String[] args)
    {
        MyStack<Character> stack = new MyStack<>();//creates a character stack using my generic MyStack class

        int option = 0; //initialize option variable for main menu choice
        Scanner scanner = new Scanner (System.in); //create scanner
        String originalString = ""; //initialize a new string
        String result = "";
        while(option != 3){ //while the user hasn't selected option #3 (exit program)

            mainMenu(); //display main menu and prompt user to enter an option

            option = scanner.nextInt(); //User input for menu choice
            scanner.nextLine();//consumes leftover newline

            switch (option) { //does an action/operation based on the option variable
                case 1 -> {
                    //option #1 – Read input string of words
                    System.out.print("\nEnter a string: "); // Prompt user to input string of words
                    originalString = scanner.nextLine(); //the user's string
                    System.out.println(); //creates new line
                }
                case 2 -> {
                    //option #2 - Reverse string and display outputs

                    if(originalString.isEmpty() ){//if the original string is empty
                        System.out.println("\nPlease enter a string first.\n"); //Tell the user that they need to enter a string first
                    }else{
                        System.out.println("\nEntered string:   " + originalString); // Prompt user to input string of words

                        String normalizedOG = originalString.replaceAll("[^a-zA-Z0-9]", "") ;//removes anything that is not a letter or number
                        normalizedOG = normalizedOG.toLowerCase(); //makes the normalized string lowercase


                        // Loop through each character in the normalized string
                        for(int i = 0; i < (normalizedOG.length()); i++){
                            stack.push(normalizedOG.charAt(i));//pushes the character at index(i) to the top of the stack
                        }

                        String reversed = "";//declare a new string "reversed" - it will hold the normalized original string but reversed

                        //effectively reverses the normalized string
                        while(!stack.empty()){ //while the stack is not empty
                            reversed += stack.top(); //add the top element (a character) to the new string
                            stack.pop(); //then pop it
                        }

                        if(normalizedOG.equals(reversed)){ //if the original string equals the reversed string
                            result = "Palindrome"; //it is a palindrome
                        }else{ //the original string is not equal to the reversed string
                            result = "Not Palindrome"; //it is not a palindrome
                        }

                        System.out.println("Judgement:        " + result + "\n"); //informs user that they are viewing their string but in reverse

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
        System.out.println("-----------------MAIN MENU----------------");
        System.out.println("1 – Read input string");
        System.out.println("2 – Check palindrome and display output");
        System.out.println("3 - Exit program");

        System.out.print("\nEnter option number: "); //prompt user to enter an option


    }
}

