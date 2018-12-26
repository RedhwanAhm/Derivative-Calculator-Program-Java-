import java.io.*;
import static java.lang.System.*;

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.*;

class ap_Calculus{
  
  
  public static void main (String [] args) throws IOException
  {
    Scanner scan = new Scanner (System.in);
    boolean calculateAnother = true;
    boolean result = false;
    int f = 0;
    
    
    System.out.println("Welcome to the Java derivative calculator!");
    
    while (calculateAnother != false)
    {
    System.out.println("\nWhich rule do you want to calculate with? \nType:\n 'pr' for Power Rule\n 'sdr' for Sum and Difference Rule\n 'prdr' for Product Rule\n 'qr' for Quotient Rule");
    String rule = scan.nextLine();
    
    if (rule.equals("pr"))
    {
      System.out.println("\nTo differentiate, type in this format: nx^n");
      String diff = scan.nextLine();
      powerRule p = new powerRule(diff);
      System.out.println("Answer: "+p);
    }
   
    else if (rule.equals("sdr"))
    {
      System.out.println("\nTo differentiate, type in this format: 'nx^n+nx^n...' ");
      String diff2 = scan.nextLine();
      sumAndDifference q = new sumAndDifference(diff2);
      System.out.println("Answer: "+q);
    }
    
    else if (rule.equals("prdr"))
    {
      System.out.println("\nTo differentiate, type in this format: '(nx^n+nx^n...)(nx^n+nx^n...)' ");
      String diff3 = scan.nextLine();
      productRule r = new productRule (diff3);
      System.out.println("Answer: "+r);
    }
    
    else if (rule.equals("qr"))
    {
      System.out.println("\nTo differentiate, type in this format: '(nx^n+nx^n...)/(nx^n+nx^n...)' ");
      String diff4 = scan.nextLine();
      quotientRule s = new quotientRule(diff4);
      System.out.println("Answer: "+s);
    }
    
    else
    {
      System.out.println("\nWould you like to enter another value?\n\t'0' for no, '1' for yes");
      f = scan.nextInt();
      if (f == 0)
      {
        calculateAnother = false;
      }
      else
      {
       rule = scan.nextLine(); 
      }
    }                    
    
    }
    
  } 
}