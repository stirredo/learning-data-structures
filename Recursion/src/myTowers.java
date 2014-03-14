/**
 * Created by stirredo on 2/27/14.
 * Note: I know how to solve this manually (https://www.youtube.com/watch?v=uZaHTmOuqJI) and the steps this program
 * generates matches those steps but this still seems like sorcery to me. I understand the backtrace mechanism of rec-
 * ursion but this program....dayum
 */
public class myTowers {
    static int nDisks = 4;
    public static void doTowers(int nTop, String source, String intermediate, String destination) {
        if(nTop == 1) {
            System.out.println("Moving "+ nTop+ " from "+ source + " to " + destination);
        } else {
            doTowers(nTop - 1, source, destination, intermediate); //from source to inter
            System.out.println("Moving "+ nTop+ " from "+ source + " to " + destination);
            doTowers(nTop - 1, intermediate, source, destination); //from inter to destination
        }

    }

    public static void main(String[] args) {
        doTowers(nDisks,"A","B","C");
    }
}
