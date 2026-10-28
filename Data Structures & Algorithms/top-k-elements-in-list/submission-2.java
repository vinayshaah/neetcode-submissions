class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return nums;
        }

        List<Integer> myList = new ArrayList<>();
        myList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> topK = myList.stream().collect(Collectors.groupingBy(x->x, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(x->x.getKey()).limit(k).collect(Collectors.toList());
        return topK.stream().mapToInt(Integer::intValue).toArray();

        
    }
}
