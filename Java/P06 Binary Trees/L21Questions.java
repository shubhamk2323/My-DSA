import java.util.*;

public class L21Questions{

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

    public static int sumoflongestpath(Node root, int sum, int maxsum, int len, int maxlen){
        if(root==null){
            if(maxlen<len){
                len=maxlen;
                maxsum=sum;
            }
            if(maxlen==len){
                maxsum= Math.max(maxsum, sum);
            }
            return maxsum;
        }
        sum+=root.data;
        int maxsum1= sumoflongestpath(root.left, sum, maxsum, len+1, maxlen);
        int maxsum2= sumoflongestpath(root.right, sum, maxsum, len+1, maxlen);
        maxsum=Math.max(maxsum1, maxsum2);
        return maxsum;
    }

    public static Node lca(Node root,int n1, int n2){
        if(root==null){
            return null;
        }
        if(root.data==n1 || root.data==n2){
            return root;
        }
        Node leftans= lca(root.left, n1, n2);
        Node rightans= lca(root.right, n1, n2);
        if(leftans!= null && rightans!= null){
            return root;
        }
        else if(leftans== null && rightans!= null){
            return rightans;
        }
        else if(leftans!= null && rightans== null){
            return leftans;
        }
        else{
            return null;
        }
    }

    public static void solve(Node root, int k, int[] count, Vector<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        solve(root.left, k, count, path);
        solve(root.right, k, count, path);
        int sum=0;
        for(int i=path.size()-1; i>=0; i--){
            sum+=path.get(i);
            if(sum==k){
                count[0]++;
            }
        }
        path.remove(path.size()-1);
    }

    public static int sumK(Node root, int k){
        Vector<Integer> path= new Vector<>();
        int[] c=new int[]{0};
        solve(root, k, c, path);
        return c[0];
    }

    public static Node reverse(Node root){
        Node x= root;
        if(root.left.left==null && root.left.right==null){
            Node t= root.right;
            root.right= root.left;
            root.left= t;
            return root;
        }
        reverse(root.left);
        reverse(root.right);
        Node t= root.right;
        root.right= root.left;
        root.left= t;
        return x;
    }

    public static void levelordertraversal(Node root){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node t= q.remove();
            if(t==null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                System.out.print(t.data+" ");
                if ((t.left)!=null){
                    q.add(t.left);
                }
                if((t.right)!=null){
                    q.add(t.right);
                }
            }
        }
    }

    public static void main(String [] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(5);
        root.left.right=new Node(14);
        root.right.left=new Node(27);
        root.right.right=new Node(8);
        root.left.left.left= new Node(18);
        root.left.left.right= new Node(31);
        root.left.right.left= new Node(33);
        root.left.right.right= new Node(78);
        root.right.left.left= new Node(46);
        root.right.left.right= new Node(59);
        root.right.right.left= new Node(10);
        root.right.right.right= new Node(56);
        levelordertraversal(root);
        Node x= reverse(root);
        levelordertraversal(x);
    }

}