package OrderedArray;

import UnorderedArray.*;

/**
 * Created by stirredo on 1/17/14.
 */
public class OrderedArrayApp {
    public static void main(String[] args) {
        ArrayDataStructure oa = new ArrayDataStructure(100);
        oa.insert(89);
        oa.insert(9);
        oa.insert(13);
        oa.insert(44);
        oa.insert(55);
        oa.insert(43);
        oa.display();
        Integer location = oa.find(43);
        if(location != null) {
            System.out.println("Found at "+ location);
        } else {
            System.out.println("couldn't find it");
        }
        location = oa.initRecFind(43);
        if(location != null) {
            System.out.println("Found at "+ location);
        } else {
            System.out.println("couldn't find it");
        }


    }
}

