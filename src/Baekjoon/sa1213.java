package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1213 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = new int[26];
        StringTokenizer str = new StringTokenizer(br.readLine());
        String name = str.nextToken();
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            array[c - 'A']++;
        }

        String result = "";
        int evenNum = 0;
        char lastChar = 'A';
        for(int i = 0; i < 26; i++){
            if(array[i] % 2 == 1) {
                evenNum++;
                lastChar = (char)(i + 'A');
            }

            int oddNum = array[i] / 2;
            for(int j = 0; j < oddNum; j++){
                result += (char)(i + 'A');
            }
        }

        if(evenNum > 1)
            result = "I'm Sorry Hansoo";
        else
        {
            String behindString = "";
            for(int i = result.length() - 1; i >=0 ; i--){
                behindString += result.charAt(i);
            }

            if(evenNum == 1)
                result += lastChar;

            result += behindString;
        }

        bw.write(result);
        bw.flush();
    }
}
