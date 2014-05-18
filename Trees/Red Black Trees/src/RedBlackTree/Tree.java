package RedBlackTree;

import javax.xml.soap.Node;
import java.util.Random;
import java.util.Stack;

/**
 * Created by stirredo on 12/5/2014.
 */
public class Tree {
    public TNode root;

    public Tree() {
        this.root = null;
    }

    public enum TraverseType {
        INORDER(0),
        PREORDER(1),
        POSTORDER(2);

        int type;

        int getType() {
            return this.type;
        }

        TraverseType(int type) {
            this.type = type;
        }
    }
    

    public TNode find(int key) {
        TNode current = root;
        while (current != null) {
            if (current.data == key) {
                return current;
            } else if (key < current.data) {
                current = current.leftChild;

            } else if (key > current.data) {
                current = current.rightChild;
            }
        }
        return null;
    }

    public void inorder(TNode node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.print(node.data + " ");
            inorder(node.rightChild);
        }
    }

    public void postorder(TNode node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.data + " ");
        }
    }

    public void preorder(TNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }

    public void displayTree() //I did not write this, I copy pasted this from book code, will rewrite myself in future
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                TNode temp = (TNode) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }  // end displayTree()

    public void traverse(TraverseType type) {
        switch (type.getType()) {
            case 0:   //HOW TO case TraverseType.INORDER.type???
                inorder(this.root);
                break;
            case 1:
                preorder(this.root);
                break;
            case 2:
                postorder(this.root);
                break;
            default:
                break;


        }
    }

    public void insert(int data) {
    /*
    *   X - the node that is in fault or to be inserted (named 'current' in this code)
    *   P - The parent of the node X
    *   G - the Grandparent of the node to be inserted
    *
    *  1. When you encounter a black node with two red children, flip the colors.
    *
    *  2. Rotations on the way down - when you have two reds, rotations are required. This happens when you flip the colors
    *   2a. When the child is a outside grandchild
    *   -   1. Switch color of the P
    *   -   2. Switch color of the G
    *   -   3. Rotate G so that P is now the root of both X and G
    *   2b. When the child is a inside grandchild (two rotations required)
    *   -   1. Switch the color of X
    *   -   2. Switch the color of G
    *   -   3. Rotate P so that we get the same case outside Grandchild
    *   -   4. Rotate G to get X (which used to be the child of P) is now root of G and P.
    *  3. Rotations after insertion
    *   - Happens when the newly inserted node is red as well as the parent
    *   - Rotations are same as above (inside grandchild and outside grandchild etc.)
    *
    *   Which direction am I supposed to rotate?
    *       - The opposite direction in which the offending child is in. If the offending child is in right, rotate the
    *       parent node in left direction and vice versa.
    *
    *
    * */
        TNode grandParent = null;
        TNode parent = null;
        TNode current = root;
        TNode newNode = new TNode(data);
        boolean isLeft;
        if (current == null) {
            root = newNode;
            root.isRed = false;
        } else {
            do {
                if (current.leftChild != null && current.rightChild != null) {
                    if (current.isRed == false && current.leftChild.isRed && current.rightChild.isRed) { //flip the color of root if black followed by two reds
                        flipColor(current);
                    }
                }
                if (parent != null && grandParent != null) {

                    if (current.isRed && parent.isRed) { //rotations on the way down
                        if (!isInnerGrandChild(current, parent, grandParent)) {
                            switchColor(parent);
                            switchColor(grandParent);
                            if (grandParent.leftChild == parent) {
                                rotateRight(grandParent);
                            } else if (grandParent.rightChild == parent) {
                                rotateLeft(grandParent);
                            }
                        } else {
                            switchColor(current);
                            switchColor(grandParent);
                            if (parent.rightChild == current) { //rotate parent
                                rotateLeft(parent);
                            } else if (parent.leftChild == current) {
                                rotateRight(parent);
                            }
                            if (grandParent.rightChild == parent) { //rotate grandparent
                                rotateLeft(grandParent);
                            } else if (grandParent.leftChild == parent) {
                                rotateRight(grandParent);
                            }

                        }

                    }
                }
                grandParent = parent;
                parent = current;

                if (data < current.data) {
                    isLeft = true;
                    current = current.leftChild;
                } else {
                    isLeft = false;
                    current = current.rightChild;
                }

            } while (current != null);
            if (isLeft) {
                parent.leftChild = newNode;

            } else {
                parent.rightChild = newNode;
            }
            if (parent.isRed) { //rotation after insertion
                if (!isInnerGrandChild(newNode, parent, grandParent)) { //is outside grandchild
                    switchColor(parent);
                    switchColor(grandParent);
                    if (grandParent.leftChild == parent) {
                        rotateRight(grandParent);
                    } else if (grandParent.rightChild == parent) {
                        rotateLeft(grandParent);
                    }
                } else {
                    switchColor(newNode);
                    switchColor(grandParent);
                    if (parent.rightChild == newNode) { //rotate parent
                        rotateLeft(parent);
                    } else if (parent.leftChild == newNode) {
                        rotateRight(parent);
                    }
                    if (grandParent.rightChild == parent) {
                        rotateLeft(grandParent);
                    } else if (grandParent.leftChild == parent) {
                        rotateRight(grandParent);
                    }
                }


            }

        }
        if (root.isRed) {
            root.isRed = false;
        }

    }

    private boolean isInnerGrandChild(TNode current, TNode parent, TNode grandParent) {
        boolean isLeft = false;
        if (grandParent.leftChild == parent) {
            isLeft = true;
        }
        if (parent.rightChild == current && isLeft) {
            return true;
        } else if (parent.leftChild == current && !isLeft) {
            return true;
        }

        return false;
    }

    public void switchColor(TNode node) {
        if (node.isRed) {
            node.isRed = false;
        } else {
            node.isRed = true;
        }
    }
    public void flipColor(TNode node) {
        switchColor(node);
        switchColor(node.leftChild);
        switchColor(node.rightChild);
    }


    public void rotateLeft(TNode node) {
        //Also remember that you also need to reassign newParent's children
        //When revising for rotations, draw it out on paper, hard to understand from code
        if (node.rightChild != null) {
            TNode oldParent = new TNode(node.data);
            oldParent.isRed = node.isRed;
            oldParent.isDeleted = node.isDeleted;
            TNode newParent = node.rightChild;
            oldParent.rightChild = newParent.leftChild;
            //comment below
            oldParent.leftChild = node.leftChild;
            node.rightChild = newParent.rightChild;
            node.data = newParent.data;
            node.leftChild = oldParent;
            /*TNode newParent = node.rightChild;
            TNode temp = node;
            temp.rightChild = newParent.leftChild;
            newParent.leftChild = temp;
            swapNodes(node,newParent);*/
        } else {
            System.out.println("RotateLeft can only be performed when the node has a right child. ");
        }
    }


    public void rotateRight(TNode node) {
        if (node.leftChild != null) {
            TNode oldParent = new TNode(node.data);
            oldParent.isRed = node.isRed;
            oldParent.isDeleted = node.isDeleted;
            TNode newParent = node.leftChild;
            oldParent.leftChild = newParent.rightChild;
            //comment below
            oldParent.rightChild = node.rightChild;
            node.leftChild = newParent.leftChild;
            node.data = newParent.data;
            node.rightChild = oldParent;
            /*TNode newParent = node.leftChild;
            TNode temp = node;
            temp.leftChild = newParent.rightChild;
            newParent.rightChild = temp;
            swapNodes(node,newParent);*/
        } else {
            System.out.println("RotateRight can only be performed when the node has a left child.");
        }
    }
    private void swapNodes(TNode node1, TNode node2) {
        TNode temp = new TNode(node1.data);
        temp.isRed = node1.isRed;
        temp.leftChild = node1.leftChild;
        temp.rightChild = node1.rightChild;
        node1.data = node2.data;
        node1.isRed = node2.isRed;
        node1.leftChild = node2.leftChild;
        node1.rightChild = node2.rightChild;
        node2.data = temp.data;
        node2.isRed = temp.isRed;
        node2.leftChild = temp.leftChild;
        node2.rightChild = temp.rightChild;

    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        Random rand = new Random();
        for (int i = 0; i < 16; i++) {
            tree.insert(Math.abs(rand.nextInt() % 100));
        }
        tree.displayTree();

        /*Tree tree = new Tree(); //Inside grandchild tree; rotations on the way down
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(31);
        tree.insert(43);
        tree.insert(28);
        tree.displayTree();*/


        /*Tree tree = new Tree(); //Outside grandchild tree; rotations on the way down
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(6);
        tree.insert(18);
        tree.insert(3);
        tree.displayTree();*/



        /*Tree tree = new Tree(); //Inside grandchild tree; after the node is inserted
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(18);
        tree.displayTree();*/

        /*Tree tree = new Tree();
        tree.insert(50); //Outside Grandchild tree; after the node is inserted
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(6);
        tree.displayTree();*/
    }
}
