import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String customerName = input.nextLine();

        int money = 0;
        while (true) {
            System.out.print("Enter your starting money: ");
            try {
                money = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid int input");
                input.next(); // clear invalid input
            }
        }

        Customer customer = new Customer(customerName, money);
        TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, input);
        takeOutSimulator.startTakeOutSimulator();
    }
}