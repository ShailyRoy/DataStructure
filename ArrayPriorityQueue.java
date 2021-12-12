/**
 * ArrayPriorityQueue.java
 */
package cse220.assign3;

/**
 * An implementation of the {@link PriorityQueue} interface using a sorted
 * array as the underlying container.
 *
 * The elements are maintained in non-decreasing (or "ascending", if all
 * the elements are distinct) order so that it's zero-cost to extract and
 * remove the key with the largest value.
 *
 * The elements are assumed to implement the Comparable interface, which
 * means that we can use the compareTo() method to compare elements when
 * putting these in sorted order. When a new element is added to the queue,
 * we start from the end, and work our way backwards to see where it should
 * fit (and all the while creating a hole by shifting elements one position
 * to the right). Once we find the right position, we put the element in
 * its position, keeping the whole array sorted. The array itself is
 * resizable, so that must be kept in mind when adding a new element.
 */
import java.util.*;
@SuppressWarnings("unchecked")
public class ArrayPriorityQueue implements PriorityQueue {

    /** The array container for the elements. */
    private Object[]         data;
    /** The number of elements in this queue. */
    private int              size;
    /** The default initial capacity. */
    private static final int DEFAULT_INITIAL_CAPACITY = 100;

    /**
     * Creates an empty queue with specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of this queue.
     */
    ArrayPriorityQueue(int initialCapacity) {
         data=new Object[initialCapacity];
      size=0;
     
 // TODO
 // Create the data array of given capacity, and set size to 0.
    }

    /**
     * Creates an empty queue with default initial capacity.
     */
    ArrayPriorityQueue() {
       data=new Object[DEFAULT_INITIAL_CAPACITY];
      size=0;
      // TODO
 // Create the data array of default capacity, and set size to 0.
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the number of elements in this queue.
     */
    public int size() {

 // TODO
   // TODO: REMOVE THIS LINE!
   return size;
    }

    /**
     * Returns true if this queue is empty.
     * 
     * @return <tt>true</tt> if this queue is empty, or <tt>false</tt>
     *         otherwise.
     */
    public boolean isEmpty() {
      if(size==0)
 // TODO
 return true;   // TODO: REMOVE THIS LINE!
   return false; }

    /**
     * Adds the specified object to this priority queue.
     * 
     * @param o the object to add.
     */
 
     public Object [] resize(Object[] a,int c) {
    Object []b=new Object[c];
    for(int i=0;i<a.length;i++)
      b[i]=a[i];
    a=b;
    return a;
    }
    
    public void add(Object o) {
 if(size==data.length)
         data=resize(data,data.length*2);
int pos =0;
    if(size==0)
      data[0]=o;
    else {
    for(int i=size-1;i>=0;i--)
    {
      if(((Comparable)o).compareTo((data[i]))<0)
      {  data[i+1]=data[i];
      if(i==0)
        data[i]=o;
      }
      else
      {   data[i+1]=o;
        break;}
    }
   
    }
     size++;
    }   
 // TODO
 // 1. Check if it needs to resized, and if so, double the 
 //    capacity before continuing with addition.
 // 2. Start from the end, checking each element in the array
 //    to see if it's larger than the given new element 'o'.
 //    At each step, shift the elements in the right one position
 //    to the right to create a "hole" for the new element.
 // 3. Once the position is found - either because we're now in
 //    the 0'th position (all the existing elements are larger
 //    than 'o'), or we've found an element that is not larger,
 //    we add it to the hole.
 // 4. Adjust size and return.
    

    /**
     * Gets the object with the maximum priority, and removes it from this
     * queue.
     * 
     * @return the object with the maximum priority.
     * @exception EmptyQueueException if this queue is empty.
     */
    public Object removeMax() throws EmptyQueueException {
      if(isEmpty())
        throw new  EmptyQueueException();
      else{
      
      Object o=data[size()-1];
      data[size-1]=null;
     
      size--;
       return o;  }
        // TODO
 // 1. Check precondition and throw exception if necessary.
 // 2. Save a reference to the largest key which is in the last
 //    position in the array (index size-1).
 // 3. Put a null there to help GC.
 // 4. Adjust size and return the saved element reference.
 // TODO: REMOVE THIS LINE!
    }

    /**
     * Returns the object with the maximum priority, without removing it
     * from this queue.
     * 
     * @return the object with the maximum priority.
     * @exception EmptyQueueException if this queue is empty.
     */
    public Object getMax() throws EmptyQueueException {
      
      if(isEmpty())
        throw new  EmptyQueueException();
      else{
        // TODO
 // 1. Check precondition and throw exception if necessary.
 // 2. Return the reference to the largest key which is in the last
 //    position in the array (index size-1).
        return data[size()-1];}   // TODO: REMOVE THIS LINE!
    }

    /**
     * Returns the index of this object within this queue, or -1
     * otherwise.
     * 
     * @param o the object to search for.
     * @return the index in the array, or <tt>-1</tt> otherwise.
     */
    private int indexOf(Object o) {
  if(isEmpty())
    return -1;
      int l=0;
      int rg=size-1;
        int m=(l+rg)/2;
      while(l<=rg)
      {
      
      if(data[m].equals(o))
         return m;
    else if(((Comparable)o).compareTo(data[m])<0)
    {
    rg=m-1;
   
    }
    else {
    l=m+1;
    }
     m=(rg+l)/2;
      }
      
     return -1;
 // TODO
 // Since it's sorted, you MUST use binary search to find the
 // key. If not found, return -1.
    // TODO: REMOVE THIS LINE!
    }

    /**
     * Returns true if the specific object exists in this queue.
     * 
     * @param o the object to search for.
     * @return <tt>true</tt> if the specified object exists in this queue,
     *         or <tt>false</tt> otherwise.
     */
    public boolean contains(Object o) 
    {
     int pos=indexOf(o);
      if(pos==-1)
     return false;
      else
        return true;
 // TODO
 // Hint: re-use indexOf()
     // TODO: REMOVE THIS LINE!
    }

    /**
     * Removes the specified object, if it exists, from this queue.
     * 
     * @param o the object to remove.
     * @return <tt>true</tt> if the object was removed, or <tt>false</tt>
     *         otherwise.
     */
    public boolean remove(Object o) {
  
      int pos=indexOf(o);
      if(pos==-1)
        return false;
      else {
        for(int i=pos;i<size-1;i++)
     
        {
        data[i]=data[i+1];
        }
        
        data[size-1]=null;
        size--;
      return true;
      }  }   // TODO
 // 1. First find it using indexOf(). If not found, return false.
 // 2. Shift all elements in the range [index+1,size-1] left by one
 //    position to fill the hole.
 // 3. Put null in the last position to help GC.
 // 3. Adjust size and return true.
 // TODO: REMOVE THIS LINE!
    

    /**
     * Clears this queue of all elements.
     */
    public void clear() {
   data=new Object [10];
     size=0;
      
     
 // TODO
        // Null out all the elements to help GC, and then set the size to
        // 0. Leave the allocated array so that it can be used later
        // without having to create a new array.
    }

    /**
     * Returns an array representation of this queue, with the maximum
     * priority element as the first element and so on.
     * 
     * @return an array representation of this queue.
     */
    public Object[] toArray() {
    Object []g=new Object [size];
    Object []k=data;int p=size-1;
      for(int i=0;i<size;i=(i+1))
      { 
        g[i]=k[p];
       p--;
        }
        
  
 // TODO
 // Note that we want the highest priority element in the 0'th
 // position, so start from the end and iterate backwards.
 return g;   // TODO: REMOVE THIS LINE!
    }

    /**
     * A string representation of this queue, with the elements separated
     * by space and the list enclosed in "[ ]". The first element is the
     * maximum priority element.
     * 
     * @return a string representation of this queue.
     */
    public String toString() {
      
      Object []o=toArray();
      String s="[ ";
    
      
     for(int i=0;i<size;i=(i+1))
     { 
     s=s+o[i]+" ";
    
     }
 // TODO
 // Note that we want the highest priority element in the 0'th
 // position, so start from the end and iterate backwards.
 return s+"]";   // TODO: REMOVE THIS LINE!
    }

    /**
     * Tests this ArrayPriorityQueue class.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int[] data = { 13, 1, 19, 2, 5, 3, 17, -4, 7, 5 };

        ArrayPriorityQueue pq = new ArrayPriorityQueue();
        System.out.print("Adding to pq       :");
        for (int i=0;i<data.length;i++) {
            System.out.print(" " + data[i]);
            pq.add(data[i]);
        }
        System.out.println("");

        System.out.println("pq as string: " + pq);
        System.out.println("pa as array: "
                + java.util.Arrays.toString(pq.toArray()));

        System.out.print("Retrieving from pq:");
        for (int i = 0; i < data.length; i++) {
            int maxValue = (Integer) pq.getMax();
            int removedMaxValue = (Integer) pq.removeMax();
            assert maxValue == removedMaxValue;
            System.out.print(" " + maxValue);
        }
        System.out.println("");

        System.out.println("clearing out the pq");
        pq.clear();
        System.out.println("pq = " + pq);
        pq.add(13);
        pq.add(1);
        pq.add(19);
        for(int i=0;i<3;i++)
        {   System.out.println(pq);
        
        System.out.println(pq.remove(19));
        
    }
    }
}
