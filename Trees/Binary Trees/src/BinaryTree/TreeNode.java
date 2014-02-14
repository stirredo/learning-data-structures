package BinaryTree;

/**
 * Created by stirredo on 2/12/14.
 */
public class TreeNode {
    public int getData() {
        return data;
    }

    int data;
    TreeNode leftChild;
    TreeNode rightChild;
    public TreeNode(int data) {
        this.data = data;
    }
    public void displayNode() {
        System.out.print(data);
    }

}
