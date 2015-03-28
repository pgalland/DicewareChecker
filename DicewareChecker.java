import java.io.FileReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Pierre Galland on 28/03/2015.
 *
 * To be used on the Diceware word list found at http://world.std.com/~reinhold/diceware.wordlist.asc
 * The aim is to check that the list contains indeed 7776 distinct words, each associated to a different
 * 5 dice throw sequence.
 *
 * Official Diceware website at : http://world.std.com/~reinhold/diceware.html
 * (by the way it would be nice if this website had a certificate !)
 *
 * To use the program just give the path of the word list file as first argument
 * (NB : it skips the first two lines of the file because on the official list these lines are not used
 * for number/word associations)
 *
 */
public class DicewareChecker {

    public static void main(String[] args) throws Exception{

        Reader reader = new FileReader(args[0]);
        Scanner scan = new Scanner(reader);

        // skip the first two lines because they do not contain number/word associations
        scan.nextLine();
        scan.nextLine();

        Set<Integer> numberSet = new HashSet<Integer>();
        Set<String> wordSet = new HashSet<String>();

        // the word list must contain 7776 different words
        // each corresponding to a different 6 dice digits sequence
        String[] line;
        String word;
        int number;
        for(int i=0; i<7776; i++){

            line = scan.nextLine().split("\\s+");

            if (line.length != 2)
                throw  new Exception("On a line there is more than two items");

            if (!line[0].matches("[1-6]{5}"))
                throw  new Exception("On a line the first item is not a number of 5 digits between 1 and 6");

            number = Integer.parseInt(line[0]);
            word = line[1];

            numberSet.add(number);
            wordSet.add(word);
        }

        if (numberSet.size() != 7776)
            throw  new Exception("The number of distinct numbers is different from 7776");
        if(wordSet.size() != 7776)
            throw  new Exception("The number of distinct words is different from 7776");

        System.out.println("If no exceptions were thrown by the program then it looks like you can trust this list !");
        System.out.println("(there is "+wordSet.size()+" distinct words associated to "+numberSet.size()+" distinct five [1-6]digits numbers)");

    }

}
