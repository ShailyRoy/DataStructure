public class LinkedList
{
  
  public Node head;
  //Object a1[];
  
  
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(Object [] a)
  {
    head = new Node(a[0], null);
    Node tail = head;
    for (int i = 1; i < a.length; i++)
    {
      Node temp = new Node(a[i], null);
      tail.next = temp;
      tail = tail.next;
    }
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h)
  {
    head = h;//System.out.println(head.element+" "+head.next.element);
//    for(Node n = head; n != null; n = n.next)
//    {
//      if (n.next != null)
//        System.out.print(n.element+",");
//      else
//        System.out.println(n.element+".");
//    }
  }
  
  /* Counts the number of Nodes in the list */
  public int countNode()
  {
    int c = 0;
    for(Node n = head; n != null; n = n.next)
      c++;
    return c; // please remove this line!
  }
  
  /* prints the elements in the list */
  public void printList()
  {
    for(Node n = head; n != null; n = n.next)
    {
      if (n.next != null)
        System.out.print(n.element+",");
      else
        System.out.println(n.element+".");
    }
  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx)
  {
    int x = countNode();
    if (idx < 0 || idx > x)
      return null;
    else
    {
      Node n = head;
      for (int i = 0; i < idx; i++)
        n = n.next; 
      return n; // please remove this line!
    }
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx)
  {
    int x = countNode();
    if (idx < 0 || idx > x)
      return null;
    else
    {
      Node n = head;
      for (int i = 0; i < idx; i++)
        n = n.next;
      return n.element; // please remove this line!
    }
  }
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem)
  {
    int x = countNode();
    if (idx < 0 || idx > x)
      return null;
    else
    {
      Node n = head;
      Object tail = 0;
      for (int i = 0; i < idx; i++)
      {
        n = n.next;
        tail = n.element;
        n.element = elem;
      }
      return tail;
    }
    
    // please remove this line!
  }
  
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem)
  {
    int c = 0, d = 0;
    for (Node n = head; n != null; n = n.next)
    {
      if (n.element == elem)
        c = d;
      d++;
    }
    if (c != 0)
      return c;
    else
      return -1;
    // please remove this line!
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem)
  {
    int c = 0, d = 0;
    for (Node n = head; n != null; n = n.next)
    {
      if (n.element == elem)
        c = d;
      d++;
    }
    if (c != 0)
      return true;
    else
      return false; // please remove this line!
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList()
  {
    Node copyH = new Node(head.element, null);
    Node copyT = copyH;
    for (Node n = head.next; n != null; n = n.next)
    {
      Node mn = new Node(n.element, null);
      copyT.next = mn;
      copyT = mn;
    }
    return copyH; // please remove this line!
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList()
  {
    Node copyH = new Node(head.element, null);
    Node copyT = copyH;
    for (Node n = head.next; n != null; n = n.next)
    {
      Node mn = new Node(n.element, null);
      Node mm = copyT;
      copyT = mn;
      copyT.next = mm;
    }
    return copyT; // please remove this line!
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx)
  {
    int x = countNode();
    if (idx < 0 || idx > x)
      System.out.println("Ivalid index");
    else
    {
      if (idx == 0)
      {
        Node mm = head;
        Node mn = new Node(elem, null);
        head = mn;
        mn.next = mm;
      }
      else
      {
        Node mn = new Node(elem, null);
        Node pred = nodeAt(idx - 1);
        mn.next = pred.next;
        pred.next = mn;
      }
    }
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int index)
  {
    int x = countNode();
    if (index < 0 || index > x)
      return null;
    else
    {
      Node r;
      Object xx;
      if (index == 0)
      {
        r = head;
        xx = r.element;
        head = head.next;
        r.element = null;
        r.next = null;
        r = null;
      }
      else
      {
        Node pred = nodeAt(index - 1);
        r = pred.next;
        xx = r.element;
        pred.next = r.next;
        r.element = null;
        r.next = null;
        r = null;
      }
      return xx;
    } // please remove this line!
  }
  
  // Rotates the list to the left by 1 position.
  public void rotateLeft()
  {
    int x = countNode();
    Node n = head, tail = null;
    for (int i = 0; i < x; i++)
    {
      tail = n;
      n = n.next;
    }
    //tail.next = head;System.out.println(tail.next.element);
    Node nn = new Node(42, null);
    tail.next = head;
    Node r = head;//System.out.println(r.element);
    head = head.next;
    r.element = null;
    r.next = null;
    r = null;
  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight()
  {
    int x = countNode();
    Node n = head, tail = null;
    for (int i = 0; i < x; i++)
    {
      tail = n;
      n = n.next;
    }//System.out.println(tail.element+" "+tail.next);
    Node mn = tail;
    mn.next = head;
    head = mn;
    tail.element = null;
    tail.next = null;
    tail = null;
  }
  
}