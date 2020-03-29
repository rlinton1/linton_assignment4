// Create a separate class called Application that contains a main method
// which illustrates the use of DuplicateRemover by calling both the 
// remove and write methods. Your input file must be called problem1.txt
// and your output file must be called unique_words.txt.
// Your input file should be located within your project structure 
// so that you can reference it with the relative path of "problem1.txt",

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException {
	       DuplicateRemover d = new DuplicateRemover();
	       d.remove("problem1.txt");
	       d.write("unique_words.txt");
	   }
	}


