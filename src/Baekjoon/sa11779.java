package Baekjoon;

import java.io.*;
import java.util.*;

public class sa11779 {
    static int N;
    static int M;
    static List<Bus>[] bus;
    static int[] dist;
    static int[] pre;
    static int start;
    static int end;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        bus = new ArrayList[N + 1];
        dist = new int[N + 1];
        pre = new int[N + 1];
        for(int i = 0; i <= N; i++){
            bus[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int y = Integer.valueOf(str.nextToken());
            int z = Integer.valueOf(str.nextToken());

            bus[x].add(new Bus(y,z));
        }

        str = new StringTokenizer(br.readLine());
        start = Integer.valueOf(str.nextToken());
        end = Integer.valueOf(str.nextToken());

        dijkstra(start);
        String result = findPath();
        System.out.println(result);
    }

    private static String findPath() {
        Stack<Integer> stk = new Stack<>();
        stk.push(end);

        return "";
    }

    private static void dijkstra(int start) {
        Queue<Bus> queue = new LinkedList<>();

        dist[start] = 0;
        queue.offer(new Bus(start,0));

        while(!queue.isEmpty()){
            Bus target = queue.poll();

            for(Bus next : bus[target.end]){
                if(dist[next.end] <= dist[target.end] + next.dist) continue;

                pre[next.end] = target.end;
                dist[next.end] = dist[target.end] + next.dist;
                queue.offer(new Bus(next.end, dist[next.end]));
            }
        }
    }

    public static class Bus{
        int end;
        int dist;

        public Bus(int e, int d){
            this.end = e;
            this.dist = d;
        }
    }
}
