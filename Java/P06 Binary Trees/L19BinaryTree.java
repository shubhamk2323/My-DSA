import java.util.*;
public class L19BinaryTree{
    
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
    

    public static class moye{
        int first;
        int second;
        moye(int a, int b){
            this.first=a;
            this.second=b;
        }
    }

    public static class pairs{
        Node first;
        moye second;
        pairs(Node first, moye second){
            this.first= first;
            this.second= second;
        }
    }

    public static Vector<Integer> Vert(Node root){
        Map<Integer, Map<Integer, Vector<Integer>>> nodes= new TreeMap<>();
        Queue<pairs> q= new LinkedList<>();
        Vector<Integer> ans= new Vector<>();
        if (root==null){
            return ans;
        }
        moye m= new moye(0,0);
        q.add(new pairs(root, m));

        while(!q.isEmpty()){
            pairs t= q.remove();
            Node x= t.first;
            int h= t.second.first;
            int l= t.second.second;
            if (!nodes.containsKey(h))
                nodes.put(h, new TreeMap<>());
            if (!nodes.get(h).containsKey(l))
                nodes.get(h).put(l, new Vector<>());
            nodes.get(h).get(l).add(x.data);
            if(x.left!=null){
                q.add(new pairs(x.left, new moye(h-1, l+1)));
            }
            if(x.right!=null){
                q.add(new pairs(x.right, new moye(h+1, l+1)));
            }
        }
        for (Map<Integer, Vector<Integer>> entry : nodes.values()) {
            for (Vector<Integer> list : entry.values()) {
                ans.addAll(list);
            }
        }
        return ans;
    }
    
    public static void main(String [] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(5);
        root.left.right=new Node(6);
        root.right.left=new Node(7);
        root.right.right=new Node(8);
        System.out.println(Vert(root));
    }
    /*
    // Function to find the vertical order traversal of Binary Tree.
    public static ArrayList<Integer> Vert(Node root) {
        Map<Integer, Map<Integer, List<Integer>>> nodes = new TreeMap<>();
        Queue<Pair<Node, Pair<Integer, Integer>>> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        q.add(new Pair<>(root, new Pair<>(0, 0)));

        while (!q.isEmpty()) {
            Pair<Node, Pair<Integer, Integer>> temp = q.poll();
            Node frontNode = temp.getKey();
            int hd = temp.getValue().getKey();
            int lvl = temp.getValue().getValue();
            if (!nodes.containsKey(hd))
                nodes.put(hd, new TreeMap<>());
            if (!nodes.get(hd).containsKey(lvl))
                nodes.get(hd).put(lvl, new ArrayList<>());

            nodes.get(hd).get(lvl).add(frontNode.data);
            if (frontNode.left != null)
                q.add(new Pair<>(frontNode.left, new Pair<>(hd - 1, lvl + 1)));

            if (frontNode.right != null)
                q.add(new Pair<>(frontNode.right, new Pair<>(hd + 1, lvl + 1)));
        }

        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : nodes.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> innerEntry : entry.getValue().entrySet()) {
                ans.addAll(innerEntry.getValue());
            }
        }
        return ans;
    }


    public static class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    public static class Pair<K, V> {
        private final K key;
        private final V value;
    
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    
        public K getKey() {
            return key;
        }
    
        public V getValue() {
            return value;
        }
    }*/
    
}