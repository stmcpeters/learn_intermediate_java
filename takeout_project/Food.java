public class Food implements PricedItem<Integer> {
//    instance fields
    private final String name;
    private final String description;
    private int price;

//    constructor
    public Food(String name, String description, int price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Integer getPrice(){
        return this.price;
    }

    @Override
    public void setPrice(Integer price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "Enjoy " + this.name + ": " + this.description + "     Cost: $" + this.price;
    }
}