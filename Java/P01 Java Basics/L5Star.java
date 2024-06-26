import java.util.*;
class L5Star{
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        int p = sc.nextInt();
        while(p>0){
            for (int j=0;j<p;j++){
                System.out.print("*");
            }
            System.out.print("\n");
            p=p-1;
        }
    }
}