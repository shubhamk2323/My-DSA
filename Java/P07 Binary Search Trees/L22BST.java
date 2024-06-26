import java.util.*;
import java.io.*;

public class L22BST{

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insertinbst(Node root, int d){
        if(root==null){
            root= new Node(d);
            return root;
        }
        if(d>root.data){
            root.right= insertinbst(root.right, d);
        }
        else{
            root.left= insertinbst(root.left, d);
        }
        return root;
    }

    public static Node searchinBST(Node root, int x){
        Node temp= root;
        while(temp!=null){
            if(temp.data==x){
                return temp;
            }
            if(temp.data>x){
                temp= temp.left;
            }
            else{
                temp= temp.right;
            }
        }
        return new Node(0);
    }

    public static ArrayList<Integer> inorderBST(Node root, ArrayList<Integer> a){
        if(root==null){
            return a;
        }
        inorderBST(root.left, a);
        a.add(root.data);
        inorderBST(root.right, a);
        return a;
    }

    public static boolean isBST(Node root, int mi, int ma){
        if(root==null){
            return true;
        }
        if(root.data>= mi && root.data <=ma){
            boolean left= isBST(root.left, mi, root.data);
            boolean right= isBST(root.right, root.data, ma);
            return left&&right;
        }
        else{
            return false;
        }
    }

    public static int successor(Node root, int k){
        Node x= searchinBST(root, k);
        while(x.right!=null){
            x=x.right;
        }
        return x.data;
    }

    public static int lcaBST(Node root, int a, int b){
        if(root==null){
            return 0;
        }
        if(root.data> a && root.data>b){
            return lcaBST(root.left, a, b);
        }
        else if(root.data<= a && root.data<= b){
            return lcaBST(root.right, a, b);
        }
        return root.data;
    }

    public static boolean twosumBST(Node root, int t){
        ArrayList<Integer> a= new ArrayList<>();
        ArrayList<Integer> b=inorderBST(root,a);
        int i=0;
        int j=b.size()-1;
        while(i<j){
            int sum= b.get(i)+b.get(j);
            if(sum==t){
                return true;
            }
            if(sum>t){
                j--;
            }
            if(sum<t){
                i++;
            }
        }
        return false;
    }

    public static Node inordertoBST(int s, int e, ArrayList<Integer> ino){
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        Node root= new Node(ino.get(mid));
        root.left= inordertoBST(s, mid-1, ino);
        root.right= inordertoBST(mid+1, e, ino);
        return root;
    }

    public static void main(String args[]){
        Node root=new Node(15);
        root.left= new Node(10);
        root.right= new Node(20);
        root.left.left= new Node(5);
        root.left.right= new Node(12);
        root.right.left= new Node(17);
        root.right.right= new Node(25);
        ArrayList<Integer> a= new ArrayList<>();
        ArrayList<Integer> b= inorderBST(root, a);
        System.out.println(b);
    }

}