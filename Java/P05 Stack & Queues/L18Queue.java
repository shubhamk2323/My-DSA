import java.util.*;
import java.io.*;
public class L18Queue{

    public class PetrolPump{
        int petrol;
        int distance;
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static Queue<Integer> rev(Queue<Integer> q){
        Stack<Integer> s=new Stack<>();
        while(!q.isEmpty()){
            int x=q.remove();
            s.push(x);
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        return q;
    }

    public static int tour(PetrolPump[] p, int n) {
        int deficit = 0;
        int balance = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            balance += p[i].petrol - p[i].distance;
            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }

        if (balance + deficit >= 0)
            return start;
        return -1;
    }

    public static Queue<Integer>revfirstkqueue(Queue<Integer> q, int k){
        Stack<Integer> s= new Stack<>();
        for(int i=0; i<k; i++){
            int val= q.remove();
            s.push(val);
        }
        while(!s.empty()){
            int val=s.pop();
            q.add(val);
        }
        int t=q.size()-k;
        while(t-->0){
            int val= q.remove();
            q.add(val);
        }
        return q;
    }

    public static Vector<Integer> firstneg(int[] a, int k){
        Vector<Integer> b= new Vector<>();
        for(int i=0; i<(a.length)-(a.length%k); i++){
            boolean flag=false;
            for(int j=0; j<k; j++){
                if(a[i+j]<0){
                    b.add(a[i+j]);
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                b.add(0);
            }
        }
        return b;
    }

    public static ArrayList<Integer> firstnigga(int[] a, int k) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> z = new ArrayList<>();
        int j=0;
        for (int i=0; i<k; i++){
            if(a[i]< 0){
                q.add(a[i]);
            }
        }
        if(!q.isEmpty()){
            z.add(q.peek());
        }
        else{
            z.add(0);
        }
        for(int i=k; i<a.length; i++) {
            if(a[j]==q.peek()){
                q.remove();
            }
            if(a[i]< 0){
                q.add(a[i]);
            }
            j++;
            if(!q.isEmpty()){
                z.add(q.peek());
            }
            else{
                z.add(0);
            }
        }
        return z;
    }

    public static void main(String []args){
        Queue<Integer> q= new LinkedList<>();
        q.add(3);
        q.add(1);
        q.add(4);
        q.add(8);
        q.add(7);
        q.add(5);
        int[] a={-8,2,3,-6,10,-9,8,-2};
        System.out.println(firstnigga(a,3));
    }
}
