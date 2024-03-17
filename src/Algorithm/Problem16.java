package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        String firstInput = str.nextToken();
        str = new StringTokenizer(br.readLine());
        String secondInput = str.nextToken();
        String result = "YES";
        int[] firstInputArray = new int[128];
        for(int i =0 ; i< firstInput.length(); i++){
            firstInputArray[firstInput.charAt(i)]++;
        }
        for(int i =0 ; i< secondInput.length(); i++){
            firstInputArray[secondInput.charAt(i)]--;
        }

        for(int i = 0 ; i < firstInputArray.length; i++){
            if(firstInputArray[i] != 0)
            {
                result = "NO";
                break;
            }
        }

        bw.write(result);
        bw.newLine();
        bw.flush();
    }

}
