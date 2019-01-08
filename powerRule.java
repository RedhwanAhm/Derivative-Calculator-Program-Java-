import java.util.ArrayList;
public class powerRule
{
  private boolean found;
  private boolean found2;
  private double n;
  private char x;
  private double ex;
  private String rslt;
  private char [] c = {'a','b','c','d','e','f','g','h','i','j',
                       'k','l','m','n','o','p','q','r','s','t',
                       'u','v','w','x','y','z'};
  
  public powerRule(String a)
  {
    found = false;
    n = 1;
    x = 'x';
    ex = 1;
    int lngth = a.length(); //length of the string a
    int lngth2 = c.length; //Array of chars.
  
    for (int i = 0; i < lngth; i++) //Looks for ex
    {
      if (a.charAt(i) == '^')
      {
        String s = a.substring(i); //ex, you send in 3x^3, this will pick up  ' ^3 '
        s = s.substring(1); //then using ' ^3 ' it gets the substring at index 1 of string. (All strings start with an index of 0 to whatever the length is minus 1; s = "3"
        ex = Integer.valueOf(s); //Integer.valueOf(); is a wrapper method, this basically gets the String and converts it into an integer. ex is now 3 and not "3".
      }
    }
    
    for (int i = 0; i < lngth; i++) //Looks for x
      for (int j = 0; j < lngth2; j++)
      {
        if (a.charAt(i) == c[j]) //this can be used to change the variable x which is equal to x. 
        {
          x = a.charAt(i); //if one of the values of c are found, x changes to that value, so if you passed v^3, x would go from x -> v
          found = true;
        }
      }
    
     for (int i = 0; i < lngth; i++) //looks for n
     {
       if ((a.charAt(i) == x) && (a.indexOf(x) > 0))
       {
        String d = a.substring(0, i);
          n = Double.valueOf(d);
          found2 = true;
       }
     }
     if (found != true)
     {
      n = 0; 
     }
   Calculate(n, ex);
   
  }
  
  public void Calculate (double a, double b)
  {
     n = n*ex;
     ex = ex-1;
     if (ex > 1)
     {
       rslt = Double.toString(n)+x+"^"+Double.toString(ex);
     }
     if (ex == 1)
     {
       rslt = Double.toString(n)+x;
     }
     if (ex == 0)
     {
       rslt = Double.toString(n);
     }
  }
  public String toString ()
  {
   return rslt; 
  }
  
}