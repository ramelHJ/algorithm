package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sa1475 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[9];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int num = Character.getNumericValue(c);
            if(num == 9)
                arr[6]++;
            else
                arr[num]++;
        }

        if(arr[6] % 2 == 1)
            arr[6]++;

        arr[6] /= 2;

        int max = 0;
        for(int i = 0; i < 9; i++){
            max = Math.max(arr[i],max);
        }

        System.out.println(max);
    }
}
