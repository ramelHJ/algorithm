package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1431 {
    static String[] output;
    static int[] sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int count = Integer.valueOf(str.nextToken());
        output = new String[count];
        sum = new int[count];

        for(int i = 0; i < count; i ++){
            str = new StringTokenizer(br.readLine());
            output[i] = str.nextToken();

            //숫자의 합 구해서 넣어주기기
           for(int j = 0 ; j < output[i].length(); j++){
                int value = tryParseInt(output[i].charAt(j), -1);
                if(value != -1) {
                    sum[i] += value;
                }
            }

            RangeArray(i);
        }


    }

    public static int tryParseInt(char value, int defaultVal) {
        try {
            return Integer.parseInt(String.valueOf(value));
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    private static void RangeArray(int i) {
        int position = CheckLength(i);
    }

    private static int CheckLength(int i) {



        return 0;
    }


}
