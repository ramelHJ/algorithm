package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa16261 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int problemCount = Integer.parseInt(str.nextToken());

        int[] array = new int[4];


        for(int i = 0 ; i < problemCount; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                array[j] = Integer.valueOf(str.nextToken());
            }

            int bottomLCM = array[1] * array[3] / getGCD(array[1], array[3]);
            int num1 = array[0] * bottomLCM / array[1];
            int num2 = array[2] * bottomLCM / array[3];

            int topLCM = num1 * num2 / getGCD(num1, num2);

            int divisor = getGCD(bottomLCM, topLCM);

            String output = (topLCM / divisor) + " " + (bottomLCM / divisor);

            bw.write(output);
            bw.newLine();
        }
        bw.flush();
    }
    public static int getGCD(int num1, int num2){
        if(num1 % num2 == 0) return num2;

        return getGCD(num2, num1 % num2);
    }
}
