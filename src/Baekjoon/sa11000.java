package Baekjoon;

import java.io.*;
import java.util.*;

public class sa11000 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        List<Lecture> lecture = new ArrayList<>();
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            lecture.add(new Lecture(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken())));
        }

        Collections.sort(lecture, Collections.reverseOrder()); //끝나는시간 내림차순

        int max = 0;
        //끝나는시간을 담아두는 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); //맥스 힙
        for(Lecture l : lecture){
            //넣으려고 하는 강의의 시작시간보다 빠른거 제외 시키기
            while(!queue.isEmpty() && l.end <= queue.peek()){
                queue.poll();
            }

            //queue 넣고 동시에 강의실 개수가 제일 많으면 최신화화
            queue.add(l.start);
            max = Math.max(max, queue.size());
        }

        System.out.println(max);
    }

    public static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o){
            return end - o.end;
        }
    }
}
