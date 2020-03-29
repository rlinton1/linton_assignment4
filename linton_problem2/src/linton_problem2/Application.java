// Create a separate class called Application that contains 
// a main method which illustrates the use of DuplicateCounter
// by calling both the remove and write methods.
// Your input file must be called problem2.txt
// and your output file must be called unique_word_counts.txt.
package linton_problem2;


public class Application 
{	
		   public static void main(String[] args) 
		   {
		       String inputFile = "problem2.txt";
		       String outputFile = "unique_word_counts.txt";
		       DuplicateCounter duco = new DuplicateCounter();
		       duco.count(inputFile);
		       duco.write(outputFile);
		}
}
