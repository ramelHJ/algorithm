package Algorithm;

import java.io.*;
import java.util.*;

public class Problem40 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int firstSize = Integer.valueOf(str.nextToken());
        List<Integer> firstArray = new ArrayList<Integer>();

        str = new StringTokenizer(br.readLine());
        for(int i =0 ; i < firstSize; i++){
            firstArray.add(Integer.valueOf(str.nextToken()));
        }
        str = new StringTokenizer(br.readLine());
        int secondSize = Integer.valueOf(str.nextToken());
        List<Integer> secondArray = new ArrayList<Integer>();

        str = new StringTokenizer(br.readLine());
        for(int i =0 ; i < secondSize; i++){
            secondArray.add(Integer.valueOf(str.nextToken()));
        }

        firstArray.retainAll(secondArray);
        firstArray.sort(Comparator.naturalOrder());

        String result = firstArray.toString().replace("[","").replace("]","").replace(",","");
        bw.write(result);
        bw.flush();

    }
}
