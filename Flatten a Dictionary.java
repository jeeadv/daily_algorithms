//Flatten a Dictionary
//https://www.pramp.com/challenge/AMypWAprdmUlaP2gPVLZ

import java.io.*;
import java.util.*;

class Solution {
	
  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    HashMap<String, String> output = new HashMap<>();
    helper(dict, output, "");
    return output;
  }
  
  static void helper(HashMap<String, Object> dict, HashMap<String, String> output, String parentKey){
    for(Map.Entry<String, Object> entry: dict.entrySet()){
      String key = entry.getKey();
      Object value = entry.getValue();
      
      String newParentKey = "";
      if(!"".equals(parentKey)){
        newParentKey += parentKey;
        if(!"".equals(key)){
          newParentKey += ".";
          newParentKey += key;
        }
      }
      else{
        if(!"".equals(key)){
          newParentKey += key;
        }
      }
      
      if(value instanceof Integer){
        output.put(newParentKey, String.valueOf(value));
      }
      else if(value instanceof String){
        output.put(newParentKey, String.valueOf(value));
      }
      else if(value instanceof HashMap){
        helper((HashMap<String, Object>)value, output, newParentKey);
      }
    }
  }

  public static void main(String[] args) {

  }

}
