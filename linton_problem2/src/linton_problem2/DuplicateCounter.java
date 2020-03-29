// Create a class called DuplicateCounter. 
// Create an instance method called count that takes a single 
// parameter called dataFile of type String (representing the path to a text file)
// and uses a Map of Strings to count how many times each word occurs in dataFile. 
// The counts should be stored in an instance variable called wordCounter.
// Create an instance method called write that takes a single parameter
// called outputFile (representing the path to a text file) 
// and writes the contents of wordCounter to the file pointed to by outputFile.
// The output file should be overwritten if it already exists,
// and created if it does not exist.

package linton_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter
{
   private Map<String, Integer> word_Count;
  
   public DuplicateCounter(){
       this.word_Count = new HashMap<String,Integer>();
   }
   public void write(String filename)
   {
       try 
       {
           PrintWriter outputFile = new PrintWriter(new File(filename));
           for(String k : word_Count.keySet()) 
           {
               outputFile.println(k + " " + word_Count.get(k));
           }
           outputFile.close();
       } 
       catch (FileNotFoundException e) 
       {
           System.out.println(e.getMessage());
       }
   }
   public void count(String filename)
   {
       Scanner inputFile = null;
       try 
       {
           inputFile = new Scanner(new File(filename));
       } 
       catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
           return;
       }
       inputFile.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+"); 
       while(inputFile.hasNext())
       {
           String word = inputFile.next().toLowerCase();
           Integer counter = word_Count.get(word); 
           if(counter == null)
               counter = 1;
           else
               counter = counter + 1;
           word_Count.put(word, counter);
       }
       inputFile.close();
   }
  
}