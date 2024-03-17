package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem64 {
    static int count = 0;
    static boolean[][] array;
    static boolean[] check;

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int point = Integer.parseInt(str.nextToken());
        int line = Integer.parseInt(str.nextToken());

        array = new boolean[point][point];
        check = new boolean[point];
        check[0] = true;

        for(int i = 0; i < line; i++){
            str = new StringTokenizer(br.readLine());
            array[Integer.valueOf(str.nextToken()) - 1][Integer.valueOf(str.nextToken()) - 1] = true;
        }

        DFS(0,point - 1);
        bw.write(String.valueOf(count));
        bw.flush();
    }

    public static void DFS(int num, int lastPoint){
        if(num == lastPoint)
            count++;

        for(int i = 0; i <= lastPoint; i++){
            if(array[num][i] && !check[i]) {
                check[i] = true;
                DFS(i, lastPoint);
                check[i] = false;
            }
        }
    }
}
