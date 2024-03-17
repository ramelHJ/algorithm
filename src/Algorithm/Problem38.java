package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem38 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int size = Integer.valueOf(str.nextToken());
        int[] array = new int[size];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            int bigCount = Integer.valueOf(str.nextToken());
            int zeroCount = 0;

            for(int j = 0; j < size; j++){
                if(array[j] == 0){
                    if(zeroCount == bigCount) {
                        array[j] = i + 1;
                        break;
                    }
                    zeroCount++;

                }
            }
        }

        String result = Arrays.toString(array).replace("[","").replace("]","").replace(",","");
        bw.write(result);
        bw.flush();
    }
}
