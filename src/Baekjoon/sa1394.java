package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1394 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        String inputData = str.nextToken();
        str = new StringTokenizer(br.readLine());
        String pw = str.nextToken();

        int inputDataLength = inputData.length();
        int pwLength = pw.length();

        //각각 자리수 -1 까지의 값(3자리면 2자리까지 구함)
        int result = 1;
        int digit = 1;
        for(int i= 1; i < pwLength; i++){
            result += digit;
            result %= 900528;
            digit *= inputDataLength;
        }

        //해당하는 자리수의 값 구하기
        int multi = 1;
        for(int i = pwLength - 1; i >= 0; i--){
            for(int j = 0 ; j < inputDataLength; j++){
                if(inputData.charAt(j) == pw.charAt(i)){
                    result += j * multi;
                    result %= 900528;
                    multi *= inputDataLength;
                    break;
                }
            }
        }

        bw.write(String.valueOf((result)%900528));
        bw.newLine();
        bw.flush();
    }
}
