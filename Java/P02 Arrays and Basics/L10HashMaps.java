import java.util.*;
public class L10HashMaps{

    public static void hashmap(){
        HashMap<Integer, String> d=new HashMap<Integer, String>();
        d.put(1,"Shubham");
        d.put(2,"Aman");
        d.put(3,"Rahul");
        d.put(4,"Raiyan");
        d.put(5,"Sahil");

        for (int i : d.keySet()){
            System.out.println(d.get(i));
        }
        System.out.print(d.size());
    }


    public static void main(String [] a){
        

        // Make a collection
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
    
        // Get the iterator
        Iterator<String> it = cars.iterator();
    
        // Print the first item
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}