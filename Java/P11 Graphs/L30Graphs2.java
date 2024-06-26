import java.util.*;
public class L30Graphs2{

    public static HashMap<Integer, Vector<Integer>> create_adj(Vector<Vector<Integer>> edge){
        HashMap<Integer, Vector<Integer>> adj= new HashMap<>();
        for(Vector<Integer> i: edge){
            int u= i.get(0);
            int v= i.get(1);
            if(!adj.containsKey(u)){
                adj.put(u, new Vector<Integer>());
            }
            adj.get(u).add(v);
            if(!adj.containsKey(v)){
                adj.put(v, new Vector<Integer>());
            }
            adj.get(v).add(u);
        }
        return adj;
    }

    public static boolean isCyclicBfs(int s, HashMap<Integer, Vector<Integer>> adj){
        HashMap<Integer, Boolean> visited= new HashMap<>();
        HashMap<Integer, Integer> parent= new HashMap<>();
        Queue<Integer> q= new LinkedList<>();
        for (Integer node : adj.keySet()) {
            visited.put(node, false);
            parent.put(node, -1);
        }
        visited.put(s, true);
        q.add(s);
        while(!q.isEmpty()){
            int f= q.remove();
            for(int i: adj.get(f)){
                if(i!= parent.get(f) && visited.get(i)== true){
                    return true;
                }
                else if(!visited.get(i)){
                    q.add(i);
                    visited.put(i,true);
                    parent.put(i,f);
                }
            }
        }
        return false;
    }

    public static boolean isCyclicDfs(int s, int parent, HashMap<Integer, Boolean> visited, HashMap<Integer, Vector<Integer>> adj){
        visited.put(s,true);
        for(int i: adj.get(s)){
            if(!visited.get(i)){
                if(isCyclicDfs(i,s,visited,adj)){
                    return true;
                }
            }
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }

    public static boolean isCyclicBFS(int s, int[][] adj){
        boolean[] visited= new boolean[adj.length];
        int[] parent= new int[adj.length];
        Queue<Integer> q= new LinkedList<>();
        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        q.add(s);
        visited[s]= true;
        while(!q.isEmpty()){
            int f= q.remove();
            for(int i: adj[f]){
                if(i!=parent[f] && visited[i]== true){
                    return true;
                }
                else if(!visited[i]){
                    q.add(i);
                    visited[i]= true;
                    parent[i]= f;
                }
            }
        }
        return false;
    }

    public static Vector<Vector<Integer>> prepareadjdirected(int[][] edges){
        Vector<Vector<Integer>> adj= new Vector<>();
        for(int i=0; i< edges.length; i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
        }
        return adj;
    }

    public static boolean isCyclicDirected(int s, Vector<Boolean> visited, Vector<Boolean> dfsvisited, Vector<Vector<Integer>> adj){
        visited.set(s, true);
        dfsvisited.set(s, true);
        for(int i: adj.get(s)){
            if(!visited.get(i)){
                if(isCyclicDirected(i, visited, dfsvisited, adj)){
                    return true;
                }
            }
            else if(dfsvisited.get(i)){
                return true;
            }
        }
        dfsvisited.set(s, false);
        return false;
    }

    public static Vector<Integer> topologicalSort(Vector<Vector<Integer>> adj, int s){
        boolean[] visited= new boolean[adj.size()];
        Stack<Integer> st= new Stack<>();
        Arrays.fill(visited, false);
        
        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                topoSort(i, visited, adj, st);
            }
        }
        Vector<Integer> ans= new Vector<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    
    public static void topoSort(int s, boolean[] visited, Vector<Vector<Integer>> adj, Stack<Integer> st){
        visited[s]= true;
        for(int i: adj.get(s)){
            if(!visited[i]){
                topoSort(i, visited, adj, st);
            }
        }
        st.add(s);
    }

    public static Vector<Integer> shortestPath(Vector<Vector<Integer>> adj, int s, int e){
        boolean[] visited= new boolean[adj.size()];
        int[] parent= new int[adj.size()];
        Queue<Integer> q= new LinkedList<>();
        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        visited[s]= true;
        parent[s]= -1;
        q.add(s);
        while(!q.isEmpty()){
            int f= q.remove();
            for(int i: adj.get(f)){
                if(!visited[i]){
                    visited[i]= true;
                    parent[i]= f;
                    q.add(i);
                }
            }
        }
        Vector<Integer> ans= new Vector<>();
        for (int v = e; v != -1; v = parent[v]) {
            ans.add(v);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        
    }

}