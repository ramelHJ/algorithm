package 쇼미더코드;

import java.io.*;
import java.util.*;

public class test1 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        for(int i = 0; i < N; i++){
            setStack(true, i, left);
            setStack(false, i, right);

            max = Math.max(max, left.size());
            max = Math.max(max, right.size());
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    public static void setStack(boolean isLeft, int index, Stack<Integer> stack){
        int num = isLeft == true ? 1 : 2;

        if(arr[index] == num){
            stack.add(num);
        }
        else{
            if(stack.isEmpty()) return;
            stack.pop();
        }
    }
}
