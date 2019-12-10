//Smallest Substring of All Characters
//https://www.pramp.com/challenge/wqNo9joKG6IJm67B6z34



class Solution {

  static String getShortestUniqueSubstring(char[] arr, String str) {
    if(arr.length>0 && (str == null || str.isEmpty())){
      return "";
    }
    if(arr.length == 1){
      for(int i=0;i<str.length();i++){
        if(str.charAt(i) == arr[0]){
          return ((Character)arr[0]).toString();
        }
      }
      return "";
    }
	  //System.out.println("0123456789-");
	  //System.out.println(str);
	  int[] countArr = new int[256];
	  int[] countStr = new int[256];
	  
	  for(int i=0;i<arr.length;i++){
		  countArr[arr[i]]++;
	  }
	  
	  //return bruteForce(arr, str, countArr, countStr);
	  return optimal(arr, str, countArr, countStr);
  }
  
  public static String optimal(char[] arr, String str, int[] countArr, int[] countStr){
	  int min = Integer.MAX_VALUE;
	  int indexL = -1;
	  int indexR = -1;
	  int n = str.length();
	  
	  int l = 0;
	  int r = 1;
	  countStr[str.charAt(0)]++;
	  
	  while(l<r && r<n){
		  
		  while(r<n && !match(countArr, countStr)){
			  countStr[str.charAt(r)]++;
			  r++;
		  }
		  
		  if(r<n){
			  //System.out.println("match:"+l+","+(r-1));
			  if(r-l<min){
				  min = r-l;
				  indexL = l;
				  indexR = r;
			  }
		  }
		  
		  while(l<r && match(countArr, countStr)){
			  if(r-l<min){
				  min = r-l;
				  indexL = l;
				  indexR = r;
			  }
			  //System.out.println("sub match:"+l+","+(r-1));
			  countStr[str.charAt(l)]--;
			  l++;
		  }
	  }
	  if(indexL != -1 && indexR != -1){
		  return str.substring(indexL, indexR);
	  }
	  return "";
  }
  
  public static void print(int[] countArr, int[] countStr){
	  for(int i=0;i<256;i++){
		  for(int j=0;j<countArr[i];j++){
			  System.out.print((char)i);
		  }
	  }
	  System.out.println();
	  
	  for(int i=0;i<256;i++){
		  for(int j=0;j<countStr[i];j++){
			  System.out.print((char)i);
		  }
	  }
	  System.out.println();
  }
  
  public static String bruteForce(char[] arr, String str, int[] countArr, int[] countStr){
	  int indexL = -1;
	  int indexR = -1;
	  int min = Integer.MAX_VALUE;
	  
	  for(int i=0;i<str.length();i++){
		  countStr = new int[256];
		  for(int j=i;j<str.length();j++){
			  countStr[str.charAt(j)]++;
			  if(match(countArr, countStr)){
				  if(j-i+1<min){
					  min = j-i+1;
					  indexL = i;
					  indexR = j;
					  //System.out.println("match:"+i+","+j);
				  }
				  break;
			  }
		  }
	  }
	  if(indexL != -1 && indexR != -1){
		  return str.substring(indexL, indexR+1);
	  }
	  return "";
  }
  
  public static boolean match(int[] countArr, int[] countStr){
    for(int i=0;i<256;i++){
      if(countStr[i] < countArr[i]){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[] arr = new char[]{'x','y','z', 'w'};
    String ans = getShortestUniqueSubstring(arr, "xyzkumargauravwzyzywwkumarxx");
    System.out.println(ans);
  }

}
