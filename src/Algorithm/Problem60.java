package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem60 {
    static String result = "NO";
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(str.nextToken());
        int[] array = new int[num];
        str = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0; i < num; i++){
            array[i] = Integer.valueOf(str.nextToken());
            sum += array[i];
        }

        DFS(0, 0, array, sum, num);
        bw.write(result);
        bw.flush();
    }

    public static void DFS(int index, int partSum, int[] array, int sum, int num){
        if(partSum * 2 == sum)
        {
            result = "YES";
            return;
        }

        for(int i = index; i < num; i++){
            DFS(i + 1, partSum + array[i], array, sum , num);
        }
    }
}
