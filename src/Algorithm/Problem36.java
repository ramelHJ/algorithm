package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem36 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());
        int[] array = new int[num];

        str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < num; i++){
            array[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 1; i < num; i++){
            for(int j = i; j > 0; j--){
                if(array[j] > array[j - 1])
                    break;

                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = array[j];
            }
        }
    }

}
