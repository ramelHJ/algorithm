package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sa15081 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(str.nextToken());
        List<String> wordList = new ArrayList<String>();
        for(int i =0; i < count; i++) {
            str = new StringTokenizer(br.readLine());
            int wordCount = Integer.parseInt(str.nextToken());

            for(int j = 0; j < wordCount; j++){
                String selectWord = str.nextToken();
                if(!wordList.contains(selectWord)) {
                    wordList.add((selectWord));
                    break;
                }
            }
        }
        
        String output = "";
        for(String w : wordList){
            output += w + " ";
        }

        bw.write(output);
        bw.newLine();
        bw.flush();
    }
}
