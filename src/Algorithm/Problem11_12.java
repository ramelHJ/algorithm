package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11_12 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());
        int minusNum = 0;
        int result = 0;
        int copyNum = num;
        while(true){
             if(copyNum == 0) break;
             result += num - minusNum;
             minusNum = minusNum * 10 + 9;
            copyNum /= 10;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
