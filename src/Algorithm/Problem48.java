package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem48 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] array = new int[9][9];
        int[] average = new int[9];
        for(int i =0; i < 9; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                array[i][j] = Integer.parseInt(str.nextToken());
                average[i] += array[i][j];
            }
            boolean isUp = average[i] % 9 > 4 ? true : false;
            average[i] /= 9;
            if(isUp) average[i]++;
        }

        for(int i = 0; i < 9; i++){
            int distance = 100;
            int selectNum = 0;
            for(int j = 0; j < 9; j++){
                int minus = Math.abs(average[i] - array[i][j]);
                if(minus < distance) {
                    distance = minus;
                    selectNum = array[i][j];
                }
            }

            bw.write(String.valueOf(average[i]) + " " + String.valueOf(selectNum));
            bw.newLine();
        }
        bw.flush();



    }
}
