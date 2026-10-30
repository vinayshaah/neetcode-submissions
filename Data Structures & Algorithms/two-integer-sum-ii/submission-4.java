class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        boolean isFound=false;
        /*Map<Integer,List<Integer>> hmap = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            List<Integer> listOfIdex 

        } */

           /* for(int i=0;i<numbers.length;i++){
                int j=i+1;
                while(j<numbers.length && numbers[j]<=(target-numbers[i])){
                    if(numbers[j]==target-numbers[i]){
                        isFound = true;
                        result[0]=numbers[i];
                        result[1]=numbers[j];
                        break;
                    }
                    j++;

                }
                if(isFound)
                    break;
            } */

        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            //hset.add(numbers[i]);
            hmap.put(numbers[i],i);
        } 
        for(int i=0;i<numbers.length;i++){
            if(hmap.containsKey(target-numbers[i])){
                result[0]=i+1;
                result[1]=hmap.get(target-numbers[i])+1;
                break;
            }
        }
        
        return result;
        
    }
}
