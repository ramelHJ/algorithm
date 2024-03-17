package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1074 {
    static int N, r, c;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        r = Integer.valueOf(str.nextToken());
        c = Integer.valueOf(str.nextToken());

        dfs(r,c,(int)Math.pow(2, N));
        System.out.println(result);
    }

    private static void dfs(int r, int c, int size) {
        if(size == 1) return;

        if(r < size / 2 && c < size / 2) dfs(r, c, size / 2);
        else if(r < size / 2 && c >= size / 2) {
            result += size * size / 4;
            dfs(r, c - size / 2 , size / 2);
        }
        else if(r >= size / 2 && c < size / 2){
            result += (size * size / 4) * 2;
            dfs(r - size/2, c, size / 2);
        }
        else{
            result += (size * size / 4) * 3;
            dfs(r - size / 2, c - size / 2, size / 2);
        }

    }


}
