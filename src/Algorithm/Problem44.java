package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem44 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int horseHouse = Integer.parseInt(str.nextToken());
        int horse = Integer.parseInt(str.nextToken());
        int[] array = new int[horseHouse];
        for(int i = 0; i < horseHouse; i++){
            str = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(array);

        int result = 0;
        int start = 1;
        int end = array[horseHouse - 1];

        while(start <= end){
            int middle = (start + end) / 2;
            if(Check(middle, array) >= horse){
                start = middle + 1;
                result = middle;
            }
            else
                end = middle - 1;

        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int Check(int middle, int[] array) {
        int count = 1;
        int prev = array[0];

        for(int i =0; i < Arrays.stream(array).count(); i++){
            if(i - prev >= middle)
            {
               prev = i;
               count++;
            }
        }

        return count;
    }
}
