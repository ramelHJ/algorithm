package Baekjoon;

import java.io.*;
import java.util.*;

public class sa1781 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer str;
    static PriorityQueue<Problem> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> noodleCount = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = new StringTokenizer(br.readLine());
        int N  = Integer.valueOf(str.nextToken());
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            pq.add(new Problem(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken())));
        }

        for(int i = 0;  i < N; i++){
            Problem p = pq.poll();
            if(noodleCount.size() < p.deadline){
                noodleCount.add(p.noodle);
            }
            else{
                if(noodleCount.peek() < p.noodle){
                    noodleCount.poll();
                    noodleCount.add(p.noodle);
                }
            }
        }

        int sum = 0;
        int size = noodleCount.size();
        for(int i = 0; i < size; i++){
            sum += noodleCount.poll();
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }

    public static class Problem implements Comparable<Problem>{
        int deadline;
        int noodle;
        
        public Problem(int deadline, int noodle){
            this.deadline = deadline;
            this.noodle = noodle;
        }

        @Override
        public int compareTo(Problem o) {
            if(deadline == o.deadline)
                return o.noodle - noodle;
            return deadline - o.deadline;
        }
    }
}
