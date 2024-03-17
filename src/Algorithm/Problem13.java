package Algorithm;

public class Problem13 {
    public static void Problem(){
        int[] nums = new int[10];
        String input = "1230565625";
        for(int i = 0 ; i < input.length(); i++){
            int k = Character.getNumericValue(input.charAt(i));
            nums[k]++;
        }

        int max = 0;
        int result = 0;
        for(int i =0 ; i < 10; i++) {
            if(nums[i] >= max){
                max = nums[i];
                result = i;
            }
        }
        System.out.println(result);
    }
}
