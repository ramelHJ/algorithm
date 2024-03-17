package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem63 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int point = Integer.parseInt(str.nextToken());
        int line = Integer.parseInt(str.nextToken());

        int[][] array = new int[point][point];

        for(int i = 0; i < line; i++){
            str = new StringTokenizer(br.readLine());
            array[Integer.valueOf(str.nextToken()) - 1][Integer.valueOf(str.nextToken()) - 1] = Integer.valueOf(str.nextToken());
        }

        for(int i = 0; i < point; i++){
            for(int j = 0; j < point; j++){
                bw.write(array[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

}
