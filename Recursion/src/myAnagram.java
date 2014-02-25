/**
 * Created by stirredo on 2/24/14.
 */
public class myAnagram {
    public static char[] arrChar = new char[100];
    public static int wordSize;
    public static int noOfWords;
    public static void doAnagram(int newSize) {
        if(newSize == 1) {
            return ;
        } else {
            for (int i = 0; i < newSize; i++) {
                doAnagram(newSize - 1);
                if(newSize == 2) {
                    displayWord();
                }
                rotate(newSize);
            }
        }
    }
    public static void rotate(int newSize) {
        int position = wordSize - newSize;
        char temp = arrChar[position];
        for (int i = position; i < wordSize - 1; i++) {
            arrChar[i] = arrChar[i + 1];
        }
        arrChar[wordSize - 1] = temp;



    }
    public static void displayWord() {
        noOfWords++;
        System.out.print(noOfWords+"\t");
        for (int i = 0; i < wordSize; i++) {
            System.out.print(arrChar[i]);

        }
        System.out.print("\t");
        if(noOfWords % 6 == 0) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        String word = "1234";
        noOfWords = 0;
        wordSize = word.length();

        for (int i = 0; i < word.length(); i++) {
            arrChar[i] = word.charAt(i);

        }
        doAnagram(word.length());

    }
}
