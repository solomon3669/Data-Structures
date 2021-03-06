/* 
LeetCode 8 :String to Integer (atoi)

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting
from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as
a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior
of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str 
is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If 
    the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

Example 1:

Input: "42"
Output: 42

Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.

*/

class Solution {
    public int myAtoi(String str) {
        
         long a=0;
         boolean sign = false;
        
           int i=0;
             int digits = 0;
            
                while(i< str.length() && str.charAt(i) == ' ')   // remove leading spaces
                     i++;
            
          if(i == str.length())  // 
              return 0;
                    
                if(str.charAt(i) == '+' || str.charAt(i) == '-' ){    
                    
                    if(str.charAt(i) == '-')
                        sign = true;
                    
                      i++;
                    if(i == str.length())
                        return 0;
                }
        
             for(; i<str.length(); i++){
                        
             int temp = str.charAt(i) - '0';
            
             if(temp <0 || temp >9 ){  // not a digit
                 
                 if(sign)
                     a = a*-1;
                 
                return (int)a;
             }
            
              else{                  
                a = a*10 +temp;  
                  
                  if(a != 0)  // if leading zeroes are present then number ofdigits is 0
                  digits++;
              }
            
            if( digits > 10)  // if digits > 10 we have exceeded integer boundary
                break;
        }
         
         if(a > Integer.MAX_VALUE){
             
           if(sign)
               return Integer.MIN_VALUE;
             
             else
                 return Integer.MAX_VALUE;
         }
             
         if(sign)
             a = a*(-1);
        
        return (int)a;
    }
}
