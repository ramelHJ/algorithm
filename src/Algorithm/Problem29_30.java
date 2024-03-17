package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem29_30 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());
        int copyNum = num;

        int threeCount = 0;
        int digit = 1;
        while(true){
            if(copyNum == 0)
                break;

            //각 자리수가 3보다 클때 숫자 세는 부분
            if(copyNum % 10 >= 3)
            {
                threeCount += (num % digit) + 1;
            }

            //각 자리수에서 누적된 3의 개수
            threeCount += digit * (copyNum / 10);

            digit *= 10;
            copyNum /= 10;
        }

        bw.write(String.valueOf(threeCount));
        bw.flush();
    }
}

