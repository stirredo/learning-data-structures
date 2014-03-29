/**
 * Created by stirredo on 19/3/2014.
 */
public class Vertex {
    public char label;
    public boolean wasVisited;
    public Vertex(char label) {
        this.label = label;
    }
    public void displayVertex() {
        System.out.print(label);
    }
}
