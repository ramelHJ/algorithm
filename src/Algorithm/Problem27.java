package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem27 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());
        int[] prime = new int[num + 1];
        for(int i = 2; i <= num; i++){
            int selectNum = i;
            int primeNum = 2;

            while(true){
                if(selectNum % primeNum == 0)
                {
                    selectNum /= primeNum;
                    prime[primeNum]++;
                }
                else
                    primeNum++;

                if(selectNum == 1)
                    break;
            }
        }

        String result = String.valueOf(num) + "! = ";
        for(int i = 2; i <= num; i++){
            if(prime[i] != 0)
                result += String.valueOf(prime[i]) + " ";
        }

        bw.write(result);
        bw.flush();
    }

}
