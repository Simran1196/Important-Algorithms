/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import java.util.*;

public class Test

 {
	public static void main (String[] args)throws IOException
        {
            Scanner s  = new Scanner(System.in);
             String txt = s.next();//"ABABDABACDABABCABAB"; 
            String pat = s.next(); //"ABABACA"; 
            new Test().KMPSearch(pat, txt); 
        }
        
        static void KMPSearch(String pat, String txt)
        {
            int m = pat.length();
            int n = txt.length();
            int f=0;
            int[] longestprefixsuffix = new int[m];
            computeLPS(longestprefixsuffix,pat,m);
            
            int i=0;
            int j=0;
            while(i<n && j<m)
            {
                if(txt.charAt(i)==pat.charAt(j))
                {
                    i++;
                    j++;
                }
                if(j==m)
                {
                   System.out.println("Match"); 
                   f=1;
                   break;
                }
                else if(txt.charAt(i)!=pat.charAt(j))
                {
                    if(j==0)
                        i++;
                    else
                        j = longestprefixsuffix[j-1];
                }
            }
            
            if(f==0)
               System.out.println("NonMatch."); 
        }
        

        private static void computeLPS(int[] lps, String pat, int m) 
        {
            int i=0,j=1;
            lps[0] = 0;
            
            
            while(i<m && j<m )
            {
                if(pat.charAt(i)==pat.charAt(j))
                {
                    lps[j] = i+1;
                    i++;
                    j++;
                }
                else if(i==0)
               
                    lps[j++]=0;
                else 
                {
                  i = lps[i-1];
                }
            }
        }
        
}




