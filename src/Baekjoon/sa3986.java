package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class sa3986 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int count = 0;
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < s.length(); j++){
                if(stack.isEmpty() || stack.peek() != s.charAt(j)) stack.push(s.charAt(j));
                else stack.pop();
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
