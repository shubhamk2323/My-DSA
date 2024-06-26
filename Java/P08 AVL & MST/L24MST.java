import java.util.*;

public class L24MST{
    public static int mx=0;
    public class Node{
        Vector<Integer> keys = new Vector<Integer>();
        Vector<Node> children = new Vector<Node>();
    }
    public static boolean checkLess(Vector<Integer> v, int key){
        for (int i=1;i<v.size();i++){
            if (v.get(i-1)>key){
                return false;
            }
            if (v.get(i)<(v.get(i-1))){
                return false;
            }
        }
        if (v.get(v.size()-1)>key){
            return false;
        }
        return true;
    }
    public static boolean checkMore(Vector<Integer> v, int key){
        for (int i=1;i<v.size();i++){
            if (v.get(i-1)<key){
                return false;
            }
            if (v.get(i)<(v.get(i-1))){
                return false;
            }
        }
        if (v.get(v.size()-1)<key){
            return false;
        }
        return true;
    }
    public static boolean checkMiddle(Vector<Integer> v, int key, int aag){
        for (int i=1;i<v.size();i++){
            if (v.get(i-1)<key || v.get(i-1)>aag){
                return false;
            }
            if (v.get(i)<(v.get(i-1))){
                return false;
            }
        }
        if (v.get(v.size()-1)<key || v.get(v.size()-1)>aag){
            return false;
        }
        return true;
    }
    public static int sum(Vector<Integer> v){
        int sum=0;
        for (int i=0;i<v.size();i++){
            sum+=v.get(i);
        }
        return sum;
    }
    public static void mst(Node temp, Vector<Integer> vec){
        if(temp.children.size()==0){
            return;
        }
        for(int i=0;i<temp.children.size();i++){
            Node tt=temp.children.get(i);
            mst(tt, vec);
            Vector<Integer> v=tt.keys;
            if (i==0){
                boolean f= checkLess(v, temp.keys.get(0));
                if (f){
                    vec.add(sum(v));
                }
                else{
                    vec.add(0);
                }
            }
            else if(i==(temp.children.size()-1)){
                boolean f=checkMore(v, temp.keys.get(temp.keys.size()-1));
                if (f){
                    vec.add(sum(v));
                }
                else{
                    vec.add(0);
                }
            }
            else{
                boolean f=checkMiddle(v, temp.keys.get(i-1), temp.keys.get(i));
                if (f){
                    vec.add(sum(v));
                }
                else{
                    vec.add(0);
                }
            }
        }
        int s=0;
        int cnt0=0;
        for(int i=0;i<vec.size();i++){
            System.out.println(vec.get(i));
            if (vec.get(i)==0){
                cnt0+=1;
            }
            s+=vec.get(i);
            mx=Math.max(vec.get(i),mx);
        }
        if (cnt0==0){
            Vector<Integer> t=temp.keys;
            for (int i=0;i<t.size();i++){
                s+=t.get(i);
            }
            mx=Math.max(mx,s);
        }
        vec.clear();
    }
    public static int getMaxMST(Node temp){
        // Write your code here
        Vector<Integer> vec=new Vector<>();
        mst(temp, vec);
        return mx;
    }

    public static void main(String args[]){

        // Test Case 1:
        L24MST tree = new L24MST();
        Node root = tree.new Node();
        root.keys.add(10);
        root.keys.add(20);
        Node temp = tree.new Node();
        temp.keys.add(2);
        temp.keys.add(4);
        root.children.add(temp);
        temp = tree.new Node();
        temp.keys.add(15);
        root.children.add(temp);
        temp = tree.new Node();
        temp.keys.add(25);
        temp.keys.add(22);
        root.children.add(temp);
        Node sec=root.children.get(0);
        temp=tree.new Node();
        temp.keys.add(-100);
        temp.keys.add(1);
        temp.keys.add(1);
        sec.children.add(temp);
        temp=tree.new Node();
        temp.keys.add(2);
        temp.keys.add(2);
        temp.keys.add(2);
        sec.children.add(temp);
        temp=tree.new Node();
        temp.keys.add(4);
        temp.keys.add(4);
        temp.keys.add(4);
        sec.children.add(temp);
        int ans = getMaxMST(root);
        System.out.println(ans);
    }
    
}