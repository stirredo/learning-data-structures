package RedBlackTree;

/**
 * Created by stirredo on 12/5/2014.
 */
public class TNode {
    public int data; //Key and value same in this tree
    public TNode leftChild;
    public TNode rightChild;
    public boolean isDeleted;
    public boolean isRed;

    TNode(int data) {
        this.data = data;
        this.isRed = true; //New node in RBTree is always red
        this.isDeleted = false;
        leftChild = null;
        rightChild = null;
    }



}
