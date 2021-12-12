public class ListStack implements Stack{
    int size;
    Node top;
  
    
    public ListStack(){
        size = 0;
        top = null;
    }
    
    public int size(){
      int size=0;
      for(Node n=top;n!=null;n=n.next)
        size++;
      return size;
        
    }
// Returns true if the stack is empty
    public boolean isEmpty(){
    if(top==null)
      return true;
    return false;
    }
// Pushes the new item on the 
    //stack, throwing the
// StackOverflowException if the stack is at maximum capacity. It
// does not throw an exception for an "unbounded" stack, which
// dynamically adjusts capacity as needed.
    public void push(Object e) throws StackOverflowException{
    if(top==null)
      top=new Node(e,null);
    else{
   Node n=top;
   top.element=e;
   top.next=n;
   
    }
    
    }
// Pops the item on the top of the stack, throwing the
// StackUnderflowException if the stack is empty.
    public Object pop() throws StackUnderflowException{
    if(top==null)
      return null;
    else {
  Object o=top.element;
 
  top=top.next;
    return o;
    }
    
    }
// Peeks at the item on the top of the stack, throwing
// StackUnderflowException if the stack is empty.
    public Object peek() throws StackUnderflowException{
    return top.element;
    }
// Returns a textual representation of items on the stack, in the
// format "[ x y z ]", where x and z are items on top and bottom
// of the stack respectively.
    public String toString()
    {
      String str="[ ";
      for(Node n=top;n!=null;n=n.next)
        str=str+n.element+" ";
return str+"]";
    }
// Returns an array with items on the stack, with the item on top
// of the stack in the first slot, and bottom in the last slot.
    public Object[] toArray(){
    Object []o=new Object[size()];
    Node n=top;
    for(int i=0;i<o.length;i++)
    { o[i]=n.element;
    n=n.next;
    }
    return o;
    }
// Searches for the given item on the stack, returning the
// offset from top of the stack if item is found, or -1 otherwise.
    public int search(Object e){
      int c=0;
      for(Node n=top;n!=null;n=n.next){
     
        if(n.element.equals(e))
      {
        
        return c;
      }
      c++;}
      return -1;
    }
}