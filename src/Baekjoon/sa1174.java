package Baekjoon;

import java.io.*;
import java.util.*;

public class sa1174 {
    static int N;
    static int[] arr = {0,1,2,3,4,5,6,7,8,9};
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        dfs(0,9);
        Collections.sort(list);

        try{
            bw.write(String.valueOf(list.get(N - 1)));
        }
        catch (Exception e){
            bw.write("-1");
        }
        bw.flush();
    }

    private static void dfs(long n, int index) {
        if(!list.contains(n)) list.add(n);

        if(index < 0) return;

        dfs((n * 10) + arr[index], index - 1);
        dfs(n, index - 1);
    }
}
