import java.util.*;
import java.io.*;

public class L14Questions{
    
    public static class Node{
        int data;
        Node next;
        Node (int data){
            this.data=data;
        }
    }

    public static boolean iscircular(Node head){
        if (head==null){
            return true;
        }
        Node t=head.next;
        while (t!=null && t!=head){
            t=t.next;
        }
        if(t==head){
            return true;
        }
        return false;
    }

    public static Node detectloop(Node head){
        if (head==null){
            return null;
        }
        Node slow=head;
        Node fast=head;
        while(slow!=null && fast!=null){
            fast=fast.next;
            if (fast!=null){
                fast=fast.next;
            }
            slow=slow.next;
            if (fast==slow){
                return slow;
            }
        }
        return null;
    }

    public static Node getstartnode(Node head){
        if (head==null){
            return null;
        }
        Node i=detectloop(head);
        if(i==null){
            return null;
        }
        Node slow=head;
        while (slow!=i){
            slow=slow.next;
            i=i.next;
        }
        return slow;
    }

    public static Node removeloop(Node head){
        if (head==null){
            return  null;
        }
        Node start= getstartnode(head);
        if (start==null){
            return head;
        }
        Node t=start;
        while (t.next!=start){
            t=t.next;
        }
        t.next=null;
        return head;
    }

    public static Node remove_duplicate_sorted(Node head){
        Node t = head;
        while (t!=null){
            System.out.println(t.data);
            if (t.next!=null && t.data==t.next.data){
                t.next=t.next.next;
            }
            else{
                t=t.next;
            }
        }
        return head;
    }

    public static void printlinkedlist(Node head){
        Node t=head;
        while (t!=null){
            System.out.print(t.data+" ");
            t=t.next;
        }
    }

    public static void swap(Node a, Node b){
        int t= a.data;
        a.data=b.data;
        b.data=t;
    }

    public static void bubblesort(Node head){
        Node c=head;
        boolean swapped = true;
        if (head==null){
            return;
        }
        while (swapped){
            swapped =false;
            c=head;
            while (c.next!=null){
                if (c.data>c.next.data){
                    swap(c,c.next);
                    swapped = true;
                }
                c=c.next;
            }
        }
    }

    public static Node rem_duplicate_unsorted(Node head){
        HashSet<Integer> x= new HashSet<Integer>();
        Node t=head;
        Node p=t;
        while(t!=null){
            if(x.contains(t.data)){
                p.next=t.next;
            }
            else{
                x.add(t.data);
                p=t;
            }
            t=t.next;
        }
        return head;
    }

    public static Node sort012(Node head){
        Node t=head;
        int c0=0;
        int c1=0;
        int c2=0;
        while(t!=null){
            if (t.data==0){
                c0++;
            }
            else if (t.data==1){
                c1++;
            }
            else{
                c2++;
            }
            t=t.next;
        }
        t=head;
        for(int i=0; i<c0;i++){
            t.data=0;
            t=t.next;
        }
        for(int j=0; j<c1;j++){
            t.data=1;
            t=t.next;
        }
        for(int k=0; k<c2;k++){
            t.data=2;
            t=t.next;
        }
        return head;
    }

    public static Node sortedMerge(Node a, Node b){
        Node c;
        
        if (a.data<b.data){
            c=new Node(a.data);
            a=a.next;
        }
        else{
            c=new Node(b.data);
            b=b.next;
        }
        Node d=c;
        while (a!=null && b!=null){
            if (a.data < b.data){
                
                c.next=a;
                a=a.next;

            }
            else{
                
                c.next=b;
                b=b.next;

            }
            c=c.next;
            
        }
        while (a!=null){
            
            c.next=a;
            a=a.next;
            c=c.next;
            
        }
        while (b!=null){
            
            c.next=b;
            b=b.next;
            c=c.next;
            
        }
        return d;
    }

    public static Node rev(Node a){
        if (a==null || a.next==null){
            return a;
        }
        Node c=a;
        Node p=null;
        while(c!=null){
            Node t=c.next;
            c.next=p;
            p=c;
            c=t;
        }
        return p;
    }

    public static Node getmid(Node head){
        Node s=head;
        Node f=head.next;
        while (f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }

    public static int size(Node head){
        int c=0;
        Node t=head;
        while (t!=null){
            c++;
        }
        return c;
    }

    public static boolean palindrome(Node head){
        if (head==null || head.next==null){
            return true;
        }
        Node m=getmid(head);
        Node h1=head;
        Node x=rev(m.next);
        Node h2=x;
        while (h2!=null){
            if (h2.data!=h1.data){
                return false;
            }
            h1=h1.next;
            h2=h2.next;
        }
        return true;
    }

    public static Node addition(Node a, Node b){
        Node cc=new Node (0);
        Node head=cc;
        int p,c=0;
        a=rev(a);
        b=rev(b);
        int x;
        while(a!=null && b!=null){
            p=a.data+b.data+c;
            c=p/10;
            x=p%10;
            Node i=new Node(x);
            cc.next=i;
            a=a.next;
            b=b.next;
            cc=cc.next;
        }
        while(a!=null){
            p=a.data+c;
            c=p/10;
            x=p%10;
            Node i=new Node(x);
            cc.next=i;
            a=a.next;
            cc=cc.next;
        }
        while(b!=null){
            p=b.data+c;
            c=p/10;
            x=p%10;
            Node i=new Node(x);
            cc.next=i;
            b=b.next;
            cc=cc.next;
        }
        if(c>0){
            cc.next=new Node(c);
        }

        return rev(head.next);

    }

    public static void main(String arg[]){
        Node a=new Node(9);
        Node b=new Node(8);
        Node c=new Node(9);
        Node d=new Node(2);
        Node e=new Node(8);
        a.next=b;
        b.next=c;
        d.next=e;
        Node w=addition(a,d);
        printlinkedlist(w);
    }
}
