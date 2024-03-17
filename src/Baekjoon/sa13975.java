package Baekjoon;

import java.io.*;
import java.util.*;

public class sa13975 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer str;
    static long sum;
    static int N;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = new StringTokenizer(br.readLine());
        int tc = Integer.valueOf(str.nextToken());
        for(int i = 0; i < tc; i++){
            //초기화
            sum = 0;
            pq = new PriorityQueue<>();

            //입력값
            str = new StringTokenizer(br.readLine());
            N = Integer.valueOf(str.nextToken());
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                pq.add(Long.valueOf(str.nextToken()));
            }

            //계산산
           while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();

                sum += (a + b);
                pq.add(a + b);
            }

            bw.write(String.valueOf(sum));
            bw.newLine();
        }
        bw.flush();
    }
}
