//https://leetcode.com/problems/search-suggestions-system/
//Brute Force Solution
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String word) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            List<String> list = getProducts(products, new String(sb));
            result.add(list);
        }
        return result;
    }
    
    public List<String> getProducts(String[] products, String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        for(String product: products) {
            if(product.startsWith(s)) {
                list.add(product);
                count++;
            }
            if(count == 3) {
                return list;
            }
        }
        return list;
    }
    
}
