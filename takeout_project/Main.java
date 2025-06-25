import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    FoodMenu menu = new FoodMenu();
    System.out.println(menu);
    System.out.println(menu.getLowestCostFood());
  }    
}