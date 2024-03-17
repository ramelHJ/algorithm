package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem61 {
    static int count = 0;
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int count = Integer.valueOf(str.nextToken());
        int num = Integer.parseInt(str.nextToken());
        int[] array = new int[count];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++){
            array[i] = Integer.valueOf(str.nextToken());
        }

        SumDFS(0,0,count,num, array);
        if(count == 0)
            bw.write("-1");
        else
            bw.write(String.valueOf(count));

        bw.flush();
    }

    private static void SumDFS(int index, int partSum, int numCount, int num, int[] array) {
        if(partSum == num)
            count++;

        for(int i = index; i < numCount; i++){
            SumDFS(i + 1, partSum + array[i], numCount, num, array);
            SumDFS(i + 1, partSum - array[i], numCount, num, array);
        }
    }
}
