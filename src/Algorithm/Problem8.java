package Algorithm;

import java.util.Stack;

public class Problem8 {
    public static void Problem(){
        String input = "()()(()())";

        //카운트 세기
        int leftNum = 0;
        int rightNum = 0;
        for(int i = 0 ; i < input.length(); i++){
            if(input.charAt(i) == '(')
                leftNum++;
            else
                rightNum++;
        }
        if(leftNum == rightNum)
            System.out.println("YES");
        else
            System.out.println("NO");

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
