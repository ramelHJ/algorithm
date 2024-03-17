package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem49 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());
        int[] ahead = new int[num];
        int[] right = new int[num];

        str = new StringTokenizer(br.readLine());
        for(int i =0; i < num; i++){
            ahead[i] = Integer.parseInt(str.nextToken());
        }

        str = new StringTokenizer(br.readLine());
        for(int i =0; i < num; i++){
            right[i] = Integer.parseInt(str.nextToken());
        }

        int[][] array = new int[num][num];
        int sum = 0;
        for(int i =0; i < num; i++){
            for(int j = 0; j < num; j++){
                array[i][j] = ahead[i] < right[j] ? ahead[i] : right[j];
                sum += array[i][j];
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
