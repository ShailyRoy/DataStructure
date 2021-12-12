/**
 * ArrayQueue.java
 */
package cse220.assign3;

/**
 * Resizable queue of objects, using a circular array as the underlying
 * container.
 *
 * NOTE: We use "front" to reference the element at the front of the queue
 * (not necessarily at index 0 as in the case of linear array). Note that
 * we can easily calculate the last element in the queue (and also the next
 * available position) by using front and size. The next available position
 * is then at: next = front + size. However, this index must then be wrapped 
 * using the modulus operator: next = (front + size) % data.length; the last
 * element is at: last = (front + size - 1) % data.length.
 */
public class ArrayQueue implements Queue {

    /** The default initial capacity of a newly created queue. */
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    /** The underlying array container. */
    private Object[]         data;

    /** The index of the first item in the queue. */
    private int              f;
int r;
    /** The number of items in the queue. */
    private int              size;

    /**
     * Creates an empty queue of specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the container.
     */
    public ArrayQueue(int initialCapacity) {
      data=new Object[initialCapacity];
      size=0;
      f=-1;
      r=-1;
 // TODO
 // 1. Allocate data.
 // 2. Set front and size to be 0.
    }

    /**
     * Creates an empty queue of default initial capacity.
     */
    public ArrayQueue() {
 // TODO
      data=new Object[DEFAULT_INITIAL_CAPACITY];
      size=0;
      f=-1;
        r=-1;
    }

    /**
     * Returns the current size of the queue.
     * 
     * @return the number of items in the queue.
     */
    public int size() {
    return size;
    }
       // TODO: REMOVE THIS LINE!
    

    /**
     * Tests if this queue is empty.
     * 
     * @return true if and only if this queue contains no items; false
     *         otherwise.
     */
    public boolean isEmpty() {
      if(size==0)
        return true;
        return false;
        } 

    /**
     * Puts an item at the end of this queue.
     * 
     * @param item the item to be put at the end of this queue.
     */
    public Object[] resize(Object []a,int n)
    {
    Object []p=new Object[n];
    int c=0,count=0;
   for(int i=f;count<size;i=(i+1)%a.length)
   {if(f==0)
     p[i]=a[i];
   else{
   if(i<f)
   {c++;
   p[i+c]=a[i];
   }
   }
   count++;
   }
   r=a.length-1+c;
     a=p;
     
    return a;
    }
    
    public void enqueue(Object item) {
      {
        if(size==data.length)
         data=resize(data,data.length*2);
       
          if(r==-1)
            f=0;
        
        r=(r+1)%data.length;
        data[r]=item;
        size++;
        
        } 
      
 // TODO
 // 1. Check capacity and double the capacity if full
 // 2. Find the index of the next available position, and put 
 //    the item in that slot. See NOTE at the beginning of this
 //    file for details on how to find the next available position.
 // 3. Increment size
    }

    /**
     * Removes the item from the front of this queue and returns that item
     * as the value of this function.
     * 
     * @return The item in the front this queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public Object dequeue() throws EmptyQueueException {
        if(size==0)
          throw new  EmptyQueueException();
        
        else {
        Object val=data[f];
        data[f]=null;
        f=(f+1)%data.length;
        
        size--;
        return val;
        }
        
        }
      
      
        // TODO
 // 1. Pre-condition: The queue must not be empty, or else throw
 //    appropriate exception.
 // 2. Save a reference to the front of the queue. 
 //    - NO SHIFT REQUIRED.
 // 3. Set the element at front index to null (optional, to help GC).
 // 4. Increment front, wrapping if necessary.
 // 5. Decrement size.
 // 6. Return saved reference.
 

    /**
     * Looks at the item in the front of this queue without removing it
     * from the queue.
     * 
     * @return the item in the front of this queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public Object peek() throws EmptyQueueException {
    if(size==0)
        throw new  EmptyQueueException();
        
    return data[f];
    }
 // 1. Check if empty, and throw exception if so
 // 2. Return the reference to the item in the front
   

    /**
     * Searches this stack to see if the specified item is in this queue,
     * and if so, how far it is from the front of queue (0 is the distance
     * if the item is at the front of this queue). Note that this is not
     * the same as indexOf() that we've used in other data structures -
     * indexOf returns the index of the array item that contains an item,
     * and search returns the distance (or offset) of an item from the
     * front of the queue.
     * 
     * @param item the desired item.
     * @return distance from front of queue (0-based) if the item is in
     *         this queue, <code>-1</code> otherwise.
     */
    public int search(Object item) {
    Object []j=toArray();
      for(int i=0;i<size;i++)
    {
    if(j[i].equals(item))
      return i;

    }
          return -1;
    
    }
 // TODO
 // 1. Use two different variables - one starts at front and 
 //    advances through the cyclic array, and the other starts 
 //    at 0 and goes to size-1 in increments of 1
 // 2. Iterate and see if you find the item
 // 3. If so, return the offset from the front (the second
 //    variable!)
 // 4. Return -1 if not found
   

    /**
     * Removes the given item from this queue.
     * 
     * @param item the item to remove from this queue.
     * @return the removed item if it exists, or null otherwise.
     */
    public Object remove(Object item) {
   
      Object val=null;
      int c=-1,k=0,pos=-1;
      for(int i=f;k<size;i=(i+1)%data.length)
      { c++;
      if(data[i].equals(item))
      {
       
        val=data[i];
       pos=c;
      break;
      }
      k++;
      }
     k=0;
     if(pos>-1){
      if(c==r)
      {
      data[c]=null;
      }
      else{
      for(int i=pos+f;k<size-1-pos;i=(i+1)%data.length)
      {
      data[i]=data[(i+1)%data.length];
     
      k++; }
     
      data[r]=null;
      }  
      r--;
        if(r==-1)
          r=data.length-1;
      size--;
        // TODO
 // 1. Find the offset of the given item in this queue if exists
 // 2. If not, return null
 // 3. If it exists, shift all subsequent items to the left by
 //    one position to fill the hole
 // 4. Put a null in the last (now unused) slot
 // 5. Decrement size and return the specified item
     }
     return val;   // TODO: REMOVE THIS LINE!
    }

    /**
     * Clears this queue of all items.
     */
    public void clear() {
     int k=0;
      for(int i=f;k<size;i=(i+1)%data.length){
      data[i]=null;
      k++;
      }
      size=0;
      f=-1;
      r=-1;
 // TODO
        // Set all the existing items to null and then set the size to
        // be 0.
    }

    /**
     * Returns the items in this queue as an array, with the front of the
     * queue as the first item.
     * 
     * @return an array containing the items in this queue.
     */
    public Object[] toArray() {
          int k=f;
          Object []x=new Object[size];
      for(int i=0;i<size;i++)
      {
      x[i]=data[k];
      k=(k+1)%data.length;
      
      }
      return x;
      
    }
 // TODO
 // 1. Create an array of "size" capacity.
 // 2. Iterate over the elements of this queue, copy each
 //    element to the array. Use two indices to make life easy:
 //    one to iterate over the elements (starting from front),
 //    and the other starting at 0.
 // 3. Return the array.
   
    /**
     * Returns a string representation of this queue, with the top of this
     * queue as the first item displayed.
     * 
     * @return a string containing the items in this queue.
     */
    public String toString() {
    
      String s="[ ";
      int k=f;
      for(int i=0;i<size;i++)
      {
      s=s+data[k]+" ";
      k=(k+1)%data.length;
      
      }
      return s+"]";
    }

    /**
     * Checks if all the items of this queue are equal to the specified
     * one.
     * 
     * @param o the specified queue object.
     * @return <code>true</code> if all the items match, or
     *         <code>false</code> otherwise.
     */
    public boolean equals(Object o) {
        // First check if both refer to the same object.
        if (this == o)
            return true;
        // Then check to see if the specified object is null or not an
        // Queue at all.
        if (o == null || !(o instanceof Queue))
            return false;

        // Now that we know "o" is indeed a Queue, but we don't know what
        // is the underlying implementation, and hence cannot look at
        // internal data. We can of course use the toArray method to
        // extract the data, and then compare with equality.
        Queue otherQueue = (Queue) o;
        if (otherQueue.size() != size)
            return false;
        else{
        Object []j=otherQueue.toArray();
         Object []k=this.toArray();
  for(int i=0;i<k.length;i++)
  {
    if(!j[i].equals(k[i]))
      return false;
  }
        }
 // TODO
 // Easiest is to simply get the elements of this queue in an
 // array (this.toArray()), and the elements of the "other"
 // queue in another array (otherQueue.toArray()), and then
 // compare element by element using the equals method.
        return true;   // TODO: REMOVE THIS LINE!
    }

    /**
     * Tests this ArrayQueue class.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(1);
        q.enqueue(5);
        System.out.println("Queue = " + q.toString());
        q.enqueue(6);
        System.out.println("Queue = " + q.toString());
        q.enqueue(6);
        System.out.println("Queue = " + q.toString());
        Object[] a = q.toArray();
        for (int i = 0; i < a.length; i++)
            System.out.println("Queue array[" + i + "]  = " + a[i]);

        Object item = q.dequeue();
        System.out.println("dequeue = " + item);
        item = q.dequeue();
        System.out.println("dequeue = " + item);
        try {
            // queue is empty, so dequeue will throw exception.
            q.dequeue();
        } catch (EmptyQueueException e) {
            System.out.println("Exception caught: " + e.toString());
        }

        // make more space, and fill it up again.
        // q.ensureCapacity(3);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        System.out.println("Queue = " + q.toString());

        System.out.println("Q's size (expected 3) = " + q.size());
        System.out.println("Q's front (expected 6) = " + q.peek());
        q.dequeue();
        System.out.println("Q's front (expected 7) = " + q.peek());
        q.dequeue();
        System.out.println("Q's front (expected 8) = " + q.peek());

        // This part checks if removing all the items in the queue and
        // then adding back the item works.
        q.enqueue(new Integer(15));
        q.enqueue(new Integer(21));
        System.out.println("Q is now: " + q);
        // Save the queue in an array, and dequeue all to empty it out.
        a = q.toArray();
        while (!q.isEmpty())
            q.dequeue();

        System.out.println("Q is now (after dequeuing all): " + q);

        // and add the items back. Should have the same items again.
        for (Object e : a)
            q.enqueue(e);
        System.out.println("Q is now: " + q);
        // This part checks if clearing all the items in the queue and
        // then adding back the item works.
        q.enqueue(new Integer(15));
        q.enqueue(new Integer(21));
        System.out.println("Q is now: " + q);
        // Save the queue in an array, and dequeue all to empty it out.
        a = q.toArray();
        q.clear();

        System.out.println("Q is now (after clearing): " + q);

        // and add the items back. Should have the same items again.
        for (Object e : a)
            q.enqueue(e);
        System.out.println("Q is now: " + q);
         System.out.println(q.remove(21));
        System.out.println("Q is now: " + q);
        q.clear();
          System.out.println("Q's size (expected 3) = " + q.size());
    }
}
