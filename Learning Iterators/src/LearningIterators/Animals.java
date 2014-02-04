package LearningIterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stirredo on 2/4/14.
 */
public class Animals {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("What's up?");
        list.add("Bye");
        for (String str: list) {
            System.out.println(str);
        }
    }
}
