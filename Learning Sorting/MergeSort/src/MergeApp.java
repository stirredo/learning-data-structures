/**
 * Created by stirredo on 2/27/14.
 * Merges two arrays. NOT mergesort.
 */
public class MergeApp {
    public static int[] array1 = {23, 47, 81, 95};
    public static int[] array2 = {7, 14, 39, 55, 62, 74};
    public static int[] resultArray;

    public static int[] merge(int[] array1, int[] array2, int[] resultArray) {
        resultArray = new int[array1.length + array2.length];
        int countArray1 = 0, countArray2 = 0, countArray3 = 0;

        while (countArray1 < array1.length && countArray2 < array2.length) {
            if (array1[countArray1] < array2[countArray2]) {
                resultArray[countArray3] = array1[countArray1];
                countArray1++;
            } else {
                resultArray[countArray3] = array2[countArray2];
                countArray2++;
            }
            countArray3++;
        }

        while(countArray1 < array1.length) {
            resultArray[countArray3] = array1[countArray1];
            countArray1++;
            countArray3++;
        }
        while(countArray2 < array2.length) {
            resultArray[countArray3] = array1[countArray2];
            countArray2++;
            countArray3++;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        resultArray = merge(array1,array2,resultArray);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }

    }


}
