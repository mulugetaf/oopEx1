package Q_2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TestBet {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String DataFile1="C:/Users/Student/Desktop/text1.txt";
		String DataFile2="C:/Users/Student/Desktop/text3.txt";
		
		TestBet.readFile(DataFile1);
		
		System.out.println();
		TestBet.readFile(DataFile2);
	}
	/**
	 * void
	 * @param fileName - the path to the file that we want to proceed on.
	 * function will read the text file stored at the path of fileName. 
	 * function will tokenize the text word by word:
	 * count the total amount of words
	 * count the amount of distinct words
	 * calculate the word that is most frequently used in the text and print it out as well as the amount of occurences.
	 * calculate the longest word used in the text and print it out.
	 */
	public static void readFile (String fileName){
		try { // try read from the file
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();

			HashMap<String, Integer> words = new HashMap<String, Integer>();
			
			StringTokenizer ST;
			String word, max_word ="", lg_word = "";
			int total_w_amount = 0, total_dif_w=0, max_w_am=0;
			for(int i=1; str!=null; i=i+1) {
				ST = new StringTokenizer(str, "/-().;:, ");
				while(ST.hasMoreTokens()){
					word = ST.nextToken();
					total_w_amount++;
					if (words.containsKey(word)){
						if(words.get(word)+1 > max_w_am){
							max_w_am = words.get(word)+1;
							max_word = word;
						}
						words.put(word, words.get(word)+1);
					}
					else{
						total_dif_w++;
						words.put(word, 1);
					}
					if(word.length() > lg_word.length()) lg_word = word;
				}
				str = br.readLine();

			}
			br.close();
			
			System.out.println("The Number of Different Words: " + total_dif_w);
			System.out.println("The Number of  Words: " + total_w_amount);
			System.out.println("The Most Frequent Word: (" + max_word+ "), frequency: " + max_w_am);
			System.out.println("The Longest Word: (" + lg_word + ")");
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}
}
