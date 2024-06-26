import java.util.*;
public class L7Array{
    public static void main(String[] a){
        int[] marks= new int[4];
        marks[0]=90;
        marks[1]=97;
        marks[2]=92;
        //System.out.print(marks[2]);
        for (int i=0;i<marks.length;i++){
            System.out.print(marks[i]);
            System.out.print("\n");
        }
        Arrays.sort(marks);
        for (int i=0;i<marks.length;i++){
            System.out.print(marks[i]);
            System.out.print("\n");
        }

        int [][] final_marks={{90,98,87},{95,94,90}};
        System.out.print(final_marks[0][2]);

    }
}