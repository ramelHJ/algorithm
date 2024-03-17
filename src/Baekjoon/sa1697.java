package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class sa1697 {
    static final int MAX = 100_000;
    static final int MIN = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        boolean check[] = new boolean[MAX + 1];
        queue.add(N);
        check[N] = true;

        int cnt = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int num = queue.poll();
                if(num == K){
                    System.out.println(cnt);
                    return;
                }

                if(num - 1 >= MIN && !check[num - 1]) {
                    queue.add(num - 1);
                    check[num - 1] = true;
                }
                if(num + 1 <= MAX && !check[num + 1]) {
                    queue.add(num + 1);
                    check[num + 1] = true;
                }
                if(num * 2 <= MAX && !check[num * 2]) {
                    queue.add(num * 2);
                    check[num * 2] = true;
                }
            }
            cnt++;
        }
    }
}
