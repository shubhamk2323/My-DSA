import java.util.*;
class L4Loop{
    public static void main(String[] a){
        /*for (int i=1;i<100;i=i+10){
            System.out.println(i);
        }*/
        System.out.print("Enter any number:");
        Scanner s = new Scanner(System.in);
        int x=s.nextInt();
        if(x%2==0){
            System.out.println("Even");
        }
        else{
            System.out.println("Odd");
        }
    }
}