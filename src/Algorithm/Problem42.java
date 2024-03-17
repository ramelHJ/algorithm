package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem42 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int numCount = Integer.valueOf(str.nextToken());
        int inputNum = Integer.valueOf(str.nextToken());

        int[] array = new int[numCount];

        str = new StringTokenizer(br.readLine());
        for(int i =0; i < numCount; i++){
            array[i] = Integer.valueOf(str.nextToken());
        }

        for(int i = 1; i < numCount; i++){
            for(int j = i; j >0; j--){
                if(array[j] < array[j-1])
                {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
                else
                    break;
            }
        }

        int end = numCount;
        int start = 0;
        //이분검색
        while(true){
            int point = (start + end) / 2;
            if(array[point] == inputNum){
                bw.write(String.valueOf(point + 1));
                bw.flush();
                break;
            }
            else if (array[point] > inputNum) {
                end = point;
            }
            else
                start = point;

        }

    }
}
