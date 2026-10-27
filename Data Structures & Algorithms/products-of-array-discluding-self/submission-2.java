class Solution {
    public int[] productExceptSelf(int[] arr) {
        int[] output = new int[arr.length];
        int initialProduct = 1;
        for(int i=0;i<arr.length;i++){
            //first populate the output[] with the left product
            if(i==0)
                output[i] = initialProduct;
            else{
                initialProduct=initialProduct*arr[i-1];
                output[i]=initialProduct;
            }
            //System.out.print(output[i]+"    ");
        }
        //System.out.println("Final product : \n");
        initialProduct = 1;
        for(int i=arr.length-1;i>=0;i--){
            if(i==arr.length-1)
                output[i]=output[i]*initialProduct;
            else {
                initialProduct=initialProduct*arr[i+1];
                output[i]=output[i]*initialProduct;
            }
           // System.out.print(output[i]+"    ");
        }
        return output;
    }
}  
 