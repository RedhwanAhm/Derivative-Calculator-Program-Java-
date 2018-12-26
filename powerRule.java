import java.util.ArrayList;
public class powerRule
{
  private boolean found;
  private boolean found2;
  private int n;
  private char x;
  private int ex;
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
    int lngth = a.length();
    int lngth2 = c.length;
  
    for (int i = 0; i < lngth; i++) //Looks for ex
    {
      if (a.charAt(i) == '^')
      {
        String s = a.substring(i);
        s = s.substring(1);
        ex = Integer.valueOf(s);
      }
    }
    
    for (int i = 0; i < lngth; i++) //Looks for x
      for (int j = 0; j < lngth2; j++)
      {
        if (a.charAt(i) == c[j])  
        {
          x = a.charAt(i);
          found = true;
        }
      }
    
     for (int i = 0; i < lngth; i++) //looks for n
     {
       if ((a.charAt(i) == x) && (a.indexOf(x) > 0))
       {
        String d = a.substring(0, i);
          n = Integer.valueOf(d);
          found2 = true;
       }
     }
     if (found != true)
     {
      n = 0; 
     }
   Calculate(n, ex);
   
  }
  

  public void Calculate (char c)
  {
    if (c == x)
    {
    rslt = "1";
    }
    else
    {
      rslt = "0";
    }
  }
  public void Calculate (int a, int b)
  {
     n = n*ex;
     ex = ex-1;
     if (ex > 1)
     {
       rslt = Integer.toString(n)+x+"^"+Integer.toString(ex);
     }
     if (ex == 1)
     {
       rslt = Integer.toString(n)+x;
     }
     if (ex == 0)
     {
       rslt = Integer.toString(n);
     }
  }
  public String toString ()
  {
   return rslt; 
  }
  
}