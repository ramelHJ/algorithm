package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem56 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());

        Reflection(num);
        bw.flush();
    }

    public static void Reflection(int num) throws IOException {
        if(num == 0)
            return;

        Reflection(num - 1);
        bw.write(Integer.valueOf(num) + " ");
    }
}
