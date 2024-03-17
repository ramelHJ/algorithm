package Algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem55 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str.nextToken());

        int[] array = new int[num];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(str.nextToken());
        }

        Stack<Integer> crossWay = new Stack<>();
        int start = 1;
        String result = "";
        for(int i = 0; i < num; i++){
            crossWay.push(array[i]);
            result += "P";

            while(true){
                if(!crossWay.empty() && crossWay.peek() == start)
                {
                    crossWay.pop();
                    result += "O";
                    start++;
                }
                else
                    break;
            }
        }
        bw.write(result);
        bw.flush();
    }
}
