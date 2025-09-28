/*
 * IDE:         IntelliJ
 */


import java.util.Scanner;


public class RadixSort
{
    public static void main (String[] args){


        int option = 0; //initialize option variable for main menu choice
        int arraySize = 0; //variable that corresponds to the array size

        int[] inputs = null; //initialize an empty array
        int value = 1; //variable used to fill in the array with user input



        Scanner scanner = new Scanner (System.in); //create scanner

        boolean arraySizeSet = false; //flag that indicates if the array size has been set
        boolean arrayFilled = false; //flag that indicates if the array has been filled

        while(option != 4){ //while the user hasn't selected option #7 (exit program)

            mainMenu(); //display main menu and prompt user to enter an option

            option = scanner.nextInt(); //User input for menu choice
            scanner.nextLine();//consumes leftover newline

            switch (option) { //does an action/operation based on the option variable
                case 1 -> {
                    //option #1 - Read array size
                    System.out.print("\nEnter the size of your array: "); // prompt users to enter the size for their array
                    arraySize = scanner.nextInt(); //the value of the element to be added to the queue
                    inputs = new int[arraySize];     // now the array is created
                    System.out.print("\n"); // prompt users to enter the size for their array
                    arraySizeSet = true; //set size set to true
                    arrayFilled = false; //set array filled to false, since the user has yet to enter new values for their newly sized array
                                        //this stops them from running out of data or incomplete data

                }
                case 2 -> {
                    //option #2 - Read array values
                    if(arraySizeSet){
                        System.out.println("\nEnter the values of your array."); // prompt users to enter the values for their array
                        for(int i = 0; i < arraySize; i++){ //loop that lets user enter a value for each index i
                            while(true){ //while loop that ensures the user eventually enters a valid value
                                System.out.print("Enter value #" + (i+1) +": "); //lets user know which index they are about to put the number in
                                value = scanner.nextInt(); //assign user input to value
                                if (value >= 0){ //if the value is non-negative...
                                    inputs[i] = value;// updates the array with the value the user just entered.
                                    if(i == arraySize-1){ // If we just filled the last index of the array...
                                        System.out.println("\nAll values entered successfully.\n");// inform the user that all array values have been successfully entered.
                                        arrayFilled = true; //set flag to true since the array is filled
                                    }
                                    break;//break out of loop
                                }
                                else{//the value is negative
                                    System.out.println("Invalid input! Please enter a non-negative value.");
                                }
                            }
                        }
                    }else{//the user has not entered the size of the array yet
                        System.out.println("Enter the size of the array first\n");//tell them to enter the size first
                    }
                }

                case 3 -> {
                    // option #3 - Sort
                    if(arraySizeSet && arrayFilled ){ //if the array is fully initialized
                        int maxDigits = 0; // initialize variable that tracks the max amount of digits of an element in the array
                        int digitCount = 0; //initialize variable that tracks digit count

                        int[] originalInputs= inputs.clone();//create a new array that holds the previous the array that we are about to sort
                        //find max digits
                        for(int input : inputs){ //find the maximum number of digits so that you know how many passes to do
                            digitCount = CountDigits(input); //Count how many digits this number has
                            if(digitCount > maxDigits){   //Update maxDigits if this number has more digits
                                maxDigits = digitCount;
                            }
                        }

                        //create queues
                        Queue<Integer>[] queues = new Queue[10]; // declare an array to hold 10 queues (for digits 0–9)
                        for (int i = 0; i < 10; i++) {
                            queues[i] = new Queue<>(); // initialize each queue
                        }


                        for(int place = 1; place <= maxDigits; place++){ // each pass sorts by one digit place

                            for (int num: inputs){  //  Distribute numbers into queues according to current digit
                                int digit = ExtractDigits(num, place);  // extract current digit
                                queues[digit].enqueue(num);    // put number into corresponding queue
                            }

                            //  Collect numbers back into array in order from Q0 to Q9 the smallest digit to largest
                            int index = 0; // index to insert back into array
                            for (int i = 0; i < 10; i++) { // loop through queues (10)
                                while (!queues[i].empty()) {    // while current queue is not empty; ensures we empty the queue before moving to next digit
                                    inputs[index++] = queues[i].front(); // get front element and assign to input[index]
                                    queues[i].dequeue(); // after copying the number into the array remove it from the queue
                                }
                            }
                        }
                        System.out.print("\nArray values before sorting:   "); //Tell the user that they are seeing the pre-sort array
                        for (int i = 0; i < originalInputs.length; i++) { //iterate through the cloned array
                            System.out.print(originalInputs[i]);
                            if (i != originalInputs.length - 1) { // only add comma if not last element
                                System.out.print(", ");
                            }
                        }
                        System.out.println(); // newline

                        System.out.print("Array values after sorting:    "); //Tell the user that they are seeing the post-sort array
                        for (int i = 0; i < inputs.length; i++) { //iterate through the new-sorted array
                            System.out.print(inputs[i]);
                            if (i != inputs.length - 1) { // only add comma if not last element
                                System.out.print(", ");
                            }
                        }
                        System.out.println("\n"); // extra newline
                    }
                    else{//the user has not fully initialized the array
                        System.out.println("\nYou have not fully initialized your array!\n");//tells the user that they need to finish initializing their array
                    }
                }
                case 4 -> {
                    // option #7 - Exit program
                    System.out.println("\nClosing the program..."); //informs the user that program is closing
                    scanner.close(); //shut down the scanner
                }
                default -> {
                    //invalid number entered
                    System.out.print("\nThat is not a valid option!\n");//informs user of invalid input
                }
            }
        }

    }

    public static void mainMenu(){
        // Prints out the main menu
        System.out.println("---------------MAIN MENU---------------");
        System.out.println("1 – Read array size");
        System.out.println("2 – Read array values");
        System.out.println("3 – Run Radix Sort and print outputs");
        System.out.println("4 – Exit program");


        System.out.print("\nEnter option number: "); //prompt user to enter an option


    }


    public static int CountDigits(int num) {
        if (num == 0){ //if the number is 0...
            return 1; // 0 has only 1 digit, we do not have to count anything
        }
        // else the number is greater than 0; we have to count

        int digits = 0; //initialize variable to count the digits

        //keep dividing the num by 10 until it becomes 0, that's how we know how many digits
        while (num > 0) {// while the number is greater than 0
            num = num / 10; //divide num by 10
            digits++; //increase digit count
        }
        return digits;
    }

    public static int ExtractDigits(int num, int digitPOS) { //extracts the digit at a given place(ones, tenths, hundredths)
        return (num / (int)Math.pow(10, digitPOS - 1)) % 10; // (number/10^(POS-1))%10
    }

}
