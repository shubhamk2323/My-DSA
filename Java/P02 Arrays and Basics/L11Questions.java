import java.util.*;

public class L11Questions{

    public static Map sort_ht_wt(Vector<Integer> h, Vector<Integer> w){
        Map<Integer, Vector<Integer>> map= new LinkedHashMap<>();
        for(int i=0; i<h.size(); i++){
            int x= h.get(i);
            int y= w.get(i);
            if(!map.containsKey(h.get(i))){
                Vector<Integer> z= new Vector<>();
                z.add(y);
                map.put(x,z);
            }
            else{
                map.get(x).add(y);
            }
        }
        return map;
    }

    public static boolean summation(Vector<Integer> a, Vector<Integer> b){
        int sum1=0;
        int sum2=0;
        for(int i=0; i<a.size(); i++){
            sum1+=a.get(i);
            sum2+=b.get(i);
        }
        return (sum1==sum2);
    }

    public static boolean sameoddeven(Vector<Integer> a, Vector<Integer> b){
        int e1=0,e2=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i)%2==0){
                e1++;
            }
            if(b.get(i)%2==0){
                e2++;
            }
        }
        return (e1==e2);
    }

    public static int min_opr(Vector<Integer> a, Vector<Integer> b){
        if(!(summation(a,b) && sameoddeven(a,b))){
            return -1;
        }
        Collections.sort(a);
        Collections.sort(b);
        Vector<Integer> ea= new Vector<>();
        Vector<Integer> oa= new Vector<>();
        Vector<Integer> eb= new Vector<>();
        Vector<Integer> ob= new Vector<>();
        for(int i=0;i<a.size(); i++){
            int x= a.get(i);
            int y= b.get(i);
            if(x%2==0){
                ea.add(x);
            }
            if(x%2!=0){
                oa.add(x);
            }
            if(y%2==0){
                eb.add(y);
            }
            if(y%2!=0){
                ob.add(y);
            }
        }
        int p=0;
        int j=0;
        for(int i=0; i<ea.size(); i++){
            int u=ea.get(i);
            int v=eb.get(i);
            if(u<v){
                p+=((v-u)/2);
            }
        }
        for(int i=0; i<oa.size(); i++){
            int u=oa.get(i);
            int v=ob.get(i);
            if(u<v){
                p+=((v-u)/2);
            }
        }
        return p;      
    }

    public static void main(String args[]){
        Vector<Integer> a= new Vector<>(List.of(163, 171, 182, 296, 306, 478, 696, 716, 854, 1004, 1152, 1412, 1680, 1775, 1839, 1999, 2000));
        Vector<Integer> b= new Vector<>(List.of(4, 165, 448, 634, 736, 798, 839, 1059, 1068, 1102, 1146, 1198, 1293, 1314, 1555, 1566, 1798));
        System.out.println(min_opr(a,b));
    }

}