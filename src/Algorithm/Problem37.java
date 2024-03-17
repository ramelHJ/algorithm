package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem37 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int size = Integer.valueOf(str.nextToken());
        int count = Integer.valueOf(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int[] cache = new int[size];

        for(int i = 0; i < count; i++){
            int value = Integer.parseInt(str.nextToken());
            //기존 값이 존재하지 않으면 마지막 것부터 정렬
            //기존 값이 존재하면 존재하는 것 까지 정렬
            //위의 조건을 위해서 만든 Index
            int sortingIndex = size - 1;
            //값이 있는지 체크
            for(int j = 0 ; j < size; j++){
                if(value == cache[j])
                    sortingIndex = j;
            }

            //값 정렬
            for(int j = sortingIndex; j > 0; j--){
                cache[j] = cache[j-1];
            }

            cache[0] = value;
        }
        String result = Arrays.toString(cache).replace("[","").replace("]","").replace(",","");
        bw.write(result);
        bw.flush();
    }
}
