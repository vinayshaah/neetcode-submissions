class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set<Integer> list = new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        List<Integer> list2 = new ArrayList<>(list);
        //Collections.sort(list2);
        int start=0, end=0, first=list2.get(start), longestSeq=1;
        
        for(int i=1;i<list2.size();i++){
            int sec = list2.get(i);
            if(sec-first == i-start){
                end=i;
                if(longestSeq < (end-start)+1) {
                    longestSeq = (end-start)+1;
                }
            } else {
                first=list2.get(i);
                start=i;
                end=i;
            }
        }
        return longestSeq;
        
    }
}
