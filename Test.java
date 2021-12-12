public class Test {
  public static void main(String[]args) {
  Stack s1=new ArrayStack();
  Stack s2=new ListStack();
  try{
    s2.push(1);
  s1.push(2);
  s1.push(3);
  s1.push(4);
    System.out.println(s1.pop());
      System.out.println(s1.pop());
        System.out.println(s1.pop());
          System.out.println(s1.pop());
    
  }
  catch(Exception e){
    System.out.println(e);
  }

   System.out.println(s1.toString());
   
  
  }}