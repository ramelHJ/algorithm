package Algorithm;

import jdk.jshell.execution.DirectExecutionControl;

import java.io.*;
import java.util.StringTokenizer;

public class Problem46 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int workCount = Integer.parseInt(str.nextToken());
        int[] work = new int[workCount];
        for(int i =0; i < workCount; i++){
            str = new StringTokenizer(br.readLine());
            work[i] = Integer.parseInt(str.nextToken());
        }
        str = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(str.nextToken());

        int decreaseIndex = 0;
        for(int i =0; i <= time; i++){
            //전부 0 인지 체크
            if(CheckAllZero(work)){
                bw.write("-1");
                bw.flush();
                return;
            }

            while(true){
                if(work[decreaseIndex] != 0){
                    work[decreaseIndex]--;
                    break;
                }

                decreaseIndex = (decreaseIndex + 1) % workCount;
            }

            if(i != time)
                decreaseIndex = (decreaseIndex + 1) % workCount;

        }

        bw.write(String.valueOf(decreaseIndex + 1));
        bw.flush();
    }

    public static boolean CheckAllZero(int[] array){
        for(int i = 0 ; i < array.length; i++){
            if(array[i] > 0)
                return false;
        }
        return true;
    }
}
