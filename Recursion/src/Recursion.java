/**
 * Created by stirredo on 2/23/14.
 */
public class Recursion {
    public static int triangleNumbers(int num) {
        if(num == 1) {
            return 1;
        } else {
            return num + triangleNumbers(num - 1);
        }

    }
    public static int factorial(int num) {
        if(num == 0) {
            return 1;
        } else {
            return num * (factorial(num - 1));
        }

    }
    public static void doAnagram() {
        //to be implemented
    }

    public static void main(String[] args) {
        System.out.println(triangleNumbers(4));
        System.out.println(factorial(4));
    }

}
