/**
 * Created by stirredo on 3/6/14.
 */
public class myMergeSort {
    public static int[] workSpace = new int[12];
    public static int[] originalArray = new int[12];
    public static int arraySize = 0;
    public static void insert(int num) {
        originalArray[arraySize] = num;
        arraySize++;
    }
    public static void recMergeSort() {
        workSpace = new int[100];
        mergeSort(workSpace, 0, arraySize - 1);
    }

    public static void mergeSort(int[] array,int lowerBound,int upperBound) {
        if(lowerBound == upperBound) {
            //if range is 1 then return
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            mergeSort(workSpace, lowerBound, mid);
            mergeSort(workSpace, mid + 1, upperBound);
            //mergeArray(lowerBound, mid + 1, upperBound); //0 3 12 21 33 36 44 64 70 85 99 108 -- works
            myMergeArray(lowerBound, upperBound); //0 33 36 21 70 85 12 64 99 3 44 108 -- doesn't work
        }
    }

    public static void mergeArray(int lowPtr, int highPtr,int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int noOfElements = upperBound - lowPtr + 1;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (originalArray[lowPtr] < originalArray[highPtr]) {
                workSpace[j] = originalArray[lowPtr];
                j++;
                lowPtr++;
            } else {
                workSpace[j] = originalArray[highPtr];
                j++;
                highPtr++;
            }
        }
        while (lowPtr <= mid) {
            workSpace[j++] = originalArray[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[j++] = originalArray[highPtr++];
        }

        for (j = 0; j < noOfElements; j++) {
            originalArray[lowerBound + j] = workSpace[j];
        }

    }
    public static void myMergeArray(int lowPtr,int upperBound) {
        //doesn't work - when the element is shifted in the upper array - no way to get the higher/upper array to get sorted again.
        //Normal method is better for mergesort
        int lowerBound = lowPtr;
        int mid = (upperBound + lowerBound) / 2;
        int highPtr = mid + 1;
        int j = 0;
        int noOfElements = upperBound - lowerBound + 1;
        while (highPtr <= upperBound) {
            while(lowPtr <= mid) {
                if (originalArray[lowPtr] < originalArray[highPtr]) {
                    //workSpace[j++] = originalArray[lowPtr++];
                    //do nothing?
                    lowPtr++;

                } else {
                    //workSpace[j++] = originalArray[highPtr++];
                    int temp = originalArray[highPtr];
                    originalArray[highPtr] = originalArray[lowPtr];
                    originalArray[lowPtr] = temp;
                }
            }
            highPtr++;

        }
        /*while (lowPtr <= mid) {
            workSpace[j++] = originalArray[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = originalArray[highPtr++];
        }

        for (int i = 0; i < noOfElements; i++) {
            originalArray[lowerBound + i] = workSpace[i];
        }*/


    }

    public static void main(String[] args) {
        insert(64);
        insert(21);
        insert(33);
        insert(70);
        insert(12);
        insert(85);
        insert(44);
        insert(3);
        insert(99);
        insert(0);
        insert(108);
        insert(36);
        recMergeSort();
        for (int i = 0; i < arraySize; i++) {
            System.out.print(originalArray[i]+ " ");
            
        }
    }
   

}
