package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("HJ");
        bw.newLine();
        bw.write("HJ");
        bw.newLine();
        bw.write("HJ");
        bw.newLine();


        bw.write("for문");
        bw.newLine();

        for(int i =0; i < 3; i++){
            bw.write("HJ");
            bw.newLine();
        }
        bw.flush();


        //Problem52.Problem();
    }

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
    }
}
