package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem33 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());
        int[] grade = new int[num];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            grade[i] = Integer.parseInt(str.nextToken());
        }

        int lastMax = 101;
        for(int count = 0 ; count < 3; count++){
            int max = 0;
            for(int i = 0 ; i < num; i++){
                if(grade[i] > max && grade[i] < lastMax)
                    max = grade[i];
            }

            lastMax = max;
        }

        bw.write(String.valueOf(lastMax));
        bw.flush();
    }
}
