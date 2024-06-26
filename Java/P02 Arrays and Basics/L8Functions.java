import java.util.*;

class L8Functions{

    public static double avg(int[] a){
        double s=0;
        for(int i:a){
            s+=i;
        }
        return s/a.length;
    }

    public static ArrayList<Integer> rem_zero(ArrayList<Integer> a){
        ArrayList<Integer> b= new ArrayList<Integer>();
        for (int i=0; i<a.size();i++){
            if (a.get(i)==0){
                continue;
            }
            else{
                b.add(a.get(i));
            }
        }
        return b;
        
    }

    public static int decimal_to_binary(int d){
        int s=0;
        for (int i=0; d>0;i++){
            int r=d%2;
            d=d/2;
            s=s+(r*(int)(Math.pow(10,i)));
        }
        return s;
    }

    public static int octal_to_binary(int d){
        int s=0;
        for (int i=0;d>0;i++){
            int r=d%10;
            d=d/10;
            int p=decimal_to_binary(r);
            s=s+(p*(int)(Math.pow(1000,i)));
        }
        return s;
    }

    public static int [][]multiplyMatrices(int a[][], int b[][]){
        int ar=a.length;
        int ac=a[0].length;
        int br=b.length;
        int bc=b[0].length;
        int [][] c= new int[ar][bc];
        for (int i=0;i<ar;i++){
            for (int j=0;j<bc;j++){
                for (int k=0;k<ac;k++){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static String hex_binary(String a){
        String h="";
        for (int j=0;j<a.length();j++){
            char i=a.charAt(j);
            int d=0;
            String g;
            
            if (i=='A'){
                d=decimal_to_binary(10);
                g=d+"";
            }
            else if(i=='B'){
                d=decimal_to_binary(11);
                g=d+"";
            }
            else if(i=='C'){
                d=decimal_to_binary(12);
                g=d+"";
            }
            else if(i=='D'){
                d=decimal_to_binary(13);
                g=d+"";
            }
            else if(i=='E'){
                d=decimal_to_binary(14);
                g=d+"";
            }
            else if(i=='F'){
                d=decimal_to_binary(15);
                g=d+"";
                //System.out.println(d);
            }
            else{
                d=decimal_to_binary(i-'0');
                //System.out.println(d);
                if (d==0){
                    g="0000";
                }
                else if (d>=1&&d<10){
                    g="000"+(d+"");
                }
                else if (d>=10&&d<100){
                    g="00"+(d+"");
                }
                else if (d>=100&&d<1000){
                    g="0"+(d+"");
                }
                else{
                    g=d+"";
                }
            }
            h=h+g;
        }
        return h;
    }

    public static int frequent(int[] a){
        Arrays.sort(a);
        int c=1;
        int maxcount=1;
        int r=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]==a[i-1]){
                c++;
            }
            else{
                c=1;
            }
            if (c>maxcount){
                maxcount=c;
                r=a[i-1];
            }
        }
        return r;
    }

    public static ArrayList<String> files(ArrayList<String> a){
        ArrayList<String> b= new ArrayList<String>();
        for (int i=0;i<a.size();i++){
            String x=a.get(i);
            int y=x.length();
            //System.out.println(x.substring((y-5),y));
            if ((x.substring((y-5),y)).equals(".java")){
                b.add(x);
            }  
        }
        return b;
    }

    public static String str_concat(String a, String b,int m , int n){
        return (a.substring(m,(a.length()))+b.substring(0,n+1));
    }

    public static int score(char[] ans, char[] student){
        int s=0;
        for (int i=0; i<ans.length;i++){
            if(ans[i] == student[i]){
                s+=4;
            }
            else if(student[i]=='?'){
                s=s+0;
            }
            else{
                s=s-1;
            }
        }
        return s;
    }

    public static boolean prime(int x){
        if(x==2 || x==3){
            return true;
        }
        else if(x==4){
            return false;
        }
        for(int i=2;i<x/2;i++){
            if (x%i==0){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> factor(int a){
        ArrayList<Integer> f=new ArrayList<>();
        for (int i=1;i<=a;i++){
            if (a%i==0){
                f.add(i);
            }
        }
        return f;
    }

    public static int hcf(int a, int b){
        int l;
        if (a>=b){
            l=b;
        }
        else{
            l=b;
        }
        int h=1;
        for (int i=2; i<=l;i++){
            if(a%i==0 && b%i==0){
                h=i;
            }
        }
        return h;
    }

    public static void main(String [] a){
        System.out.print(hex_binary("A45E5C"));
    }

}