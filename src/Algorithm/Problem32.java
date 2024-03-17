package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem32 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(str.nextToken());
        int[] array = new int[count];

        str = new StringTokenizer(br.readLine());
        for(int i =0 ;i < count; i++){
            array[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 0; i < count; i++){
            int min = 101;
            int minIndex = -1;
            for(int j = i; j < count; j++){
                if(array[j] < min){
                    minIndex = j;
                    min = array[j];
                }
            }

            int tmp = array[i];
            array[i] = min;
            array[minIndex] = tmp;
        }

        String result = Arrays.toString(array).replace("[","").replace("]","").replace(",","");
        bw.write(result);
        bw.flush();
    }
}
