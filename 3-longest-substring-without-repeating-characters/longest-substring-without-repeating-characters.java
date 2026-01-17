class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if(l <= 1)
            return l;
        int i=0, j=0;
        char[] ca = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        while(j < l){
            if(map.get(ca[j]) == null)
                map.put(ca[j], 1);
            else{
                max = Math.max(max, j-i);
                map.put(ca[j], map.get(ca[j])+1);
                while(map.get(ca[j]) != 1){
                    map.put(ca[i], map.get(ca[i])-1);
                    i++;
                }
            }
            j++;     
        }
        max = Math.max(max, j-i);
        return max;
    }
}