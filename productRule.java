import java.util.ArrayList;
public class productRule
{
  private int lastIndex;
  private ArrayList <String> temp = new ArrayList <String>(); //used to store temp variables
  private ArrayList <String> p1 = new ArrayList <String>(); //used to store split up String
  private ArrayList <String> p2 = new ArrayList <String>(); //used to store the derivatives of the split up string
  private ArrayList <String> reslt = new ArrayList <String>(); //used to store the result
  
  public productRule (String s)
  {
    int c = 0;
    lastIndex = 0;
    for (int i = 0; i < s.length(); i++) //Splits the input into two, (....) and (....) into p1.
    {
      if (s.charAt(i) == '(')
      {
        p1.add(s.substring(lastIndex, i));
        lastIndex = i;
      }
      else if (i == s.length()-1)
      {
        p1.add(s.substring(lastIndex));
      }   
    }
    
    for (int i = 0; i < p1.size(); i++) //removes '(' and ')' (Parentheses) <- lol
    {
      String a = p1.get(i);
      StringBuilder x = new StringBuilder(a);
      for (int j = x.length()-1; j >= 0; j--)
      { 
          if ((a.charAt(j) == '(')|| (a.charAt(j) == ')'))
          {
            x = x.deleteCharAt(j);
          }
         
      }
       temp.add(x.toString());
    }
    p1.clear();
    for (int i = 0; i < temp.size(); i++)//adds temp into p1
    {
     p1.add(temp.get(i)); 
    }
    
    for (int i = temp.size()-1; i >= 0; i--)//adds temp into p2 backwards.
    {
     p2.add(temp.get(i)); 
    }
    
    temp.clear(); //temp is cleared
    for (int i = 0; i < p2.size(); i++) //temp holds the derivatives
    {
      String get = p2.get(i);
      sumAndDifference m = new sumAndDifference(get);
      get = m.toString();
      temp.add(get);
    }
    
    p2.clear();
    for (int i = 0; i < temp.size(); i++)
    {
     p2.add(temp.get(i)); 
    }
    
    
   Combine(p1, p2); 
  }
  
  public void Combine (ArrayList <String> arr, ArrayList <String> arr2)
  {
    arr.remove(0);
    arr2.remove(arr2.size()-1);
    temp.clear();
    for (int i = 0; i < arr.size(); i++)
    {
     String a = "("+ arr.get(i) +")";
     String b = "("+ arr2.get(i) +")";
     String c = a + b;
     temp.add(c);
    }
    
    int i = 0;
    while (i <= 2)
    {
     if (i == 0)
     {
       reslt.add(temp.get(0));
     }
     if (i == 1)
     {
      reslt.add("+"); 
     }
     if (i == 2)
     {
       reslt.add(temp.get(1));
     }
     i++;
    }
  }
    
  public String toString()
  {
    String a = "";
    for (int i = 0; i < reslt.size(); i++)
    {
      a += reslt.get(i)+" ";
    }
   return a;
  }
}