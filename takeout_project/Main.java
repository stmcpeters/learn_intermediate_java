import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
//    System.out.println("creating new instance of food");
    Food breakfast = new Food("eggs", "eggs with cheese", 5);
    Food lunch = new Food("chicken", "yum", 2);
//    System.out.println("creating new instance of shopping bag that'll hold Food");
    ShoppingBag<Food> bag = new ShoppingBag<>();
//    System.out.println("adds new food item to bag");
    bag.addItem(breakfast);
    bag.addItem(breakfast);
    bag.addItem(lunch);
//    System.out.println("will print item and quantity?");
    System.out.println(bag.getTotalPrice());
  }    
}