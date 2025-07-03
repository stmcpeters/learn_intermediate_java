import java.util.HashMap;
import java.util.Map;

public class ShoppingBag <T extends PricedItem<Integer>>{
//    instance fields
    private Map<T, Integer> shoppingBag;

//    constructor
    public ShoppingBag(){
        shoppingBag = new HashMap<>();
    }

//    methods
    public void addItem(T item){
        // checks if the item is not already in the HashMap
        if(shoppingBag.get(item) == null){
            // adds the item and sets the quantity to 1
            shoppingBag.put(item, 1);
        } else {
           // if the item exists, increment the quantity
            shoppingBag.put(item, shoppingBag.get(item) + 1);
        }
    }

    public Integer getTotalPrice(){
//        iterate through the HashMap
        // initialize totalPrice variable = 0
        // get the price of the item -- item.getPrice()
        // multiply the price by the quantity -- bag.get(item)
        // sum the totals for each item into the totalPrice
        int totalPrice = 0;
        for (T item : shoppingBag.keySet()){
            int price = item.getPrice();
            int quantity = shoppingBag.get(item);
            // add each items total to the total price
            totalPrice += (price * quantity);
        }
//        return the total
        return totalPrice;
    }
}
