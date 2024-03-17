package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem28 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str.nextToken());
        int fiveCount = 1;

        for(int i = 10; i <= num; i++){
            int selectNum = i;

            while(true){
                if(selectNum % 5 == 0)
                {
                    fiveCount++;
                    selectNum /= 5;
                }
                else
                    break;
            }
        }

        bw.write(String.valueOf(fiveCount));
        bw.flush();


    }
}
