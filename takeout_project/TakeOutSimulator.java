import java.util.Scanner;

public class TakeOutSimulator {
//    instance fields
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

//    constructor
    public TakeOutSimulator(Customer customer, Scanner input){
        this.customer = customer;
        this.menu = new FoodMenu();
        this.input = input;
    }

//    methods
    private <T> T getResponse(String userInputPrompt, UserInputRetriever<T> userInputRetriever){
        while (true) {
        // displays the prompt to the user
        System.out.println(userInputPrompt);
        // checks if the user enters a valid integer
        if (input.hasNextInt()) {
            // saves the returned user input
            int userInput = input.nextInt();
        try {
            // sends the users input to produceOutput from userInputRetriever
            return userInputRetriever.produceOutput(userInput);
        // throws an error if the user input is not valid int for produceOutput()
        } catch (IllegalArgumentException e){
            System.out.println(userInput + " is not a valid input. Try again!");
        }
        // outputs message to user that input needs to be an int type
        } else {
            System.out.println("Input needs to be an integer. Try again!");
            input.next(); // resets to allow Scanner to take in new user input
        }
        }
    }

    public boolean shouldSimulate(){
        String userPrompt = "Enter 1 to CONTINUE simulation or enter 0 to EXIT";
        UserInputRetriever<Boolean> retriever = new UserInputRetriever<Boolean>(){
            @Override
            public Boolean produceOutput(int selection){
                if(selection == 1){
                    double lowestCostFood = menu.getLowestCostFood().getPrice();
                    return customer.getCustomerMoney() >= lowestCostFood;
                } else if (selection == 0) {
                    return false;
                } else {
                    throw new IllegalArgumentException("Select a valid input.");
                }
            }
        };
        return getResponse(userPrompt, retriever);
    }

    public Food getMenuSelection(){
        System.out.println(menu);;
        String userPrompt = "Please enter the number corresponding to your menu choice.";
        UserInputRetriever<Food> menuChoice = new UserInputRetriever<Food>(){
            @Override
            public Food produceOutput(int selection){
                Food selectedFood = menu.getFood(selection);
                if (selectedFood != null) {
                    return selectedFood;
                } else {
                    throw new IllegalArgumentException("Invalid menu selection.");
                }
            }
        };
        return getResponse(userPrompt, menuChoice);
    }

    public boolean isStillOrderingFood(){
        String userPrompt = "Enter 1 to CONTINUE shopping or 0 to CHECKOUT";
        UserInputRetriever<Boolean> toCheckout = new UserInputRetriever<Boolean>() {
            @Override
            public Boolean produceOutput(int selection) throws IllegalArgumentException {
                if (selection == 1){
                    return true;
                } else if (selection == 0){
                    return false;
                } else {
                    throw new IllegalArgumentException("Selection must be 1 or 0");
                }
            }
        };
        return getResponse(userPrompt, toCheckout);
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag){
        System.out.println("Payment is processing...");
        // calculate customer's remaining money after paying
        int remainingMoney = customer.getCustomerMoney() - shoppingBag.getTotalPrice();
        // update customer's remaining money
        customer.setCustomerMoney(remainingMoney);
        // inform customer of remaining money
        System.out.println("Thanks for your purchase " + customer.getCustomerName() + "! You have $" + customer.getCustomerMoney() + " remaining.");
        System.out.println("Enjoy your meal!");
    }

    public void takeOutPrompt(){
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoneyLeft = customer.getCustomerMoney();
        boolean ordering = true;
        while (ordering) {
        System.out.println("Hey " + customer.getCustomerName() + " you have $" + customerMoneyLeft + " left to spend");
        Food selectedMenuOption = getMenuSelection();
        if (selectedMenuOption.getPrice() <= customerMoneyLeft){
            customerMoneyLeft -= selectedMenuOption.getPrice();
            shoppingBag.addItem(selectedMenuOption);
        } else {
            System.out.println("You don't have enough money for that item. Please try again");
        }
            ordering = isStillOrderingFood();
        }
            checkoutCustomer(shoppingBag);
        }

        public void startTakeOutSimulator(){
            System.out.println("Welcome to the restaurant " + customer.getCustomerName() + "!");
            while(shouldSimulate()){
                takeOutPrompt();
            }
        }
    }
