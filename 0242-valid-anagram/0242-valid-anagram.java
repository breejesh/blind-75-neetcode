class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!sMap.containsKey(c)) {
                sMap.put(c, 0);
            }
            sMap.put(c, sMap.get(c) + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);            
            if(!sMap.containsKey(c) || sMap.get(c) == 0) {
                return false;
            }
            sMap.put(c, sMap.get(c) - 1);
        }
        return true;
    }
}