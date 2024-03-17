package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem45 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int prince = Integer.parseInt(str.nextToken());
        int exceptNum = Integer.parseInt(str.nextToken());

        boolean[] outCheck = new boolean[prince];

        int lastNum = 0;
        for(int i = 1; i < prince; i++){
            for(int j = 0; j < exceptNum; j++){
                while(true){
                    if(outCheck[lastNum]){
                        lastNum = (lastNum + 1) % prince;
                    }
                    else{
                        if(j == exceptNum - 1){
                            outCheck[lastNum] = true;
                        }
                        else
                            lastNum = (lastNum + 1) % prince;
                        break;
                    }
                }

            }
        }

        for(int i = 0; i < prince; i++){
            if(!outCheck[i])
                bw.write(String.valueOf(i + 1));
        }
        bw.flush();
    }
}
