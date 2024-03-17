package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem57 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.valueOf(str.nextToken());

        ChangeTwo(num);
        bw.flush();
    }

    public static void ChangeTwo(int num) throws IOException {
        if(num < 2)
        {
            bw.write(String.valueOf(num));
            return;
        }

        ChangeTwo(num / 2);
        bw.write(String.valueOf(num % 2));
    }

}
