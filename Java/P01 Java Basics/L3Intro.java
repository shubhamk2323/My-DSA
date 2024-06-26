/*public class intro{
    public static void HelloWorld(String a){
        System.out.println("Hello World");
    }
    public static void main(String [] a){
        HelloWorld("print");
    }
}*/
import java.util.*;
public class L3Intro{
    public static String name;
    //int age;
    public static void main(String[] a){
        //intro obj=new intro();
        Scanner s=new Scanner(System.in);
        name=s.nextLine();
        System.out.println("Hello! "+ name);
    }
}