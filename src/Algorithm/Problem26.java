package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem26 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());
        int[] ability = new int[num];
        int[] award = new int[num];
        for(int i =0; i < num; i++){
            ability[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = num - 1; i >=0 ;i--){
            award[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(ability[i] < ability[j])
                    award[i]++;
            }
        }

        String result = Arrays.toString(award).replace("[","").replace("]","").replace(",","");
        bw.write(result);
        bw.flush();
    }
}
