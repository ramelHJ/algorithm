package Programers;

import java.util.*;

public class 디스크_컨트롤러 {

    public static void main(String[] args) throws Exception{
        //int[][] jobs = {{0,3}, {1,9}, {2,6}};
        //int[][] jobs = {{0,5}, {1,2}, {5,5}};
        //int[][] jobs = {{1,4}, {7,9}, {1000,3}};
        //int[][] jobs = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};
        //int[][] jobs = {{1,3}, {1,9}, {2,6}};
        //int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        //int[][] jobs = {{0,10}, {2,10}, {9,10}, {15,2}};
        //int[][] jobs = {{0,10}, {2,12}, {9,19}, {15,17}};

//        System.out.println(solution(new int[][]{{0,3},{1,9},{2,6}}) + " = " + 9);
//        System.out.println(solution(new int[][]{{1000,1000}}) + " = " + 1000);
//        System.out.println(solution(new int[][]{{0,1}}) + " = " + 1);
//        System.out.println(solution(new int[][]{{0,1},{0,1},{0,1}}) + " = " + 2);
//        System.out.println(solution(new int[][]{{0,1},{0,1},{0,1},{0,1}}) + " = " + 2);
//        System.out.println(solution(new int[][]{{0,1},{1000,1000}}) + " = " + 500);
//        System.out.println(solution(new int[][]{{100,100},{1000,1000}}) + " = " + 500);
//        System.out.println(solution(new int[][]{{10,10},{30,10},{50,2},{51,2}}) + " = " + 6);
//        System.out.println(solution(new int[][]{{0,3},{1,9},{2,6},{30,3}}) + " = " + 7);


        System.out.println(solution(new int[][]{{24,10}, {28,39}, {43,20}, {37,5}, {47,22}, {20,47}, {15,34}, {15,2}, {35,43}, {26,1}}) + " = " + 72);
        System.out.println(solution(new int[][]{{1,9},{1,4},{1,5},{1,7},{1,3}}) + " = " + 13);
        System.out.println(solution(new int[][]{{0,10},{5,10}}) + " = " + "??");
        //int result = solution(jobs);
        //System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int time = 0;
        int max = 0;
        for(int i = 0; i < jobs.length; i++){
            max = Math.max(jobs[i][1], max);
        }
        Job target = new Job(0,0);
        for(int i = 0; i <= 10_000_000; i++){
            //그 시간대에서 추가 시키기
            for(int j = 0; j < jobs.length; j++){
                if(jobs[j][0] == i){
                    pq.add(new Job(i, jobs[j][1]));
                }
            }

            if(target.working == target.length){
                if(pq.isEmpty()) continue;

                target = pq.poll();
            }

            time += 1 + pq.size();
            target.working++;
        }

        return time / jobs.length;
    }

    public static class Job implements Comparable<Job>{
        int start;
        int length;
        int working;
        public Job(int start, int length){
            this.start = start;
            this.length = length;
            this.working = 0;
        }

        @Override
        public int compareTo(Job o){
            return length - o.length;
        }
    }
}
