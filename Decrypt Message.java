//Decrypt Message
//https://www.pramp.com/challenge/8noLWxLP6JUZJ2bA2rnx

//time O(n) space O(1)
import java.io.*;
import java.util.*;

class Solution {

  static String decrypt(String word) {
    if(word == null || word.length() == 0){
      return word;
    }
    
    String res = "";
    
    int curr = word.charAt(0) - 1;
    
    while(curr < 'a' || curr > 'z'){
      curr += 26;
    }
    
    res += (char) curr;
    
    for(int i=1;i<word.length();i++){
      curr = word.charAt(i) - word.charAt(i - 1);
      while(curr < 'a' || curr > 'z'){
        curr += 26;
      }
      res += (char) curr;
    }
    
    return res;
  }

  public static void main(String[] args) {
    String word = "dnotq";
    String ans = decrypt(word);
    System.out.println(ans);
  }

}
/*
input:  word = "dnotq"
output: "crime"

Decrypted message:	c	   r	 i	m	   e
            Step 1:	99	114	105	109	101
            Step 2:	100	214	319	428	529
            Step 3:	100	110	111	116	113
Encrypted message:	d	   n	 o	t	   q

ASCII(d) = ASCII(c) + 1 -26*k
ASCII(c) = ASCII(d) - 1 + 26*k
c = [d - 1] range of a to z
c = [d - 1 + 26] range of a to z

ascii(n) = ascii(r) + ascii(c) + 1 - 26*k
ascii(r) = ascii(n) - ascii(c) - 1 + 26*k
ascii(r) = ascii(n) - ASCII(d)
*/

//time O(n) space O(n)
import java.io.*;
import java.util.*;

class Solution {

  static String decrypt(String word) {
    if(word == null || word.length() == 0){
      return word;
    }
    
    int[] arr = new int[word.length()];
    arr[0] = word.charAt(0) - 1;
    
    while(arr[0] < 'a' || arr[0] > 'z'){
      arr[0] += 26;
    }
    
    for(int i=1;i<word.length();i++){
      //arr[i] = word.charAt(i) - arr[i-1] - 1;
      arr[i] = word.charAt(i) - word.charAt(i - 1);
      while(arr[i] < 'a' || arr[i] > 'z'){
        arr[i] += 26;
      }
    }
    
    String res = "";
    for(int i=0;i<arr.length;i++){
      res += (char)arr[i];
    }
    return res;
  }

  public static void main(String[] args) {
    String word = "dnotq";
    String ans = decrypt(word);
    System.out.println(ans);
  }

}
/*
input:  word = "dnotq"
output: "crime"

Decrypted message:	c	   r	 i	m	   e
            Step 1:	99	114	105	109	101
            Step 2:	100	214	319	428	529
            Step 3:	100	110	111	116	113
Encrypted message:	d	   n	 o	t	   q

ASCII(d) = ASCII(c) + 1 -26*k
ASCII(c) = ASCII(d) - 1 + 26*k
c = [d - 1] range of a to z
c = [d - 1 + 26] range of a to z

ascii(n) = ascii(r) + ascii(c) + 1 - 26*k
ascii(r) = ascii(n) - ascii(c) - 1 + 26*k
ascii(r) = ascii(n) - ASCII(d)
*/
