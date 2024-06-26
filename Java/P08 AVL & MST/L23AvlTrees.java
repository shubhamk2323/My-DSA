import java.util.*;

public class L23AvlTrees{

    public static class Node{
        int data;
        int height;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            this.height=1;
            this.left=null;
            this.right=null;
        }
    }
    /*
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        return root.height;
    }

    public static int getbalance(Node root){
        if(root==null){
            return 0;
        }
        return height(root.left)-height(root.right);
    }

    public static Node rightrotate(Node root){
        Node x= root.left;
        Node y=x.right;

        x.right=root;
        root.left= y;
        root.height= Math.max(height(root.left), height(root.right))+1;
        x.height= Math.max(height(x.left), height(x.right))+1;
        return x;
    }

    public static Node leftrotate(Node root){
        Node x= root.right;
        Node y= x.left;

        x.left=root;
        root.right= y;
        root.height= Math.max(height(root.left), height(root.right))+1;
        x.height= Math.max(height(x.left), height(x.right))+1;
        return x;
    }

    

    public static Node insert(Node root, int key){
        if(root==null){
            return new Node(key);
        }if(key<root.data){
            root.left= insert(root.left, key);
        }else if(key> root.data){
            root.right= insert(root.right, key);
        }else{
            return root;
        }
        root.height=1+Math.max(height(root.left), height(root.right));
        int balance= getbalance(root);
        if(balance>1 && key< root.left.data){
            return rightrotate(root);
        }else if(balance<-1 && key> root.right.data){
            return leftrotate(root);
        }else if(balance>1 && key>root.left.data){
            root.left= leftrotate(root.left);
            return rightrotate(root);
        }if(balance<-1 && key< root.right.data){
            root.right= rightrotate(root.right);
            return leftrotate(root);
        }
        return root;
    }*/

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

    public static Node insert(Node root, int key){
        if(root==null){
            return new Node(key);
        }
        if(key<root.data){
            root.left= insert(root.left, key);
        }
        else if(key>root.data){
            root.right= insert(root.right, key);
        }
        else{
            return root;
        }

        root.height= 1+Math.max(height(root.left), height(root.right));
        int balance= getbalance(root);
        if(balance>1 && key<root.left.data){
            return rightrotate(root);
        }
        else if(balance<-1 && key>root.right.data){
            return leftrotate(root);
        }
        else if(balance>1 && key>root.left.data){
            root.left= leftrotate(root.left);
            return rightrotate(root);
        }
        else if(balance<-1 && key< root.right.data){
            root.right= rightrotate(root.right);
            return leftrotate(root);
        }
        return root;

    }

    public static Node rightrotate(Node root){
        Node x= root.left;
        Node y= x.right;

        x.right= root;
        root.left= y;
        root.height= Math.max(height(root.left), height(root.right))+1;
        x.height= Math.max(height(x.left), height(x.right))+1;
        return x;
    }

    public static Node leftrotate(Node root){
        Node x= root.right;
        Node y= x.left;

        x.left= root;
        root.right= y;
        root.height= Math.max(height(root.left),height(root.right))+1;
        x.height= Math.max(height(x.left), height(x.right))+1;
        return x;
    }

    public static int getbalance(Node root){
        if(root==null){
            return 0;
        }
        return height(root.left)- height(root.right);
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        return root.height;
    }

    public static void main(String [] args){
        Node root=new Node(10);
        root= insert(root, 9);
        root= insert(root, 20);
        root= insert(root, 15);
        root= insert(root, 13);
        root= insert(root, 11);
        root= insert(root, 14);
        levelordertraversal(root);
    }

}