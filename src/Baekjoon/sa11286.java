package Baekjoon;

import java.io.*;
import java.util.*;

public class sa11286 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer str;
    static PriorityQueue<Integer> pqL = new PriorityQueue<>();
    static PriorityQueue<Integer> pqH = new PriorityQueue<>(Collections.reverseOrder());
    static int N;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            int num = Integer.valueOf(str.nextToken());
            //출력하는 경우

            if(num < 0) pqH.add(num);
            else if(num > 0) pqL.add(num);
            else {
                if(pqL.isEmpty() && pqH.isEmpty()) bw.write("0");
                else{
                    if(pqL.isEmpty()) {
                        bw.write(String.valueOf(pqH.poll()));
                    }
                    else if(pqH.isEmpty()){
                        bw.write(String.valueOf(pqL.poll()));
                    }
                    else{
                        int plus = pqL.peek();
                        int minus = Math.abs(pqH.peek());

                        if(plus == minus || minus < plus) bw.write(String.valueOf(pqH.poll()));
                        else bw.write(String.valueOf(pqL.poll()));
                    }
                }
                bw.newLine();
            }
        }
        bw.flush();
    }
}
