import java.util.*;

public class L35KMP{

    public static int kmps(String a, String b){
        int index = -1;

        int n = a.length();
        int m = b.length();
        Vector<Integer> table = new Vector<>(m); // Initialize vector with size m
        int j = 0;
        ptable(b, m, table); // Corrected: Pass pattern b to ptable
        int i = 0;
        while(i < n){ // Corrected: Loop through the text a
            if(a.charAt(i) == b.charAt(j)){
                j++;
                i++;
            }
            if(j == m){
                index = i - j;
                j = table.get(j - 1);
            }
            else if(i < n && a.charAt(i) != b.charAt(j)){
                if(j != 0){
                    j = table.get(j - 1);
                }
                else{
                    i++;
                }
            }
        }
        return index;
    }

    public static void ptable(String b, int m, Vector<Integer> table){
        int j = 0;
        int i = 1;
        table.add(0);
        while(i < m){
            if(b.charAt(i) == b.charAt(j)){
                j++;
                table.add(j);
                i++;
            }
            else{
                if(j > 0){ // Corrected: Use j > 0
                    j = table.get(j - 1);
                }
                else{
                    table.add(0);
                    i++;
                }
            }
        }
    }

    public static void main(String args[]){
        String a = "abcaabcdacdaab";
        String b = "aab";
        System.out.println(kmps(a, b));
    }

}
