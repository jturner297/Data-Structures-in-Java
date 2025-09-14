import java.util.Scanner;

public class RecursionPractice {
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in); //create scanner
        System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();

    stars(number);

    }
    public static void  stars(int number){

        if (number == 0){

        return;
    }
        System.out.print("*");
     stars(number-1);
    }
}
