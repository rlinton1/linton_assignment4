// Create a class called DuplicateRemover.
// Create an instance method called remove that takes a single parameter 
// called dataFile of type String (representing the path to a text file) 
// and uses a Set of Strings to eliminate duplicate words from the file referenced by dataFile. 
// The unique words should be stored in an instance variable called uniqueWords. 
// Create an instance method called write that takes a single parameter called outputFile 
// (representing the path to a text file) and writes the words contained in uniqueWords to the file pointed to by outputFile.
// The output file should be overwritten if it already exists, and created if it does not exist.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.LinkedHashSet;


public class DuplicateRemover 
{
    private LinkedHashSet<String> uniqueWords;
    public DuplicateRemover() 
    {
        uniqueWords = new LinkedHashSet<>();
    }
    public void remove(String dataFile) 
    {
        File f1 = new File(dataFile);
        FileReader fr = null;
        BufferedReader br = null;
        try 
        {
            fr = new FileReader(f1); 
            String[] words = null;
            String s;
          // BufferedReader object is made
            br = new BufferedReader(fr); 
          // Content is read from the file
            while ((s = br.readLine()) != null) 
            {
            	// technique to get rid of punctuation
                s = s.replaceAll("[.,?!)(]", " "); 
              // words being split
                words = s.split("\\s+"); 
                for (String word : words) 
                {
                    uniqueWords.add(word.toLowerCase()); 
                }
            }
        } 
        catch (IOException ex) 
        {
            System.err.println(ex.getMessage());
        } 
        finally 
        {
            
            try 
            {
                if (fr != null) 
                {
                    fr.close();
                }
                if (br != null) 
                {
                    br.close();
                }
            } 
            catch (IOException ex) 
            {
            }
        }
    }
    public void write(String outputFile) 
    {
        BufferedWriter out = null;
        Iterator it = uniqueWords.iterator();
        try 
        {
            out = new BufferedWriter(new FileWriter(outputFile));
            while (it.hasNext()) 
            {
                out.write(it.next().toString());
                out.newLine(); 
            }
        } 
        catch (IOException ex) 
        {
        } 
        finally 
        {
            try 
            {
                if(out!=null)
                    out.close();
            } 
            catch (IOException ex) 
            {
            }
        }
    }
}