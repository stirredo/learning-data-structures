package BinaryTree;

import java.util.Random;

/**
 * Created by stirredo on 2/13/14.
 */
public class TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();
        /*for (int i = 0; i < 20; i++) {
            Random rnd = new Random();
            tree.insert(rnd.nextInt(100));
        }*/

        //the above elements desscribe this tree: http://i.imgur.com/gdzC47I.png
        tree.insert(78);
        tree.insert(61);
        tree.insert(14);
        tree.insert(0);
        tree.insert(10);
        tree.insert(46);
        tree.insert(15);
        tree.insert(57);
        tree.insert(72);
        tree.insert(66);
        tree.insert(63);
        tree.insert(68);
        tree.insert(73);
        tree.insert(75);
        tree.insert(96);
        tree.insert(88);
        tree.insert(85);
        tree.insert(83);
        tree.insert(87);
        tree.insert(92);
        tree.insert(95);
        tree.displayTree();
        tree.delete(96);
        tree.displayTree();

/*
        System.out.println("Inorder: ");
        tree.traverse(Tree.TraverseType.INORDER); //prints in ascending order
        //Postorder LRN - 1,7,4,2,16,23,50,73,64,26,8,87,90,89,93,97,95,94,91,81
        System.out.println("");
        System.out.println("Postorder:");
        tree.traverse(Tree.TraverseType.POSTORDER);
        System.out.println("");
        System.out.println("Preorder: ");
        //Preorder NLR - 81,8,2,1,4,7,26,23,16,64,50,73,91,89,87,90,94,93,95,97
        tree.traverse(Tree.TraverseType.PREORDER);
        System.out.println("");
        TreeNode found = tree.minimum();

        if(found != null) {
            System.out.println("Minimum: "+ found.getData() );
            System.out.print("\n");
        }
        System.out.println(tree.minimum(tree.find(8)).getData());
        System.out.println("");*/


    }
}
