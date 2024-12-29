import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class wordle {

    public static String GetWord() {
        String[] words = {"apple", "table", "house", "river", "grass", "chair", "plane", "cloud", "light", "stone"};
        Random rnd = new Random();
        int num = rnd.nextInt(0, 9);
        System.out.println("the secret word is " + words[num]);
        return words[num];
    }

    //^ works
    public static String CheckLength(String word) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (word.length() == 5) {
                break;
            } else {
                System.out.println("Enter a word, it should be 5 letters long");
                word = sc.nextLine();
            }
        }
        return word;
    }
//^ works


// i have two funcs
    // one gets me a secret words
    // the second one cheks if the words i choose is 5 letters
    // a func that gets two words and checks which letters are corresponding

    // i need to write a func that checks if the word that i chose matches the secret word
    public static String [] CheckWord(String word, String secretWord) {
        String [] answer = {"_","_","_","_","_"};
        for (int i = 0; i < secretWord.length(); i++) {
            for(int j = 0; j < word.length(); j++)
                if (word.charAt(i) == secretWord.charAt(i)) {
                    answer[i] = "G";
                } else if (word.charAt(i) == secretWord.charAt(j)) {
                    answer[i] = "Y";
                }
        }
        return answer;
    }


    // in the main ill write the 6 tries thingie (just use a for loop for 6 times and thats it)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String secretWord = GetWord();
        for (int i = 0; i < 7; i++) {
            System.out.println("Enter a word, it should be 5 letters long");
            String word = CheckLength(sc.nextLine());
            String [] finalAnswer = CheckWord(word,secretWord);
//            System.out.println("final answer is "+ finalAnswer);
            if (Arrays.equals(finalAnswer,new String[] {"G", "G", "G", "G", "G"})){
                System.out.println("You won");
                return;
            }
            else if(i == 6){
                System.out.println("You lost");
            }

        }
    }
}