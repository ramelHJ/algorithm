package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem52 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());

        int[] uglyNumber = new int[1501];
        uglyNumber[1] = 1;
        int multiple2 = 1;
        int multiple3 = 1;
        int multiple5 = 1;

        for(int i = 2; i <= num; i++){
            //min 값을 찾는 과정
            int min;
            if(uglyNumber[multiple2] * 2 < uglyNumber[multiple3] * 3)
                min = uglyNumber[multiple2] * 2;
            else
                min = uglyNumber[multiple3] * 3;
            if(uglyNumber[multiple5] * 5 < min)
                min = uglyNumber[multiple5] * 5;

            //해당 값 중 배수인 경우 값을 추가 시키는 과정
            if(uglyNumber[multiple2] * 2 == min) multiple2++;
            if(uglyNumber[multiple3] * 3 == min) multiple3++;
            if(uglyNumber[multiple5] * 5 == min) multiple5++;

            uglyNumber[i] = min;
        }

        bw.write(String.valueOf(uglyNumber[num]));
        bw.flush();
    }
}
