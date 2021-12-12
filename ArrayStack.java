public class ArrayStack implements Stack{
    int size;
    int top;
    Object [] data;
    
    public ArrayStack(){
        size=0;
        top =-1;
        data = new Object[5];
    }
    
    public int size(){
      return top+1;
      
    }
// Returns true if the stack is empty
    public boolean isEmpty(){
    if(size()==0)
      return true;
    return false;
    }
// Pushes the new item on the stack, throwing the
// StackOverflowException if the stack is at maximum capacity. It
// does not throw an exception for an "unbounded" stack, which
// dynamically adjusts capacity as needed.
    public void push(Object e) throws StackOverflowException{
      if(top+1==data.length){
        throw new  StackOverflowException();
      }
      else{
    top++;
    data[top]=e;
      }
    }
// Pops the item on the top of the stack, throwing the
// StackUnderflowException if the stack is empty.
    public Object pop() throws StackUnderflowException{
    if(size()==0)
      throw new StackUnderflowException();
    else
    {
      Object temp=data[top];
    top--;
    return temp;
    }
    }
// Peeks at the item on the top of the stack, throwing
// StackUnderflowException if the stack is empty.
    public Object peek() throws StackUnderflowException{
  if(data[top]==null)
      throw new StackUnderflowException();
  else
    return data[top];
    
    }
// Returns a textual representation of items on the stack, in the
// format "[ x y z ]", where x and z are items on top and bottom
// of the stack respectively.
    public String toString()
    {
    String st="[ ";
    for(int i=top;i>=0;i--)
      st=st+data[i]+" ";
    return st+"]";
    
    }
// Returns an array with items on the stack, with the item on top
// of the stack in the first slot, and bottom in the last slot.
    public Object[] toArray()
    {
      int p=0;
    Object [] o=new Object[size()];
     for(int i=top;i>=0;i--)
     {o[p]=data[i];
    p++;
     }
     return o;
    }
// Searches for the given item on the stack, returning the
// offset from top of the stack if item is found, or -1 otherwise.
    public int search(Object e){
   Object []o=toArray();
   for(int i=0;i<size();i++)
   {
   if(o[i].equals(e))
     return i;
   }
   return -1;
    }
    

    
}