import java.util.ArrayList;
public class sumAndDifference //Sets up values.
{
  private String a = "";
  private int gate;
  private int lastIndex;
  private ArrayList <String> conc = new ArrayList <String>();
  private ArrayList <String> concFinal = new ArrayList <String>();
    
  public sumAndDifference (String x) //Breaks up the values in the String and places them into the ArrayList conc.
  {
    ArrayList <String> temp = new ArrayList <String>();
    lastIndex = 0;
    gate = 0;
    for (int i = 0; i < x.length(); i++) //Breaking up the String and placing it within an ArrayList.
    {
      if ((x.charAt(i) == ('+') || x.charAt(i) == ('-')) || i == x.length()-1) 
      {
        conc.add(x.substring(lastIndex, i));
        lastIndex = i;
        if(i == x.length()-1)
        {
          char c = x.charAt(x.length()-1);
          String d = Character.toString(c);
          String s = conc.get(conc.size()-1)+d;
          conc.remove(conc.size()-1);
          conc.add(s);
        }
      }
    }
    
    for (int i = 0; i < conc.size(); i++) //Further breaking up the elements in conc to make plusses and minusses individual elements. Stores new broken up values into temp.
    {
      String s = conc.get(i);
      String tS = "";
      String tV = "";
      if (i == 0)
      {
        temp.add(conc.get(0));
      }
      for (int j = 0; j < s.length(); j++)
      {
       if ((s.charAt(j) == ('+')) || (s.charAt(j) == ('-')) )
       {
         tS = String.valueOf(s.charAt(j));
         tV = s.substring(j+1);
         temp.add(tS);
         temp.add(tV);
       }  
      }
    }
    
    conc.clear(); //Clears the original ArrayList conc with imperfect values.
    
    for (int i = 0; i < temp.size(); i++) //Adds new values of temp back into conc.
    {
      conc.add(temp.get(i));
    }
   Calculate(conc); 
  }
  
  public void Calculate (ArrayList <String> arr) //Gets the derivative of parts which are not signs.
  {
    ArrayList <String> temp = new ArrayList <String>();
    for (int i = 0; i < arr.size(); i++) //Categorically sorts out which part of the ArrayList can be differentiated.
    {
     if (!(arr.get(i).equals("+")|| arr.get(i).equals("-"))) //If the ArrayLists value at index i is not a '+' or '-', then create a new powerRule variable, put it in a String, and add temp.
     {
       powerRule p = new powerRule (arr.get(i));
       String x = p.toString();
       temp.add(x);
     }
     else
     {
      temp.add(arr.get(i)); //else add in the signs
     }
    }
    
    for (int i = 0; i < temp.size(); i++)
    {
      concFinal.add(temp.get(i)); //
    }
    
  }
  public String toString ()
  {
    for (int i = 0; i < concFinal.size(); i++)
    {
      a += concFinal.get(i);
    }
    return a;
  }
}