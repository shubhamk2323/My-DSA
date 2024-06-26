import java.util.*;
import java.io.*;

public class L16Questions{

    public static String reverse(String s){
        Stack<String> str= new Stack<>();
        for (int i=0;i<s.length();i++){
            String y=""+s.charAt(i);
            str.push(y);
        }
        String x="";
        int j=str.size();
        for(int i=0; i<j;i++){
            x=x+str.pop();
        }
        return x;
    }

    public static void delmid(Stack<Integer> s,int size, int c){
        if(c==size/2){
            s.pop();
            return;
        }
        
        int x=s.peek();
        s.pop();
        delmid(s,size,c+1);
        s.push(x);
    }

    public static boolean valid_parenthesis(String a){
        String open="[{(";
        String close=")}]";
        Stack<String> s=new Stack<>();
        for (int j=0; j<a.length();j++){
            char i=a.charAt(j);
            if (open.contains(i+"")){
                s.push(i+"");
            }
            else{
                String h=s.peek();
                if(h.equals("(") && i==')'){
                    s.pop();
                }
                else if(h.equals("{") && i=='}'){
                    s.pop();
                }
                else if(h.equals("[") && i==']'){
                    s.pop();
                }
            }
        }
        return s.empty();
    }

    public static void insertatbottom(Stack<Integer> s, int x){
        if (s.empty()){
            s.push(x);
            return;
        }
        int num=s.pop();
        insertatbottom(s,x);
        s.push(num);
    }

    public static void sortedstack(Stack<Integer> s, int num){
        if (s.empty() || (!s.empty()&& s.peek()<num) ){
            s.push(num);
            return;
        }
        int n=s.pop();
        sortedstack(s,num);
        s.push(n);
    }

    public static void sortstack(Stack<Integer> s){
        if (s.empty()){
            return;
        }
        int num=s.pop();
        sortstack(s);
        sortedstack(s,num);
    }

    public static boolean faltubraket(String s){
        Stack<Character> st=new Stack<>();
        for (int i=0; i<s.length(); i++){
            char x=s.charAt(i);
            if (x=='(' || x=='+' || x=='-' || x=='*' || x=='/'){
                st.push(x);
            }
            else if (x==')'){
                boolean red=true;
                while(st.peek()!='('){
                    char y=st.peek();
                    if (y=='+' || y=='-' || y=='*' || y=='/'){
                        red=false;
                    }
                    st.pop();
                }
                if (red==true){
                    return true;
                }
                st.pop();
            }
        }
        return false;
    }

    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> s= new Stack<>();
        s.push(-1);
        ArrayList<Integer> ans= new ArrayList<>();
        for (int j=0; j<arr.size(); j++){
            ans.add(-1);
        }
        for (int i=n-1; i>=0; i--){
            int x= arr.get(i);
            while(s.peek()>=x){
                s.pop();
            }
            ans.set(i,s.peek());
            s.push(x);
        }
        return ans;
    }

    public static ArrayList<Integer> nextSmallerElement2(int[] arr, int n){
        Stack<Integer> s= new Stack<>();
        s.push(-1);
        ArrayList<Integer> ans= new ArrayList<>();
        for (int j=0; j<n; j++){
            ans.add(-1);
        }
        
        for (int i=n-1; i>=0; i--){
            int x= arr[i];
            while(s.peek()!=-1 && arr[s.peek()]>=x){
                s.pop();
            }
            ans.set(i,s.peek());
            s.push(i);
        }
        return ans;
    }

    public static ArrayList<Integer> prevSmallerElement2(int[] arr, int n){
        Stack<Integer> s= new Stack<>();
        s.push(-1);
        ArrayList<Integer> x= new ArrayList<>();
        for (int j=0; j<n; j++){
            x.add(-1);
        }
        for(int i=0; i<n; i++){
            int c=arr[i];
            while(s.peek()!=-1 && arr[s.peek()]>=c){
                s.pop();
            }
            x.set(i,s.peek());
            s.push(i);
        }
        return x;
    }

    public static int largestrectarea(int [] ht){
        int n=ht.length;
        Vector<Integer> ans= new Vector<>();
        ArrayList<Integer> next= new ArrayList<>();
        ArrayList<Integer> prev= new ArrayList<>();
        next=nextSmallerElement2(ht,ht.length);
        prev=prevSmallerElement2(ht,ht.length);
        int area=0;
        for(int i=0; i<n; i++){
            int l=ht[i];
            if(next.get(i)==-1){
                next.set(i,n);
            }
            int b= next.get(i)-prev.get(i)-1;
            int ar=l*b;
            area=Math.max(area,ar);
        }
        return area;
    }

    public static boolean knows(int[][] M, int a, int b){
        if(M[a][b]==1){
            return true;
        }
        else{
            return false;
        }
    }

    public static int celebrity(int[][] M, int n){
        Stack<Integer> s= new Stack<>();
        for(int i=0; i<n; i++){
            s.push(i);
        }
        while(s.size()>1){
            int a= s.pop();
            int b=s.pop();
            if(knows(M,a,b)){
                s.push(b);
            }
            else{
                s.push(a);
            }
        }
        int ans=s.peek();
        int c=0;
        int oc=0;
        for(int i=0; i<n; i++){
            if(M[ans][i]==0){
                c++;
            }
            else if(M[i][ans]==1){
                oc++;
            }
        }
        if(c!=n){
            return 0;
        }
        if(oc!=n-1){
            return 0;
        }
        return ans;
    }

    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<>();
        a.add(9);
        a.add(11);
        a.add(5);
        a.add(6);
        a.add(3);
        a.add(7);
        int[] d={9,11,5,6,3,7};
        System.out.println(largestrectarea(d));
    }
}