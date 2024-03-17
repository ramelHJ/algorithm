package Algorithm;

import java.io.*;
import java.util.Arrays;

public class Problem15 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[num + 1];
        for(int i = 2; i * i <= num; i++){
            if(!check[i]){
                for(int j = i * i; j <= num; j += i)
                    check[j] = true;
            }
        }

        int result = 0;

        for(int i = 2; i <= num; i++){
            if(!check[i])
                result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}
