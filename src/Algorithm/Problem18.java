package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem18 {
    public static void Problem() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(str.nextToken());
        int value = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());
        int max = -1;
        int conti = 0;
        for(int i = 0 ; i < time; i++){
            int now = Integer.parseInt(str.nextToken());
            if(now > value){
                conti++;
                if(conti > max)
                    max = conti;
            }
            else{
                conti = 0;
            }
        }
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.flush();
    }
}
