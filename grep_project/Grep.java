import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {
  public Grep() {}
  
  public static void main(String[] args) {
    // open all files using a for loop
    for(int i = 1; i <= 5; i++){
      try {
          String fileName = "TestFile" + i + ".txt";
          File f = new File(fileName);
          // read from all five files as they're opened
          Scanner s = new Scanner(f);
          // create a pattern to be searched for 
          Pattern pattern = Pattern.compile("\\d+");
          String line;
          Matcher matcher;
          while(s.hasNextLine()){
            line = s.nextLine();
            matcher = pattern.matcher(line);
            if(matcher.find()){
              System.out.println(fileName + " : " + line);
            }
          }
          // close scanner when done to save memory
          s.close();
      } catch (FileNotFoundException e) {
        System.out.println("Problem opening file");
        e.printStackTrace();
        return;
      }
    }
  }
}
