package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class sa22942 {
    static int N;
    static List<Circle> circle;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        circle = new ArrayList<>();

        for(int i = 0 ; i < N; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int r = Integer.valueOf(str.nextToken());
            if(checkCircle(x - r, x + r)) System.out.println(1);
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    private static boolean checkCircle(int left, int right) {
         int start = 0;
         int end = circle.size();

         while(start < end){
             int mid = (start + end) / 2;
             Circle c = circle.get(mid);

         }

         circle.add(start, new Circle(left, right));
         return true;
    }

    public static class Circle{
        int left;
        int right;
        public Circle(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
