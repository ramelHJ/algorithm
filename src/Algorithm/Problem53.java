package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem53 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str.nextToken());
        int change = Integer.parseInt(str.nextToken());

        String result = "";

        while(true){
            if(num < change)
                break;

            int remainder = num % change;
            if(remainder >= 10)
            {
                char add = (char)('A' + remainder - 10);
                result += add;
            }
            else
                result += String.valueOf(num % change);

            num /= change;
        }

        if(num >= 10)
        {
            char add = (char)('A' + num - 10);
            result += add;
        }
        else
            result += String.valueOf(num % change);

        String output = "";
        for(int i =result.length() - 1; i >= 0; i--){
            output += result.charAt(i);
        }
        bw.write(output);
        bw.flush();
    }
}
