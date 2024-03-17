package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1032 {
    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer str = new StringTokenizer(br.readLine());
    int fileCount = Integer.valueOf(str.nextToken());

    str = new StringTokenizer(br.readLine());
    String firstName = str.nextToken();
    int nameLength = firstName.length();

    for(int i = 2; i <= fileCount; i++)
    {
        str = new StringTokenizer(br.readLine());
        String selectedName = str.nextToken();
        for(int j = 0; j < nameLength; j++){
            if(firstName.charAt(j) != selectedName.charAt(j))
                firstName = firstName.substring(0,j) + '?' + firstName.substring(j + 1);
        }
    }

    bw.write(firstName);
    bw.newLine();
    bw.flush();
}
}
