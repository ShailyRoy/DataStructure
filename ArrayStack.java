/**
 * ArrayStack.java
 */
package cse220.assign3;

/**
 * Implements a stack of objects using a resizable array container. The
 * push operation puts the new element at the end of the array, and pop
 * removes the last element in the array.
 */
public class ArrayStack implements Stack {

    /** The default initial capacity of a newly created stack. */
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    /** The underlying array container. */
    private Object[] data;

    /** The number of items on the stack. */
    private int size;
    int top=-1;

    /**
     * Creates an empty stack of specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the container.
     */
    public ArrayStack(int initialCapacity) {
      data=new Object[initialCapacity];
      size=0;
 // TODO
 // Create an array of specified capacity, and set size to 0
    }

    /**
     * Creates an empty stack of default initial capacity.
     */
    public ArrayStack() {
      data=new Object[DEFAULT_INITIAL_CAPACITY ];
      size=0;
 // TODO
 // Create an array of default initial capacity, and set size to 0
    }

    /**
     * Returns the current size of the stack.
     * 
     * @return the number of items on the stack.
     */
    public int size() {
 // TODO
     size=top+1;
        return size;   // TODO: REMOVE THIS LINE!
    }

    /**
     * Tests if this stack is empty.
     * 
     * @return true if and only if this stack contains no items; false
     *         otherwise.
     */
    public boolean isEmpty() {
 // TODO
      if(top==-1)
        return true;
return false;      
// TODO: REMOVE THIS LINE!
    }

    /**
     * Pushes an item onto the top of this stack.
     * 
     * @param item the item to be pushed onto this stack.
     */
    public Object [] resize(Object[] a,int c) {
    Object []b=new Object[c];
    for(int i=0;i<a.length;i++)
      b[i]=a[i];
    a=b;
    return a;
    }
    
    public void push(Object item) {
if(top+1==data.length)
  data=resize(data,data.length*2);
top++;
data[top]=item;
size++;

// TODO
 // 1. Pre-condition check: Must have sufficient capacity, and if 
 //    not, resize (must have at least "size + 1" capacity, but
 //    I would suggest simply doubling the capacity if full).
 // 2. Add the item to the end of the array.
 // 3. Increment size.
    }

    /**
     * Removes the item at the top of this stack and returns that item as
     * the value of this function.
     * 
     * @return The item at the top of this stack.
     * @throws java.util.EmptyStackException if the stack is empty.
     */
    public Object pop() throws java.util.EmptyStackException {
      if(top==-1)
        throw new java.util.EmptyStackException();
      else
      {
      Object val=data[top];
      data[top]=null;
      top--;
      return val;
      }
        // TODO
 // 1. Pre-condition check: must not be empty. If it is, throw the
 //    appropriate exception.
 // 2. Save a reference to the object at the top of stack (the last 
 //    element in the array).
 // 3. [OPTIONAL] set the element to null to help the garbage 
 //    collector.
 // 4. Decrement size.
 // 5. Return the saved reference.
   // TODO: REMOVE THIS LINE!
    }

    /**
     * Looks at the item at the top of this stack without removing it from
     * the stack.
     * 
     * @return the item at the top of this stack.
     * @throws java.util.EmptyStackException if the stack is empty.
     */
    public Object peek() throws java.util.EmptyStackException {
      if(top==-1)
        throw new java.util.EmptyStackException();
      else
      {return data[top];}
        // TODO
 // 1. Pre-condition check: must not be empty. If it is, throw the
 //    appropriate exception.
 // 2. Return a reference to the object at the top of stack (the last 
 //    element in the array).
  // TODO: REMOVE THIS LINE!
    }

    /**
     * Clears this stack of all elements.
     */
    public void clear() {
      top=-1;
      size=0;
      for(int i=0;i<data.length;i++)
      {data[i]=null;}
      
 // TODO
 // 1. Iterate through all the elements in the array (stack elements)
 //    and set the references to be null (to help the GC).
 // 2. Set the size to be 0.
    }

    /**
     * Searches this stack to see if the specified item is on this stack,
     * and if so, how far it is from the top of stack (0 is the distance
     * if the item is on top of stack).
     * 
     * @param item the desired item.
     * @return distance from top of stack (0-based) if the item is on this
     *         stack, <code>-1</code> otherwise.
     */
    public int search(Object item) {
      
      int count=0;
      for(int i=top;i>=0;i--){
      if(data[i].equals(item))
        return count;
      count++;
      }        
 // TODO
 // 1. Iterate from top of stack to the bottom, keeping a counter
 //    to see how far from top you are (offset).
 // 2. If equal to the item, return the counter (offset).
 // 3. If the loop is done, must not be in the stack, so return the
 //    sentinel.
 return -1;   // TODO: REMOVE THIS LINE!
    }

    /**
     * Returns the items on this stack as an array, with the top of the
     * stack as the first element.
     * 
     * @return an array containing the items in this stack.
     */
    public Object[] toArray() {
      Object[]a=new Object[size];
      int j=0;
      for(int i=top;i>=0;i--){
      a[j]=data[i];
      j++;
      }
 // TODO
 // Remember that the top of stack will be the first element in
 // the returned array.
 return a;   // TODO: REMOVE THIS LINE!
    }

    /**
     * Returns a string representation of this stack, with the top of this
     * stack as the first element displayed. For example, if a stack
     * contains "A", "B", "C" and "D", with "A" being the top of the
     * stack, the returned String would contain "[ A B C D ]".
     * 
     * @return a string containing the items in this stack.
     */
    public String toString() {
      String str="[ ";
      for(int i=top;i>=0;i--)
        str=str+data[i]+" ";
 // TODO
 // Don't forget the final space before the close bracket " ]".
 return str+"]";   // TODO: REMOVE THIS LINE!
    }

    /**
     * Checks if all the elements of this stack are equal to the specified
     * one.
     * 
     * @param o the specified stack object.
     * @return <code>true</code> if all the elements match, or
     *         <code>false</code> otherwise.
     */
    public boolean equals(Object o) {
        // First check if both refer to the same object.
        if (this == o)
            return true;
        // Then check to see if the specified object is null or not an
        // Stack at all.
        if (o == null || !(o instanceof Stack))
            return false;

        // Now that we know "o" is indeed a Stack, we can cast it to one
        // before we can call the methods of the Stack interface to look
        // at the stack data.
        Stack otherStack = (Stack) o;
        if (otherStack.size() != size)
            return false;
        else{
          Object []a=otherStack.toArray();
           Object []b=this.toArray();
        for(int i=top;i>=0;i--)
        {
        if(!a[i].equals(b[i]))
          return false;
        }
        
        
        }

 // TODO
 // Now that we know both stacks are of the same size (same number
 // of elements), we have to check element by element to see if
 // there is mismatch or not. Since we don't know how the other 
 // stack is implemented (note that we're using the Stack interface,
 // not an ArrayStack in the cast above), the easiest is to use
 // the toArray methods of both this and the other stack, and compare
 // the arrays element by element using the equals method.
 return true;   // TODO: REMOVE THIS LINE!
    }

    /**
     * Tests the ArrayStack class.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ArrayStack stack = new ArrayStack(data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.println("push " + (i + 1) + ": " + data[i]);
            stack.push(data[i]);
        }
        System.out.println("Stack = " + stack.toString());
        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }
        // this causes an exception.
        try {
            stack.pop();
        } catch (java.util.EmptyStackException e) {
            System.out
                    .println("java.util.EmptyStackException caught and ignored: "
                            + e);
        }

        // test resize
        for (int i = 0; i < data.length; i++) {
            System.out.println("push " + (i + 1) + ": " + data[i]);
            stack.push(data[i]);
        }
        for (int i = 0; i < data.length; i++) {
            System.out.println("push " + (i + 1) + ": " + data[i]);
            stack.push(data[i]);
        }
        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }

        // this causes an exception.
        try {
            stack.pop();
        } catch (java.util.EmptyStackException e) {
            System.out
                    .println("java.util.EmptyStackException caught and ignored: "
                            + e);
        }

        // this causes an exception.
        try {
            stack.peek();
        } catch (java.util.EmptyStackException e) {
            System.out
                    .println("java.util.EmptyStackException caught and ignored: "
                            + e);
        }
    }
}
