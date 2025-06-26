import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodMenu {
//    instance fields
    private List<Food> menu;

//    constructor
    public FoodMenu(){
        menu = new ArrayList<>();
        Food food1 = new Food("chicken", "delicious 10-piece chicken nuggets", 10);
        Food food2 = new Food("juice", "liter of orange juice", 5);
        Food food3 = new Food("cookies", "chocolate chip", 7);
        menu.add(food1);
        menu.add(food2);
        menu.add(food3);
    }

//    methods
    public Food getFood(int index){
        // return the food object at index (menu is 1-based indexing)
        // return null if index doesn't exist
        try {
            return menu.get(index - 1);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public Food getLowestCostFood(){
        // iterate through menu List
        // set a starting item to use to compare against
        // compare prices of the starting item and iterating item
        // if the iterating item is less than the starting
            // make the iterating item into the starting (lowest)
        // return starting (lowest) item
        Food lowest = menu.get(0);
        for(Food item : menu){
            if(lowest.getPrice() > item.getPrice()){
                lowest = item;
            }
        }
        return lowest;
    }

    @Override
    public String toString(){
    // iterate through the menu List
    // concatenate each food item by appending using StringBuilder
//        example:
//        1. Enjoy Tacos: Yummy steak tacos    Cost: $15
//        2. Enjoy Dumplings: Delicious steamed dumplings    Cost: 10
//        3. Ramen: Hot pork ramen    Cost: 12
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < menu.size(); i++){
            sb.append(i+1);
            sb.append(". ");
            sb.append(menu.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}