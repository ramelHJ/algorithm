package Baekjoon;

import java.io.*;
import java.util.*;

public class sa1715 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(Integer.valueOf(br.readLine()));
        }

        int result = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            result += a + b;

            pq.add(a + b);
        }

        System.out.println(result);
    }
}
