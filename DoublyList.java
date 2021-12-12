/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Imraan Parvez
 */
public class DoublyList {
        public Node head;
    
    
    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */ 
    public DoublyList(Object [] a){
        head = new Node(null, null, null);
        Node tail = head;
        
        for(int i = 0; i<a.length; i++){
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev=tail;
            tail=tail.next;
        }
        tail.next=head; // Making it circular
        head.prev=tail;
    }
    
    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h){
        head = h;
    }
    
    /* Counts the number of Nodes in the list */
    public int countNode(){
        int count =0;
        for(Node n=head.next;n!=head;n=n.next){
            ++count;
        }
        
        return count; // please remove this line!
    }
    
    /* prints the elements in the list */
    public void forwardprint(){
        
        for(Node n= head.next;n!=head;n=n.next){
            System.out.print(n.element+"  ");
        }
        
        System.out.println("");
    }
    
    public void backwardprint(){
        for(Node n=head.prev;n!=head;n=n.prev){
            System.out.print(n.element+"  ");
        }
        System.out.println("");
    }
    
    
    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        int size=countNode();
        
        if(idx<-1 ||idx>=size){
            return null;
        }
        if(idx == -1)
            return head;
        
        int i=0;
        
        for(Node n=head.next;n!=head;n=n.next){
            if(i==idx){
                return n;
            }
            ++i;
        }
        
        return null; // please remove this line!
    }
    
    
    
    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        
                
        int i=0;
        
        for(Node n=head.next;n!=head;n=n.next){
            if(elem.equals(n.element)){
                return i;
            }
            ++i;
        }
        
        
       // return -1; // please remove this line!
            return 0;
    }
    
    
    
    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
        int size=countNode();
        
        if(idx<0 || idx>size){
            return ;
        }
        
        Node newNode= new Node(elem,null,null);
        
        
        
        Node pred = nodeAt(idx-1);
        newNode.prev=pred;
        newNode.next=pred.next;
        Node suc = pred.next;
        pred.next=newNode;
        
        suc.prev=newNode;
               
                
    }
    
    
    
    
    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
         int size=countNode();
        
        if(index>=size){
            return null;
        }
        
        Node temp= nodeAt(index);
        
        Node pred = nodeAt(index-1);
        
        pred.next=temp.next;
        temp.next.prev=pred;
        
        Object tempel=temp.element;
        temp.prev=null;
        temp.next=null;
        temp.element=null;
        
        return tempel;       
        
        
        
        
    }
    
    
}
