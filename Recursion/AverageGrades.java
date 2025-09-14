/*
 * Class:       CS 3305/W01
 * Term:        Fall 2025
 * Name:        Justin Turner
 * Professor:   Sharon Perry
 * Assignment:  2
 * IDE:         IntelliJ
 */
import java.util.Scanner;

public class AverageGrades {

    public static void main(String[] args){
        int option = 0; //variable for picking an option in main menu
        int classSize = 0; //number of students in the class


        int[] grades = new int[0]; //array that holds the grades for each student in the class
        double classAverage = 0; //variable that holds the class average

        boolean isClassSizeEntered = false; //flag for detecting if a class size is entered
        boolean isGradesEntered = false;//flag for detecting if grades are entered

        Scanner scanner = new Scanner (System.in); //create scanner to handle user input

        while(option != 4) { //while the player has not picked option #3

            mainMenu();//display options
            option = scanner.nextInt(); //consumes leftover newline

            scanner.nextLine();
            switch (option) {
                //Option #1 - Read Class Size
                case 1 -> {


                    isGradesEntered = false; //sets to false since grades cannot be entered without class size information
                    //set to false because we do not have the class size info yet

                    while(true){ //loop that ensures that user will eventually enter a valid input

                      System.out.print("\nEnter the size of the class: "); //prompt user to enter the class size
                      classSize = scanner.nextInt(); //get input

                      if (classSize > 0 ) { //if the entered class size is greater than 0

                          grades = new int[classSize]; // reset grades, because new class size requires new grades to be assigned

                          isClassSizeEntered = true; //sets to true because class size information is ready
                          break;//break out of loop

                      } else {//class size invalid (less than or equal to 0)
                          System.out.println("Invalid class size! Please enter a value above 0.");
                      }
                  }

                    System.out.println();//skips a line
                }

                //Option #2 - Read Class Grades
                case 2 -> {
                    if(isClassSizeEntered){//only allow grades to be entered if the class size is entered

                        System.out.println("\nEnter grades");//prompt user to enter grades

                        for (int i = 0; i < grades.length; i++) {

                            while(true){//loop that ensures that user will eventually enter a valid input
                                System.out.print("Student " + (i+1) + ": "); //Shows the student # that grade will be associated with
                                grades[i] = scanner.nextInt(); //get input

                                if (grades[i] >= 0 && grades[i] <= 100) {//if the entered grade is valid (not negative or 100+)

                                    isGradesEntered = true; //sets to true because grades information is ready
                                    break; // exit the while loop, grade is valid

                                } else { //invalid grade entered
                                    System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                                }
                            }



                        }
                        System.out.println();//skip line
                    }
                    else{ //the player has not entered the class size
                        System.out.println("Please enter the size of the class first.");
                    }

                }

                //Option #3 - Compute Class Average
                case 3 -> {
                    if(isClassSizeEntered && isGradesEntered ){//if both the class size and the grades are entered...

                        System.out.printf( "\nYou entered class size: %3d" , classSize);
                        System.out.print( "\nYou entered grades:       " );
                        for (int grade : grades) {
                            System.out.printf("%d ", grade); // prints each grade with a space
                        }
                        System.out.printf( "\nClass average:            %.2f", ((findAverage(grades, 0))/grades.length) );
                        System.out.println("\n");
                    }
                    else{ //neither information is present
                        System.out.println("More information is needed for calculations!");
                    }


                }

                //Option #4 - Exit Program
                case 4 -> { //option #4
                    scanner.close(); //close scanner
                    System.out.println("\nClosing the program...");
                }

                //invalid number entered
                default -> {
                    System.out.println("\nThat is not a valid option!\n");
                }
            }
        }

    }




    public static void mainMenu(){//handles main menu display
        System.out.println("---------MAIN MENU---------");
        System.out.println("1. Read class size");
        System.out.println("2. Read class grades");
        System.out.println("3. Compute class average");
        System.out.println("4. Exit program");

        System.out.print("\nEnter option number: ");
    }

    public static double findAverage(int[] studentGrades, int n){//recursively finds the average

        if(n == studentGrades.length){ //if there are no more grades
            return 0; //base case reached, no more letters to check
        }
        return studentGrades[n] + findAverage(studentGrades, n + 1 );//summing


    }




}
