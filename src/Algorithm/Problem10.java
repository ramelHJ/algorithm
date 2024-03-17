package Algorithm;

import java.util.stream.Stream;

public class Problem10 {
    public static void Problem(){
        int inputNum = 5;
        String inputData = "125 15232 79 1325 97";
        String[] inputDatas = inputData.split(" ");

        int[] values = Stream.of(inputDatas)
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxDigitSum = 0;
        int max = 0;

        for(int i = 0 ; i < inputNum; i++){
            int num = values[i];
            int digitSum = 0;
            while(num > 0){
                digitSum += num % 10;
                num /= 10;
            }
            if(digitSum > maxDigitSum){
                maxDigitSum = digitSum;
                max = values[i];
            }
            else if(digitSum == maxDigitSum && values[i] > max)
                max = values[i];
        }
        System.out.println(max);
    }
}
