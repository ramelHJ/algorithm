package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem17 {
    public static void Problem() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(str.nextToken());

        for(int i = 0;  i< count; i++) {
            str = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(str.nextToken());
            int answer = num * (num + 1) / 2;
            int inputAnswer = Integer.parseInt(str.nextToken());

            if(inputAnswer == answer)
                bw.write("YES");
            else
                bw.write("NO");
            bw.newLine();
        }
        bw.flush();
    }
}
