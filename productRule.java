import java.util.ArrayList;
public class productRule
{
  private int lastIndex;
  private String a;
  private String b;
  private ArrayList <String> noDiffs = new ArrayList <String>();
  private ArrayList <String> proDiffs = new ArrayList <String>();
  
  public productRule (String s)
  {

    lastIndex = 0;
    for (int i = 0; i < s.length(); i++)
    {
     if (s.charAt(i) == '(')
     {
      noDiffs.add(s.substring(lastIndex, i));
      lastIndex = i;
     }
     
    }
  }
  public String toString()
  {
    String a = "";
    for (String s: noDiffs)
    {
      a+=s;
    }
   return a;
  }
}