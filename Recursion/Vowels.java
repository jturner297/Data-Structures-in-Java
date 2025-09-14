/*
 * IDE:         IntelliJ
 */
import java.util.Scanner;

public class Vowels {
    public static void main(String[] args){
        int option = 0; //controls menu options
        String inputString = "";//initialize inputString variable
        Scanner scanner = new Scanner (System.in); //create scanner
        while(option != 3) { //while the player has not picked option #3

            mainMenu();//displays menu
            option = scanner.nextInt(); //User input for menu choice

            scanner.nextLine();//consumes leftover newline


            switch (option) {

                //option #1 - Read input string
                case 1 -> {
                    System.out.print("\nEnter a string: ");//prompt user to enter string
                    inputString = scanner.nextLine(); //User enters string
                    System.out.println(); //end line
                }

                //option #2 - Compute number of vowels
                case 2 -> {
                    if (inputString.isEmpty()){ //if the User's string is empty
                        System.out.println("\nYour string is empty\n");
                    }
                    else{ //the user's string is not empty, so we can compute the number of vowels
                        computeNumOfVowels(inputString.toLowerCase());//computes the vowels recursively
                    }
                }

                //option #3 - Exit program
                case 3 -> {
                    System.out.println("\nClosing the program..."); //informs the user that program is closing
                    scanner.close(); //shut down the scanner
                }

                //invalid number entered
                default -> {
                    System.out.println("\nThat is not a valid option!\n");
                }
            }
        }
    }

  public static void mainMenu(){ //Handles the main menu display
        System.out.println("---------MAIN MENU---------");
        System.out.println("1. Read input string");
        System.out.println("2. Compute number of vowels");
        System.out.println("3. Exit program");

        System.out.print("\nEnter option number: ");
    }


    public static void computeNumOfVowels(String userString){ //Calls the recursive method
        System.out.println("\nYou entered string: " + userString);
        System.out.println("Number of vowels:   " + countVowels(userString, 0) + "\n");//print number of vowels
    }


    public static int countVowels(String userString, int n){//Recursively counts the number of vowels
        if(n == userString.length()){ //if n has reached the end of the string
            return 0; //base case reached, no more letters to check
        }
        switch (userString.charAt(n)) {

            // Character at index is a vowel (a,e,i,o,u)
            case 'a', 'e', 'i', 'o', 'u' -> {
                return 1 + countVowels(userString, n + 1); //add to vowel count
            }

            // Character at index is not a vowel
            default -> {
                return countVowels(userString, n + 1);  //vowel count stays the same
            }
        }
    }
}

