import java.util.*;

public class L29Graphs{

    public static void addVertex(Integer s, Map<Integer, ArrayList<Integer>> maps) {
        maps.put(s, new ArrayList<Integer>());
    }

    public static void addEdge(Integer s, Integer d, boolean isdirectional, Map<Integer, ArrayList<Integer>> maps) {
        if (!maps.containsKey(s)) {
            addVertex(s, maps);
        }
        if (!maps.containsKey(d)) {
            addVertex(d, maps);
        }
        maps.get(s).add(d);
        if (isdirectional == true) {
            maps.get(d).add(s);
        }
    }

    public static ArrayList<Integer> bfs(Map<Integer, ArrayList<Integer>> adj, int s, int d, int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v];
        ArrayList<Integer> ans= new ArrayList<>();
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int cur = q.remove();
            ans.add(cur);
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int ne = adj.get(cur).get(i);
                if (!visited[ne]) {
                    visited[ne] = true;
                    q.add(ne);
                }
            }
        }
        return ans;
    }

    public static Vector<Integer> BFS(int[][] adj, int s){
        Queue<Integer> q= new LinkedList<>();
        boolean visited[]= new boolean[adj.length];
        Vector<Integer> ans= new Vector<>();
        visited[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int c= q.remove();
            ans.add(c);
            for(int i=0; i<adj[c].length; i++){
                int n= adj[c][i];
                if(!visited[n]){
                    visited[n]=true;
                    q.add(n);
                }
            }
        }
        return ans;
    }
   
    

    public static void AddVertex(Integer s, Vector<Vector<Integer>> adj) {
        adj.add(new Vector<Integer>());
    }

    public static void AddEdge(Integer s, Integer d, Vector<Vector<Integer>> adj) {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }

    public static void dfs(int vertex, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    public static void Dfs(int s, int[][]adj, boolean[] visited, Vector<Integer> ans){
        visited[s]=true;
        ans.add(s);
        for(int n: adj[s]){
            if(!visited[n]){
                Dfs(n, adj, visited, ans);
            }
        }
    }

    public int NumCktdComp(int n, Vector<Vector<Integer>> adj) {
        int ans =0;
        int[] vis = new int[n];
        for(int elem=0;elem<n;elem++){
            if(vis[elem]!=1){
                ans+=1;
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(elem);
                vis[elem]=1;
                while(!q.isEmpty()){
                    int temp =q.remove();     
                    for(int child :adj.get(temp)){
                        if(vis[child]!=1){
                            q.add(child);
                            vis[child]=1;
                        }
                    }
                } 
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {

    }

}