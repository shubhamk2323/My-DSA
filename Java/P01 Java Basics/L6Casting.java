//casting
import java.util.*;
public class L6Casting{
    public static void main(String[] a){
        // implicit casting
        double price=100.00;
        double finalp=price + 18;
        /*here double is storing int as it is 
        larger than it.*/

        System.out.println(finalp);

        //expilcit casting
        /*here float is forcefully converted to int so 
        info is lost*/

        int p=100;
        int P=p+(int)18.120;
        System.out.println(P);

        final int i=9;
        //i=10;//error
        System.out.print(i);

    }
}