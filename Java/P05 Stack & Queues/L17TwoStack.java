public class L17TwoStack{
    int s;
    int top1;
    int top2;
    int[] arr;

    L17TwoStack(int s){
        this.s=s;
        this.arr=new int[s];
        top1=-1;
        top2=s;
    }

    void push1(int data){
        if ((top2-top1)>1){
            top1++;
            arr[top1]=data;
        }
        else{
            return;
        }
    }

    void push2(int data){
        if ((top2-top1)>1){
            top2--;
            arr[top2]=data;
        }
        else{
            return;
        }
    }

    void pop1(){
        if(top1==-1){
            return;
        }
        else{
            top1--;
            
        }
    }

    void pop2(){
        if(top2==s){
            return;
        }
        else{
            top2--;
            
        }
    }

    public static void main(String [] args){
        L17TwoStack x=new L17TwoStack(6);
        x.push1(4);
        x.push1(5);
        x.push2(3);
        x.pop1();
        x.pop2();
    }

}