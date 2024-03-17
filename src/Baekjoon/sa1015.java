package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sa1015 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int size = Integer.valueOf(str.nextToken());
        int[] array = new int[size];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            array[i] = Integer.valueOf(str.nextToken());
        }

        int[] result = new int[size];
        for(int i =0 ; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j) continue;

                if(array[i] == array[j]){
                    if(i > j) result[i]++;
                }
                else if(array[i] > array[j]){
                    result[i]++;
                }
            }
        }


        String output = Arrays.toString(result).replace("[","").replace("]","").replace(",","");

        bw.write(output);
        bw.newLine();
        bw.flush();
    }
}
