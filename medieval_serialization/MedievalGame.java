import java.io.*;
import java.util.Scanner;
import java.util.Objects;

public class MedievalGame {

  /* Instance Variables */
  private Player player;

  /* Main Method */
  public static void main(String[] args) {
    
    Scanner console = new Scanner(System.in);
    MedievalGame game = new MedievalGame();

    game.player = game.start(console);

    game.addDelay(500);
    System.out.println("\nLet's take a quick look at you to make sure you're ready to head out the door.");
    System.out.println(game.player);

    game.addDelay(1000);
    System.out.println("\nWell, you're off to a good start, let's get your game saved so we don't lose it.");
    game.save();

    game.addDelay(2000);
    System.out.println("We just saved your game...");
    System.out.println("Now we are going to try to load your character to make sure the save worked...");

    game.addDelay(1000);
    System.out.println("Deleting character...");
    String charName = game.player.getName();
    game.player = null;

    game.addDelay(1500);
    game.player = game.load(charName, console);
    System.out.println("Loading character...");

    game.addDelay(2000);
    System.out.println("Now let's print out your character again to make sure everything loaded:");

    game.addDelay(500);
    System.out.println(game.player);
  } // End of main

  /* Instance Methods */
  private Player start(Scanner console) {
    Player player;
    Art.homeScreen();
    System.out.println("Welcome!");
    System.out.println("Would you like to load a game (Y) or create a new game (N)");
    String answer = console.next().toLowerCase();
    while(true){
      if(answer.equals("y")){
        System.out.print("Enter your character's name: ");
        player = load(console.next(), console);
        break;
      }
      else if (answer.equals("n")){
        System.out.println("Enter a character's name to start a new game");
        String newName = console.next();
        player = new Player(newName);
        break;
      }
      else {
        System.out.println("Invalid response. Please try again. Enter 'Y' to load a game and 'N' to start a new game");
        answer = console.next().toLowerCase();
      }
    }
    return player;
  } // End of start

  private void save() {
    String fileName = player.getName() + ".svr";
    try {
      FileOutputStream userSaveFile = new FileOutputStream(fileName);
      ObjectOutputStream playerSaver = new ObjectOutputStream(userSaveFile);
      playerSaver.writeObject(player);
    } catch (IOException e) {
      System.out.println("Error occurred when saving game!");
    }

  } // End of save

  private Player load(String playerName, Scanner console) {
    Player loadedPlayer;
    try {
      FileInputStream userSaveFile = new FileInputStream(playerName+".svr");
      ObjectInputStream playerLoader = new ObjectInputStream(userSaveFile);
      loadedPlayer = (Player) playerLoader.readObject();
    } catch (IOException | ClassNotFoundException e){
      addDelay(1500);
      System.out.println("A problem occurred loading your character, we've created a new player with the name you " +
              "entered.");
      System.out.println("If you're sure the spelling is correct, your character file may no longer exist, please " +
              "reload the game if you'd like to try again.");
      System.out.println("We've created a new player with the name: " + playerName);
      addDelay(2000);
      loadedPlayer = new Player(playerName);
    }
    return loadedPlayer;
  } // End of load

  // Adds a delay to the console so it seems like the computer is "thinking"
  // or "responding" like a human, not instantly like a computer.
  private void addDelay(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
