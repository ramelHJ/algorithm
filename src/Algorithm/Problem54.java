package Algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem54 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        String input = str.nextToken();

        //Stack 이용
        Stack<String> stack = new Stack<>();
        for(int i = 0; i< input.length(); i++){
            char inputChar = input.charAt(i);
            if(input.charAt(i) == '(')
                stack.push(input);
            else
                stack.pop();
        }
        if(stack.empty())
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
