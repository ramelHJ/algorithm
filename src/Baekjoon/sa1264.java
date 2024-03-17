package Baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1264 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean stop = false;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int length = 0;
            int count = st.countTokens();
            for(int i = 0; i < count; i++){
                String stToken = st.nextToken().toLowerCase();
                if(stToken.equals("#")) {
                    stop = true;
                }
                else{
                    for(int j = 0 ; j < stToken.length(); j++){
                                    if(stToken.charAt(j) == 'a' ||
                                            stToken.charAt(j) == 'e' ||
                                            stToken.charAt(j) == 'i' ||
                                            stToken.charAt(j) == 'o' ||
                                            stToken.charAt(j) == 'u')
                                        length++;
                    }
                }
            }

            if(stop)
                break;

            bw.write(String.valueOf(length));
            bw.newLine();
        }
        bw.flush();
    }
}
