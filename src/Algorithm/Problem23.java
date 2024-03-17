package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem23 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //전체 학생 수
        StringTokenizer str = new StringTokenizer(br.readLine());
        int count = Integer.valueOf(str.nextToken());

        int[] seq = new int[count];
        str = new StringTokenizer(br.readLine());
        for(int i =0 ; i < count; i++){
            seq[i] = Integer.valueOf(str.nextToken());
        }

        int contiCount = 1;
        int maxContiCount = 1;
        for(int i = 1; i < count; i++){
            if(seq[i-1] <= seq[i])
            {
                contiCount++;
                if(maxContiCount < contiCount)
                    maxContiCount = contiCount;
            }
            else
                contiCount = 1;
        }
        bw.write(String.valueOf(maxContiCount));
        bw.flush();
    }
}
