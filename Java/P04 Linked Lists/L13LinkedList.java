public class L13LinkedList{

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    public static class linklist{
        Node head=null;
        Node tail=null;

        void insertend(int data){
            Node t=new Node(data);
            if (head==null){
                head=t;
            }
            else{
                tail.next=t;
            }
            tail=t;
        }

        void insertstart(int data){
            Node t=new Node(data);
            if (head==null){
                insertend(data);
            }
            else{
                t.next=head;
                head=t;
            }
        }

        void insertat(int i, int data){
            Node a=head;
            Node b=new Node(data);
            if (i==0){
                insertstart(data);
            }
            else if(i<0 || i>size()){
                System.out.println("Wrong!");
            }
            else{
                for (int j=0; j<i-1;j++){
                    a=a.next;
                }
                b.next=a.next;
                a.next=b;
            }
        }

        void delat(int i){
            Node a=head;
            Node b;
            if (i==0){
                head=a.next;
            }
            else if(i>size()-1){
                System.out.println("Wrong");
            }
            else{
                for (int j=0; j<i-1; j++){
                    a=a.next;
                }
                b=a.next;
                a.next=b.next;
                b.next=null;
            }
            

        }

        int size(){
            Node t= head;
            int c=0;
            while (t!=null){
                t=t.next;
                c++;
            }
            return c;
        }

        void display(){
            Node t= head;
            while (t!=null){
                System.out.print(t.data+ " ");
                t=t.next;
            }
            System.out.println();
        }
    }
    public static void main (String[] args){
        linklist l1=new linklist();
        l1.insertstart(1);
        l1.display();
        l1.insertend(2);
        l1.insertend(3);
        l1.insertend(5);
        l1.display();
        l1.insertat(3,4);
        l1.display();
        l1.insertat(2,9);
        l1.display();
        l1.delat(2);
        l1.display();
        l1.delat(5);
        l1.display();
    }
}