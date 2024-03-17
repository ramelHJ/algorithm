package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem41 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str.nextToken());
        int count = 0;
        for(int i = num / 2; i > 0; i--){
            int sum = i;
            for(int j = i + 1; j < num; j++){
                sum += j;

                if(sum > num)
                    break;
                else if(sum == num){
                    String output = "";
                    for(int k = i; k <=j; k++){
                        output += String.valueOf(k) + " ";
                        if(k != j)
                            output += "+ ";
                    }
                    output += "= " + String.valueOf(num);

                    bw.write(output);
                    bw.newLine();
                    count++;
                    break;
                }
            }

        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
