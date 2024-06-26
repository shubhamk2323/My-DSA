import java.util.*;
import java.io.*;

public class L20Traversals{

    public static class pairs{
        int first;
        int second;
        pairs(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public static class Pair{
        boolean first;
        int second;
        Pair(boolean first, int second){
            this.first=first;
            this.second=second;
        }
    }

    public static class maps{
        int first;
        Vector<Integer> second;
        maps(int first, Vector<Integer> second){
            this.first= first;
            this.second= second;
        }
    }

    public static class nodes{
        int first;
        maps second;
        nodes(int first, maps second){
            this.first=first;
            this.second= second;
        }
    }

    public static class pair{
        Node first;
        pairs second;
        pair(Node first, pairs second){
            this.first=first;
            this.second= second;
        }
    }

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

    public static Node buildtree(Node root){
        System.out.println("Enter data");
        Scanner s= new Scanner(System.in);
        int data= s.nextInt();
        root = new Node(data);
        if (data==-1){
            return null;
        }
        System.out.println("Enter data to left:");
        root.left=buildtree(root.left);
        System.out.println("Enter data to right:");
        root.right=buildtree(root.right);
        return root;
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

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root){
        if (root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static int ht_of_tree(Node root){
        if(root==null){
            return 0;
        }
        int l= ht_of_tree(root.left);
        int r= ht_of_tree(root.right);
        int a= Math.max(l,r)+1;
        return a;
    }

    public static int dia_of_tree(Node root){
        if (root==null){
            return 0;
        }
        int op1=dia_of_tree(root.left);
        int op2=dia_of_tree(root.right);
        int op3=ht_of_tree(root.left)+ht_of_tree(root.right)+1;
        int ans=Math.max(op1,Math.max(op2,op3));
        return ans;
    }

    public static pairs dia_fast(Node root){
        if (root==null){
            return new pairs(0,0);
        }
        pairs left= dia_fast(root.left);
        pairs right= dia_fast(root.right);
        int op1= left.first;
        int op2= right.first;
        int op3= left.second+right.second+1;
        int firsts= Math.max(op1,Math.max(op2,op3));
        int seconds= Math.max(left.second, right.second)+1;
        return new pairs(firsts,seconds);
    }

    public static int diameter(Node root){
        return dia_fast(root).first;
    }

    public static boolean identical_tree(Node r1, Node r2){
        if (r1==null && r2==null){
            return true;
        }
        if (r1!=null && r2==null){
            return false;
        }
        if (r1==null && r2!=null){
            return false;
        }
        boolean left= identical_tree(r1.left, r2.left);
        boolean right= identical_tree(r1.right, r2.right);
        boolean x= (r1.data==r2.data);
        if(left && right && x){
            return true;
        }
        else{
            return false;
        }
    }

    public static Pair isSumTreeFast(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }

        if (root.left == null && root.right == null) {
            return new Pair(true, root.data);
        }

        Pair leftAns = isSumTreeFast(root.left);
        Pair rightAns = isSumTreeFast(root.right);

        boolean isLeftSumTree = leftAns.first;
        boolean isRightSumTree = rightAns.first;

        int leftSum = leftAns.second;
        int rightSum = rightAns.second;

        boolean condn = root.data == leftSum + rightSum;

        Pair ans;

        if (isLeftSumTree && isRightSumTree && condn) {
            ans = new Pair(true, root.data + leftSum + rightSum);
        }
        else {
            ans = new Pair(false, 0);
        }
        return ans;
    }
    
    public static boolean isSumTree(Node root) {
        return isSumTreeFast(root).first;
    }

    public static Pair isBalanced(Node root){
        if(root==null){
            return new Pair(true,0);
        }
        Pair left= isBalanced(root.left);
        Pair right= isBalanced(root.right);

        boolean leftans= left.first;
        boolean rightans= right.first;
        boolean dif= Math.abs(left.second - right.second)<=1;
        Pair ans= new Pair(true,0);
        ans.second= Math.max(left.second, right.second)+1;
        if(leftans && rightans && dif){
            ans.first= true;
        }
        else{
            ans.first= false;
        }
        return ans;
    }

    public static boolean isBalanced2(Node root){
        return isBalanced(root).first;
    }

    public static ArrayList<Integer> levelordertraversalredux(Node root){
        Queue<Node> q= new LinkedList<>();
        ArrayList<Integer> a= new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node t= q.remove();
            a.add(t.data);
            if(t.left!=null){
                q.add(t.left);
            }
            if(t.right!=null){
                q.add(t.right);
            }
        }
        return a;
    }

    public static ArrayList<Integer> zigzagtraversal(Node root){
        ArrayList<Integer> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        boolean ltr=true;
        while(!q.isEmpty()){
            int s= q.size();
            ArrayList<Integer> a= new ArrayList<>(s);
            for (int j=0; j<s; j++){
                a.add(-1);
            }
            for (int i=0; i<s; i++){
                Node x=q.remove();
                int index;
                if(ltr){
                    index=i;
                }
                else{
                    index=s-i-1;
                }
                a.add(index,x.data);
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
            }
            ltr=!ltr;
            ans.addAll(a);
        }
        return ans;
    }

    public static void traverseleft(Node root, Vector<Integer> ans){
        if((root==null) || (root.left==null && root.right== null)){
            return;
        }
        ans.add(root.data);
        if(root.left!=null){
            traverseleft(root.left,ans);
        }
        else{
            traverseleft(root.right,ans);
        }
    }

    public static void traverseleaf(Node root, Vector<Integer> ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ans.add(root.data);
            return;
        }
        traverseleaf(root.left, ans);
        traverseleaf(root.right, ans);
    }

    public static void traverseright(Node root, Vector<Integer> ans){
        if((root==null)|| (root.left==null && root.right==null)){
            return;
        }
        if(root.right!=null){
            traverseright(root.right, ans);
        }
        else{
            traverseright(root.left, ans);
        }
        ans.add(root.data);
    }

    public static Vector<Integer> boundary(Node root){
        Vector<Integer> ans= new Vector<>();
        if(root==null){
            return ans;
        }
        ans.add(root.data);
        traverseleft(root.left, ans);
        traverseleaf(root.left, ans);
        traverseleaf(root.right, ans);
        traverseright(root.right, ans);
        return ans;
    }

    /*
    //Function to find the vertical order traversal of Binary Tree.
    vector<int> verticalOrder(Node *root)
    {
        map<int, map<int,vector<int> > > nodes;
        queue< pair<Node*, pair<int,int> > > q;
        vector<int> ans;
        
        if(root == NULL)
            return ans;
            
        q.push(make_pair(root, make_pair(0,0)));
        
        while(!q.empty()) {
            pair<Node*, pair<int,int> > temp = q.front();
            q.pop();
            Node* frontNode = temp.first;
            int hd = temp.second.first;
            int lvl = temp.second.second;
            
            nodes[hd][lvl].push_back(frontNode->data);
            
            if(frontNode->left)
                q.push(make_pair(frontNode->left, make_pair(hd-1, lvl+1) ));
                
            if(frontNode->right)
                q.push(make_pair(frontNode->right, make_pair(hd+1, lvl+1)));
        }
        
        for(auto i: nodes) {
            
            for(auto j:i.second) {
                
                for(auto k:j.second)
                {
                    ans.push_back(k);
                }
            }
        }
        return ans;
    }
    */


    public static void main(String [] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(5);
        root.left.right=new Node(6);
        root.right.left=new Node(7);
        root.right.right=new Node(8);
        System.out.println(zigzagtraversal(root));
    }
    
}