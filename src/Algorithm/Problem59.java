package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem59 {
    static int num;
    static boolean[] check;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        num = Integer.valueOf(str.nextToken());
        check = new boolean[num + 1];
        DFS(1);
    }

    public static void DFS(int depth) throws IOException {
        if(depth > num) {

            for(int i = 1; i <= num; i++){
                if(check[i])
                    bw.write(String.valueOf(i) + " ");
            }
            bw.newLine();
            return;
        }

        check[depth] = true;
        DFS(depth + 1);
        check[depth] = false;
        DFS(depth + 1);
        bw.flush();
    }
}
