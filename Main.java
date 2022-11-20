import java.io.*;
import java.util.*;
public class Main{
    public static class LinkedList{
        Node head;
        LinkedList(){
            head = null;
        }
        static class Node{
        int val;
        Node next;
        Node(int n){
                val = n;
                next = null;
            }
        }
        public static LinkedList insert(LinkedList new_linkedlist,int n){
            Node newNode=new Node(n);
            Node currNode = new_linkedlist.head;
            
            if(currNode==null){
                new_linkedlist.head = newNode;
            }
            else{
                while(currNode.next!=null){
                    currNode = currNode.next;
                }
                currNode.next = newNode;
            }
            
            return new_linkedlist;
        }
        public static LinkedList delete(LinkedList new_linkedlist,int n){
            if(n==0){
                new_linkedlist.head=new_linkedlist.head.next;
            }
            else{
                Node pos=new_linkedlist.head;
                for(int i=0;i<n-1;i++){
                    pos=pos.next;
                }
                pos.next=pos.next.next;
            }
            return new_linkedlist;
        }
        
        public static void show(LinkedList new_linkedlist){
            Node temp=new_linkedlist.head;
            Node temp_next=new_linkedlist.head;
            while(temp_next!=null){
                if(temp_next.next==null){
                    temp=temp_next;
                }
                temp_next=temp_next.next;
                
            }
            //created a loop
            temp.next=new_linkedlist.head;
        }
        public static int computePointOfInterception(LinkedList new_linkedlist,int x, int y)
        {
        Node slow_p=new_linkedlist.head, fast_p=new_linkedlist.head;
        Node temp=new_linkedlist.head;
            while(temp!=null){
                 if(temp.val== y){
                    slow_p=temp;
                    break;
                }
                temp=temp.next;
            }
        temp=new_linkedlist.head;
            while(temp!=null){
                if(temp.val== x){
                    fast_p=temp;
                    break;
                }
                temp=temp.next;
            }
        
        Node interception=new_linkedlist.head;
        while (slow_p != null && fast_p != null
            && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                interception=slow_p;
                break;
            }
        }
        return interception.val;
        }
    }
    
   public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        LinkedList list=new LinkedList();
        int t=sc.nextInt();
        
        while(t>0){
            int n=sc.nextInt();
            LinkedList.insert(list,n);
            t--;
        }
         LinkedList.show(list);
         int Fast=sc.nextInt();
         int slow=sc.nextInt();
        System.out.println(LinkedList.computePointOfInterception(list,Fast,slow));
        
    }
}
