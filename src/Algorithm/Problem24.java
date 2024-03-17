package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem24 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int count = Integer.valueOf(str.nextToken());
        int[] array = new int[count];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++){
            array[i] = Integer.valueOf(str.nextToken());
        }

        int[] minus = new int[count];
        for(int i = 1 ; i < count - 1; i++){
            int preAbs = Math.abs(array[i] - array[i - 1]);
            if(preAbs < count)
                minus[preAbs]++;

            int nextAbs = Math.abs(array[i + 1] - array[i]);
            if(nextAbs < count)
                minus[nextAbs]++;
        }
        String result = "YES";
        for(int i = 1; i < count; i++){
            if(minus[i] == 0)
                result = "NO";
        }

        bw.write(result);
        bw.flush();
    }
}
