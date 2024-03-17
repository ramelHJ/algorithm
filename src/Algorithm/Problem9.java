package Algorithm;


public class Problem9 {
    public static void Problem(){
        int arraySize = 28;
        int[] divisors = new int[arraySize + 1];
        String result = "1";
        for(int i = 2; i <= arraySize; i++){
            for(int j = i; j <= arraySize; j++){
                if(j % i == 0)
                    divisors[j]++;
            }
            result += " " + String.valueOf(divisors[i] + 1);
        }
        System.out.println(result);
    }
}
