public class CircularArray{
  
  private int start;
  private int size;
  private Object [] cir;
  
  /*
   * if Object [] lin = {10, 20, 30, 40, null}
   * then, CircularArray(lin, 2, 4) will generate
   * Object [] cir = {40, null, 10, 20, 30}
   */
  public CircularArray(Object [] lin, int st, int sz){
    //TO DO
    start=st;
    size=sz;
Object []temp=new Object[lin.length];
int k=start;
  for(int i=0;i<lin.length;i++)
  {
   temp[k]=lin[i];
k++;
if(k==lin.length)
  k=0;
  }
  
  cir=temp;
  }
  
  //Prints from index --> 0 to cir.length-1
  public void printFullLinear(){
        //TO DO
 for(int i=0;i<cir.length;i++)
   System.out.print(cir[i]+" ");
  
    System.out.println();
  }
  
  
  // Starts Printing from index start. Prints a total of size elements
  public void printForward(){
    //To DO
    int k=start;
  for(int i=0;i<size;i++)
  {
    System.out.print(cir[k]+" ");
    k=(k+1)%cir.length;
  }
  System.out.println();
  }
  
  
  public void printBackward(){
   //TO DO
    int k=(start+size-1)%cir.length;
    for(int i=0;i<size;i++)
  {
  System.out.print(cir[k]+" ");
  k--;
  if(k==-1)
    k=cir.length-1;
  } 
     System.out.println(); 
  }
  
  // With no null cells
  public void linearize(){
    //TO DO
    Object []s=new Object[size];
    int k=start,i=0; 
   while(i<size)
  {
      if(cir[k]!=null)
      { s[i]=cir[k];
    i++;
      }
  k++;
  if(k==cir.length)
    
    k=0;
    }
   cir=s;
    
  }
  
  // Do not change the Start index
  public void resizeStartUnchanged(int newcapacity){
    //TO DO
    Object []s=new Object[newcapacity];
    int k=start,j=start;
    for(int i=0;i<size;i++)
    {
    s[j]=cir[k];
    k=(k+1)%cir.length;
  j++;
    if(j==s.length)
    j=0;
    }
      cir=s;
  }
  
  // Start index becomes zero
  public void resizeByLinearize(int newcapacity){
    //TO DO
     Object []s=new Object[newcapacity];
    int k=start;
    for(int i=0;i<size;i++)
    {
    s[i]=cir[k];
    k=(k+1)%cir.length;   
    }
      cir=s;
   
  }
  
  /* pos --> position relative to start. Valid range of pos--> 0 to size.
   * Increase array length by 3 if size==cir.length
   * use resizeStartUnchanged() for resizing.
   */
  public void insertByRightShift(Object elem, int pos){
    //TO DO
    if(pos<0||pos>size){
      System.out.println("invalid");
 
    }
    if(size==cir.length)
      resizeStartUnchanged(cir.length+3);
    
    int index=(start+pos)%cir.length;
   int nshift=size-pos;
   int from=(start+size-1)%cir.length;
   int to=from+1;
   for(int i=0;i<nshift;i++)
   {
   cir[to]=cir[from];
   to=from;
   from--;
   if(from==-1)
     from=cir.length-1;
   }
   cir[index]=elem;
  size++;
  
  }
  
  public void insertByLeftShift(Object elem, int pos){
    //TO DO
     if(pos<0||pos>size){
      System.out.println("invalid");
 
    }
    if(size==cir.length)
      resizeStartUnchanged(cir.length+3);
    
    int index=(start+pos)%cir.length;
   int nshift=size-pos;
   int from=start;
   int to=from-1;
   if(to<0)
     to=cir.length-1;
   for(int i=0;i<nshift;i++)
   {
   cir[to]=cir[from];
   to=from;
   from++;
   if(from==cir.length)
     from=0;
   }
   cir[index]=elem;
  size++;
  start--;
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByLeftShift(int pos){
    //TO DO
  int nshift=size-pos+1;
  int to=(start+pos)%cir.length;
  int from=(to+1)%cir.length;
   for(int i=0;i<nshift;i++)
   {
   cir[to]=cir[from];
   to=from;
   from++;
   if(from==cir.length)
     from=0;
   }
   int end=(start+size-1)%cir.length;
   cir[end]=null;
   size--;
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByRightShift(int pos){
    
    //TO DO
    int nshift=pos;
  int to=(start+pos)%cir.length;
  int from=(to-1);
  if(from<0)
    from=cir.length-1;
   for(int i=0;i<nshift;i++)
   {
   cir[to]=cir[from];
   to=from;
   from--;
   if(from==-1)
     from=cir.length-1;
   }
 
   size--;
   start=(start+1)%cir.length;
  }
  }
  
