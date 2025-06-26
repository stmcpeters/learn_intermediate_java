# Take-Out Simulator Project Guide

## Core Data Types

### 1. Create a `Customer` class
- File: `Customer.java`
- Fields:
  - `String name`
  - `int money`
- Add:
  - Public getters and setters for all fields
  - A constructor to initialize `name` and `money`

### 2. Create a `PricedItem` interface
- File: `PricedItem.java`
- Type parameter: `T` (upper bounded by `Number`)
- Methods:
  - `getPrice()` returns `T`
  - `setPrice(T price)`

### 3. Create a `Food` class
- File: `Food.java`
- Implements: `PricedItem<Integer>`
- Fields:
  - `String name`
  - `String description`
  - `int price`
- Add:
  - Constructor to initialize all fields

### 4. Complete `Food` implementation
- Override:
  - `setPrice()`
  - `getPrice()`
  - `toString()` to display food information

---

## Shopping Bag

### 5. Create a generic `ShoppingBag` class
- File: `ShoppingBag.java`
- Type parameter: `T` (upper bounded by `PricedItem<Integer>`)
- Fields:
  - `Map<T, Integer> shoppingBag`
- Add:
  - No-arg constructor initializing `shoppingBag` as empty `HashMap`

### 6. Add items to the shopping bag
- Method: `addItem(T item)`
  - If item exists, increment count
  - Else, add item with count of 1

### 7. Calculate total price
- Method: `getTotalPrice()`
  - Iterate through items
  - Multiply item count by item price
  - Return the grand total

---

## Menu

### 8. Create the `FoodMenu` class
- File: `FoodMenu.java`
- Fields:
  - `List<Food> menu`
- Add:
  - No-arg constructor to initialize list with at least 3 food items

### 9. Display the menu
- Override `toString()` to show numbered list of menu items

### 10. Select food by index
- Method: `getFood(int index)`
  - Return food at given index (adjusted for 1-based menu)
  - Return `null` if index is invalid

### 11. Find the lowest cost food
- Method: `getLowestCostFood()`
  - Return the `Food` item with the lowest price

---

## Simulation Plumbing

### 12. Create a `UserInputRetriever` interface
- File: `UserInputRetriever.java`
- Generic interface with type `T`
- Method:
  - `produceOutput(int selection)` which returns `T` and may throw `IllegalArgumentException`

### 13. Create the `TakeOutSimulator` class
- File: `TakeOutSimulator.java`
- Fields:
  - `Customer customer`
  - `FoodMenu menu`
  - `Scanner input`
- Add:
  - Constructor to initialize all fields

### 14. Generic input prompt method
- Method: `getResponse(String userInputPrompt, UserInputRetriever<T> userInputRetriever)`
  - Loop:
    - Show prompt
    - Read input
    - If valid `int`, call `produceOutput`
    - Handle `IllegalArgumentException` with error message
    - If input is not an `int`, display appropriate message

---

## Customer Prompts

### 15. Exit or continue simulation
- Method: `shouldSimulate()`
  - Prompt user to enter `1` to continue or `0` to exit
  - Use `UserInputRetriever` to:
    - Return `true` if `1` and customer has enough money
    - Return `false` if `0` or not enough money
    - Throw `IllegalArgumentException` for invalid inputs

### 16. Get menu selection
- Method: `getMenuSelection()`
  - Prompt user to choose a menu item by number
  - Use `UserInputRetriever` to:
    - Return selected food if valid
    - Throw `IllegalArgumentException` if not

### 17. Continue shopping or checkout
- Method: `isStillOrderingFood()`
  - Prompt: Enter `1` to continue, `0` to checkout
  - Use `UserInputRetriever` to return `true` or `false`

---

## Ordering Food

### 18. Process checkout
- Method: `checkoutCustomer(ShoppingBag<Food> shoppingBag)`
  - Inform customer of checkout
  - Deduct total from customer’s money
  - Display remaining money and thank you message

### 19. Start the food ordering loop
- Method: `takeOutPrompt()`
  - Create:
    - `ShoppingBag<Food>`
    - `customerMoneyLeft`
  - Loop:
    - Display money left
    - Get food selection
    - If affordable, add to bag and deduct price
    - If not, show error
    - Ask if still ordering
  - After ordering, call `checkoutCustomer()`

---

## Simulator Entry Point

### 20. Start the simulator
- Method: `startTakeOutSimulator()`
  - Display welcome message
  - Loop until user exits:
    - Show greeting
    - Call `takeOutPrompt()`

### 21. Set up in `main()`
- File: `Main.java`
- In `main()`:
  - Create `Scanner input`
  - Get `customerName` and starting `money`
  - Create `Customer` and `TakeOutSimulator`
  - Call `startTakeOutSimulator()` on simulator
  - Compile and run:
    ```bash
    javac Main.java
    java Main
    ```

---

## 🎉 Final Notes

Enjoy building and testing your take-out ordering simulation! Expand the program with:
- Discount systems
- Combo deals
- Delivery fees
- And more interactive menus!

Have fun and happy coding!

