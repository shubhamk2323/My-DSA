import java.util.*;
public class L25Heaps{

    public static void insertheap(Vector<Integer> ans,int data){
        int index= ans.size();
        ans.add(data);
        while (index>1){
            int parent= index/2;
            if(ans.get(parent)<ans.get(index)){
                int t=ans.get(parent);
                ans.set(parent,ans.get(index));
                ans.set(index,t);
                index=parent;
            }
            else{
                return;
            }
        }
    }

    public static void insert_heap(Vector<Integer>ans, int data){
        int i= ans.size();
        ans.add(data);
        while(i>0){
            int p= (i-1)/2;
            if(ans.get(p)< ans.get(i)){
                Collections.swap(ans,p,i);
                i=p;
            }
            else{
                return;
            }
        }
    }

    public static void heapify(int [] arr, int n, int i){
        int largest=i;
        int left= 2*i+1;
        int right= 2*i+2;
        if(left<n && arr[largest]<arr[left]){
            largest=left;
        }
        if(right<n && arr[largest]<arr[right]){
            largest=right;
        }
        if(largest!=i){
            int t= arr[largest];
            arr[largest]= arr[i];
            arr[i]=t;
            heapify(arr, n, largest);
        }
        return;
    }

    public static int kthsmallestelement(int[] arr, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);
        // priority queue for max heap
        for (int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        int s=arr.length;
        for(int i=k; i<s; i++){
            if(arr[i]<pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static int mincost(int[] ropes){
        PriorityQueue<Integer> minheap= new PriorityQueue<>();
        for(int rope: ropes){
            minheap.add(rope);
        }
        int t=0;
        while(minheap.size()>1){
            int a= minheap.poll();
            int b= minheap.poll();
            int cost= a+b;
            t+=cost;
            minheap.add(cost);
        }
        return t;
    }

    public static void main(String[] args){
       
    }
    
}