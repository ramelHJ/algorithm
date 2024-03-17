package Baekjoon;

import java.io.*;
import java.util.*;

public class sa1966 {
    static int tc;
    static int N, M; //문서 개수, 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여있는지 확인하는 수 =>
    static Queue<Integer> queue;
    static Queue<Integer> queueIndex;
    static int[] count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer str;
    public static void main(String[] args) throws Exception{
        str = new StringTokenizer(br.readLine());
        tc = Integer.valueOf(str.nextToken());
        for(int t = 0; t < tc; t++){
            str = new StringTokenizer(br.readLine());
            N = Integer.valueOf(str.nextToken());
            M = Integer.valueOf(str.nextToken());
            push();
        }
    }

    private static void push() throws IOException {
        queue = new LinkedList<>();
        queueIndex = new LinkedList<>();
        str = new StringTokenizer(br.readLine());
        count = new int[10];
        for(int i = 0; i < N; i++){
            int num = Integer.valueOf(str.nextToken());
            queue.offer(num);
            queueIndex.offer(i);
            count[num]++;
        }

        int now = 1;

        while(!queue.isEmpty()){
            int num = queue.poll();
            int numIndex = queueIndex.poll();

            //값이 큰게 존재하면 큐 뒤에 넣기
            if(findMax() > num) {
                queue.offer(num);
                queueIndex.offer(numIndex);
                continue;
            }

            //프린트하는게 내가 원하는게 맞는지 체크
            if(numIndex == M) {
                System.out.println(now);
                break;
            }

            now++;
            count[num]--;
        }
    }

    private static int findMax(){
        int max = -1;
        for(int i = 0; i < 10; i++){
            if(count[i] > 0) max = i;
        }

        return max;
    }
}
