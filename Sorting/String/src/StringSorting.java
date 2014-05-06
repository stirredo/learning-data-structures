/**
 * Created by stirredo on 5/5/2014.
 */
public class StringSorting {
    public String[] array;
    public int maxSize;
    public int count;

    public StringSorting(int maxSize, String str) {
        this.maxSize = maxSize;

        array = str.split(" ");
        count = array.length;
    }
    public void sort() {
        //performs insertion sort on a string
        for (int i = 1; i < count; i++) {
            for (int j = i; j > 0; j--) {
                int strIndex = 0;
                boolean finished = false;
                int strLength = array[j-1].length() < array[j].length()? array[j-1].length() : array[j].length();
                while ((strIndex < strLength) && !finished) {
                    if (array[j - 1].toLowerCase().charAt(strIndex) > array[j].toLowerCase().charAt(strIndex)) {
                        swap(j - 1, j);
                        finished = true;
                    } else if (array[j - 1].toLowerCase().charAt(strIndex) == array[j].toLowerCase().charAt(strIndex)) {
                        strIndex++;
                    } else {
                        break;
                    }

                }

            }
        }
    }

    private void swap(int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String string = "This is isabella a string";
        String[] strArray = string.split(" ");
        StringSorting prog = new StringSorting(strArray.length,string);
        prog.sort();
        for (String str : prog.array) {
            System.out.println(str);
        }
    }
}
