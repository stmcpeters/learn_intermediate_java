# Medieval Game Serialization Guide

## Workspace Review

1. **Review `Armour.java` Files**
2. **Review `Weapon.java`**
3. **Review `Player.java`**
4. **Review `MedievalGame.java`**

---

## Setting Up the Serialization Backbone

5. Open `Armour.java`. Ensure that all classes used in `Player` are serializable so the `save()` method in `MedievalGame` can write a `Player` instance to a file.

6. Add an import statement for the `Serializable` interface above the class declaration in `Armour`.

7. Implement the `Serializable` interface in the `Armour` class declaration.

8. Add a private static final long class variable named `serialVersionUID`, initialized to `1L`. This ensures compatibility during deserialization.

9. Repeat steps 6–8 for the following classes:
    - `Helmet.java`
    - `Shirt.java`
    - `Trouser.java`
    - `Shoe.java`
    - `Weapon.java`
    - `Player.java`

---

## Saving the Game

10. In `MedievalGame.java`, declare a private instance variable of type `Player` under the `/* Instance Variables */` section.

11. Inside the `save()` method, create a `String` called `fileName` equal to the player's name plus `.svr`.

12. Create a `FileOutputStream` object using the `fileName`. Import it from `java.io`.

13. Create an `ObjectOutputStream` and pass the `FileOutputStream` to it. Import from `java.io`.

14. Use the `writeObject()` method of the `ObjectOutputStream` to write the player object to the file.

15. Wrap the stream logic in a `try-catch` block:
    - Catch `IOException`
    - Print an error message
    - Import `IOException` from `java.io`

---

## Loading a Saved Game

16. Locate the `load()` method in `MedievalGame.java`. It returns a `Player` and accepts:
    - `String playerName`
    - `Scanner console`

17. Declare an uninitialized `Player` called `loadedPlayer`. Update the return statement to return `loadedPlayer`.

18. Add a `try-catch` block to handle exceptions:
    - Catch `IOException` and `ClassNotFoundException`

19. In the `try` block:
    - Create a `FileInputStream` using `playerName + ".svr"`
    - Create an `ObjectInputStream` using the `FileInputStream`

20. Read the `Player` object from the file using `readObject()` and cast it to `Player`. Assign it to `loadedPlayer`.

21. In the `catch` block:
    - Call `addDelay(1500)`
    - Print an alert to the user
    - Call `addDelay(2000)`
    - Set `loadedPlayer` to a new `Player` using `playerName`

---

## Starting the Game

22. In the `start()` method:
    - Declare an uninitialized `Player` called `player`
    - Return `player` at the end of the method

23. Display the title art by calling `Art.homeScreen()`

24. Welcome the user and ask if they want to load a saved game:
    - Prompt: Enter `"y"` for yes or `"n"` for no

25. Create a `String` called `answer` that stores the lowercase user input from the scanner.

26. Add logic to handle the input:
    - If `"y"`: Ask for a saved character name and load the player
    - If `"n"`: Ask for a new name and create a new `Player`
    - Otherwise: Loop until the user enters a valid option

---

## Running the Game

27. Compile and run the program:
    - Use `javac *.java` to compile all files
    - Use `java MedievalGame` to run the game

If you encounter errors:
- Read the error messages carefully
- Debug step-by-step
- Don’t worry — typos and bugs are expected

The `main()` method:
- Starts the game
- Saves the character
- Deletes the current object
- Reloads from the saved file
- Adds delays for a better user experience

---

## Next Steps

Explore and expand the game! Some ideas:
- Add a combat system
- Encrypt the save files
- Build a `Shop` class
- Design a 2D map with navigation
- Make the Tavern interactive

---

**Have fun!**  
Now that you can serialize objects, your game is more portable and dynamic.  
**Congratulations! 🎉**
