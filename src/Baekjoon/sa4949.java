package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class sa4949 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        while(!input.equals(".")){
            Stack<Character> stack = new Stack<>();
            boolean result = true;
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if(c == '(' || c == '[') stack.push(c);
                else if(c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = false;
                        break;
                    }

                    stack.pop();
                }
                else if(c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = false;
                        break;
                    }

                    stack.pop();
                }
            }
            if(!stack.isEmpty()) result = false;

            if(result) bw.write("yes");
            else bw.write("no");

            bw.newLine();
            input = br.readLine();
        }
        bw.flush();
    }
}
