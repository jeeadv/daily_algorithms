//Validate IP Address
//https://www.pramp.com/challenge/Q5G1jZ1OWdtZ3GbAGpNE
import java.io.*;
import java.util.*;

class Solution {

	static boolean validateIP(String ip) {
    if(ip == null || ip.isEmpty()){
      return false;
    }
		String[] arr = ip.split("\\.");
    System.out.println(Arrays.toString(arr));
    if(arr.length<4 || arr.length>4){
      return false;
    }
    for(String str: arr){
      
      if(str.length() > 3){
        return false;
      }
      else if(str.length() == 3){
        char c = str.charAt(0);
        if(c<'1' || c>'2'){
          return false;
        }
        if(c == '1'){
          char d = str.charAt(1);
          if(d<'0' || d>'9'){
            return false;
          }
          d = str.charAt(2);
          if(d<'0' || d>'9'){
            return false;
          }
        }
        else if(c == '2'){
          char d = str.charAt(1);
          if(d<'0' || d>'5'){
            return false;
          }
          d = str.charAt(2);
          if(d<'0' || d>'5'){
            return false;
          }
        }
        
      }
      else if(str.length() == 2){
        char c = str.charAt(0);
        if(c<'1' || c>'9'){
          return false;
        }
        c = str.charAt(1);
        if(c<'0' || c>'9'){
          return false;
        }
      }
      else if(str.length() == 1){
        char c = str.charAt(0);
        if(c<'0' || c>'9'){
          return false;
        }
      }
      else if(str.length() == 0){
        return false;
      }
      
	  }
    return true;
  }

	public static void main(String[] args) {
    // 001.00.00.1
    // 255.0.0.0
	  //System.out.println(validateIP("192.168.0.1"));
	}
}
