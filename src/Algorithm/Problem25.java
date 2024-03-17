package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem25 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int studentCount = Integer.valueOf(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int[] score = new int[studentCount];
        for(int i =0 ; i < studentCount; i++){
            score[i] = Integer.valueOf(str.nextToken());
        }

        int[] grade = new int[studentCount];
        for(int i =0 ; i < studentCount; i++){
            grade[i] = 1;
            for(int j = 0; j < studentCount; j++){
                if(i==j) continue;

                if(score[i] < score[j])
                    grade[i]++;
            }
        }

        String result = Arrays.toString(grade).replace("[","").replace("]","").replace(",","");
        bw.write(result);
        bw.flush();
    }
}
