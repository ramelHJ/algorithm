package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem31 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        String CH = str.nextToken();

        boolean ahead = true;
        int tansoNum = 0;
        int susoNum = 0;
        for(int i = 1; i < CH.length(); i++){
            if(CH.charAt(i) == 'H'){
                ahead = false;
                continue;
            }

            if(ahead){
                tansoNum *= 10;
                tansoNum += Character.getNumericValue(CH.charAt(i));
            }
            else{
                susoNum *= 10;
                susoNum += Character.getNumericValue(CH.charAt(i));
            }
        }

        if(tansoNum == 0)
            tansoNum = 1;
        if(susoNum == 0)
            susoNum = 1;

        int result = 12 * tansoNum + susoNum;

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
