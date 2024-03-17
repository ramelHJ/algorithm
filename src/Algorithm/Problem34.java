package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem34 {
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


        for(int i = 0 ; i < num; i++){
            for(int j = i; j >= 1; j--){
                if(array[j - 1] > array[j]){
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        String result = Arrays.toString(array).replace("[","").replace("]","").replace(",","");
        bw.write(result);
        bw.flush();
    }
}
