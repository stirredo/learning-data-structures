package BinaryTree;

import java.util.Stack;

/**
 * Created by stirredo on 2/12/14.
 */
public class Tree {
    private TreeNode root;
    public enum TraverseType {
        INORDER(0),
        PREORDER(1),
        POSTORDER(2);

        int type;
        int getType(){
            return this.type;
        }
        TraverseType(int type) {
            this.type = type;
        }
    }
    public Tree() {
        this.root = null;
    }
    public TreeNode find(int key) {
        TreeNode current = root;
        while(current != null) {
            if(current.data == key) {
                return current;
            } else if(key < current.data) {
                current = current.leftChild;

            } else if(key > current.data) {
                current = current.rightChild;
            }
        }
        return null;
    }
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        TreeNode current = root;
        TreeNode parent;
        if(current == null) {
            root = newNode;
        } else {
            while(true) {
                if(newNode.data < current.data) {
                    parent = current;
                    current = current.leftChild;
                    if(current == null) {
                        parent.leftChild = newNode;
                        break;
                    }
                } else {    //also handles when data is == to current
                    parent = current;
                    current = current.rightChild;
                    if(current == null) {
                        parent.rightChild = newNode;
                        break;
                    }
                }

            }
        }
    }
    //traverse methods
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


    public void inorder(TreeNode node) {
        if(node != null) {
            inorder(node.leftChild);
            node.displayNode(); System.out.print(" ");
            inorder(node.rightChild);
        }
    }
    public void postorder(TreeNode node) {
        if(node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            node.displayNode(); System.out.print(" ");
        }
    }
    public void preorder(TreeNode node) {
        if(node != null) {
            node.displayNode(); System.out.print(" ");
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }
    public TreeNode minimum() { //returns the minimum to the whole tree
        if(root != null) {
            TreeNode current;
            current = root;
            while(true) {
                if(current.leftChild != null) {
                    current = current.leftChild;
                } else {
                    return current;
                }
            }

        } else return null;
    }
    public TreeNode minimum(TreeNode node) { //returns a minimum relative to that particular node
        if(node != null) {
            TreeNode current = node;
            while(true) {
                if(current.leftChild != null) {
                    current = current.leftChild;
                } else {
                    return current;
                }
            }
        } else return null;
    }
    public TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successorParent = delNode;
        TreeNode successor = delNode.rightChild;
        while(true) {
            if(successor.leftChild != null) {
                successorParent = successor;
                successor = successor.leftChild;
            } else {
                break;
            }
        }
        if(successor == delNode.rightChild && successor.rightChild != null) {
            //For this case http://i.imgur.com/Ri5S9RJ.png -- you are supposed to delete 11 and the successor 16 has node 20
            //Hope the link is still alive when you look at it in the future.
            successorParent.rightChild = successor.rightChild;

        } else if (successor.rightChild != null) { //successorParent has successor on the left
            successorParent.leftChild = successor.rightChild;
        } else {
            successorParent.leftChild = null;
        }

        return successor;
    }

    public boolean delete(int key) {
            /* Algo:
            *  1. find the specified node
            *  2. if specified node found, check if it has children
            *  3. Case 1: It has no children
                 *If no children, simply set the parent leftChild or rightChild to null.
            *  4. Case 2: It has one child
                 * simply snip that node and connect parent to the deleted node's child
            *  5. Case 3: It has two children:
                 *  Go to the node's right child
                 *  Find a successor i.e the next largest node than the node to be deleted ex. 25 -> 35 -> 30 then you
                 *  are supposed to find 30
                 *  Remove the successor from its position and place it in place of the node to be deleted
            *
            *
            * */
        TreeNode current = root;
        TreeNode parent = null;
        boolean isLeftChild = false;

        //find the node
        while(current != null) {
            if(current.data == key) {
                break;
            } else if (key < current.data) {
                parent = current;
                isLeftChild = true;
                current = current.leftChild;
            } else if (key > current.data) {
                parent = current;
                isLeftChild = false;
                current = current.rightChild;
            }
        }


        if(current != null) {
            if(current.leftChild == null && current.rightChild == null) {
                if(current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }

            } else if (current.leftChild != null ^ current.rightChild != null) { //^ Operator means XOR
                if(current.leftChild != null) {
                    if (isLeftChild) {
                        parent.leftChild = current.leftChild;
                    } else {
                        parent.rightChild = current.leftChild;
                    }
                } else if (current.rightChild != null) {
                    if(isLeftChild) {
                        parent.leftChild = current.rightChild;
                    } else {
                        parent.rightChild = current.rightChild;
                    }
                }


            } else if (current.leftChild != null && current.rightChild != null) {
                TreeNode successor = getSuccessor(current);
                if(isLeftChild) {
                    parent.leftChild = successor;

                } else {
                    parent.rightChild = successor;
                }
                successor.leftChild = current.leftChild; //replace all the links of left side of the node to be deleted to successor
                successor.rightChild = current.rightChild;



            }
            current = null; //deletes the current node; although it will be garbage collected automatically (?)
            return true;
        } else {
            //Node not found
            return false;
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
        while(isRowEmpty==false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int j=0; j<nBlanks; j++)
                System.out.print(' ');

            while(globalStack.isEmpty()==false)
            {
                TreeNode temp = (TreeNode)globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.getData());
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }  // end displayTree()


}
