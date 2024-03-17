package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem22 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //전체 학생 수
        StringTokenizer str = new StringTokenizer(br.readLine());
        int tempCount = Integer.parseInt(str.nextToken());
        int sumCount = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int[] tempArray = new int[tempCount];
        for(int i = 0 ; i < tempCount; i++){
            tempArray[i] = Integer.valueOf(str.nextToken());
        }

        int min = 0;
        for(int i = 0 ; i < sumCount; i++){
            min += tempArray[i];
        }

        int now = min;
        for(int i = 0 ; i < tempCount - sumCount; i++){
            now += (tempArray[i + sumCount] - tempArray[i]);
            if(now > min) min = now;
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }
}
