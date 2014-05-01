package Graph;

/**
 * Created by stirredo on 30/4/2014.
 */
public class Vertex {
    public char label;
    public boolean isInTree;
    public Vertex(char label) {
        this.label = label;
        isInTree = false;
    }

    public void displayVertex() {
        System.out.println(this.label);

    }
}
