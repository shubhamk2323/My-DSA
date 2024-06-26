import java.util.*;
public class L9Questions{
    public static String leap(int i){
        if (i%400==0){
            return "Leap Year";
        }
        else if(i%100==0){
            return "Not a leap year";
        }
        else if (i%4==0){
            return "Leap Year";
        }
        else{
            return "Not a leap year";
        }
    }
    public static int remi(int x){
        while(x>=10){
            x=x%10;
        }
        return x;
    }
    public static boolean rem(int a, int b){
        if (remi(a)==remi(b)){
            return true;
        }
        else{
            return false;
        }
    }

    public static int lcm(int a,int b){
        int g;
        if (a>=b){
            g=a;
        }
        else{
            g=b;
        }
        for (int i=g;i<=a*b;i++){
            if(i%a==0 && i%b==0){
                return i;
            }
        }
        return a*b;
    }




    public static ArrayList<Float> roots(float a, float b, float c) {
        float d = (b * b) - (4 * a * c);
        float rd = (float) Math.sqrt(d);
        ArrayList<Float> root = new ArrayList<>();

        if (d < 0) {
            root.add(0.0f);  // Adding float values
            root.add(0.0f);
            return root;
        } else if (d == 0) {
            float x = (-b) / (2 * a);
            root.add(x);
            root.add(x);
            return root;
        } else {
            float x = (-b + rd) / (2 * a);
            float y = (-b - rd) / (2 * a);
            root.add(x);
            root.add(y);
            return root;
        }
    }

    public static void main(String[] a){
        Vector<Integer> v = new Vector<Integer>();
        v.add(3);
        v.add(4);
        v.add(5);
        v.add(1);
        for (int i=0; i<v.size();i++){
            System.out.println(v.get(i));
        }
        Collections.sort(v);
        for (int i=0; i<v.size();i++){
            System.out.println(v.get(i));
        }
        System.out.println();
        Collections.reverse(v);
        for (int i=0; i<v.size();i++){
            System.out.println(v.get(i));
        }
    }
}
