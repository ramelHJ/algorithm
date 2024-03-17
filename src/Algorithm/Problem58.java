package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem58 {

    static BufferedWriter bw;

    static {
        try {
            bw = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    static int max;
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        max = Integer.parseInt(str.nextToken());

        bw.write("전위순회 출력 : ");

        AheadOutput(1);
        bw.newLine();

        bw.write("중위순회 출력 : ");
        MiddleOutput(1);
        bw.newLine();

        bw.write("후위순회 출력 : ");
        BehindOutput(1);
        bw.newLine();

        bw.flush();

    }

    public static void AheadOutput(int num) throws IOException {
        if(num > max)
            return;

        bw.write(String.valueOf(num) + " ");
        AheadOutput(num * 2);
        AheadOutput(num * 2 + 1);
    }

    public static void MiddleOutput(int num) throws IOException {
        if(num > max)
            return;

        MiddleOutput(num * 2);
        bw.write(String.valueOf(num) + " ");
        MiddleOutput(num * 2 + 1);
    }

    public static void BehindOutput(int num) throws IOException {
        if(num > max)
            return;

        BehindOutput(num * 2);
        BehindOutput(num * 2 + 1);
        bw.write(String.valueOf(num) + " ");
    }
}
