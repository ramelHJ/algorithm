package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class sa1254 {
    static String str;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        int num = str.length();

        for(int i = 0; i < num; i++){
            if(checkPalindrome(str.substring(i))){
                break;
            }
            num++;
        }

        bw.write(String.valueOf(num));
        bw.flush();
    }

    private static boolean checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}
