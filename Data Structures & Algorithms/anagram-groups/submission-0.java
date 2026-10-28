class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returning = new ArrayList<>();
        if(strs==null || strs.length==0){
            return returning;
        }
        int[] charArray = null;      
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String currentWord = strs[i];
            charArray = new int[26];
            for(int j=0;j<currentWord.length();j++){
                charArray[currentWord.charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<charArray.length;j++){
                sb.append((char)(j+'a')).append(charArray[j]).append('#');
            }
            List<String> anagrams = map.get(sb.toString());
            if(anagrams==null){
                anagrams=new ArrayList<>();
                anagrams.add(currentWord);
                map.put(sb.toString(), anagrams);
            } else {
                anagrams.add(currentWord);
                map.put(sb.toString(), anagrams);
            }
        }

        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            returning.add(entry.getValue());
        }
        return returning;
        
    }
}
