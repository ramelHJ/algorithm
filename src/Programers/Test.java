package Programers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



class Test{
    public static void main(String[] args) throws Exception{
        int low = 25;
        int high = 51;
        String[] img = {".########......", ".####...#......",
        ".#.####.#.#####", ".#.#..#.#.#..##",
        ".#.##.#.#.#...#", ".#.####.#.#...#",
        ".#....###.#####", ".########......"};

        Test1 aaa = new Test1();
        int a = aaa.solution(low,high, img);
        System.out.println(a);
    }

    static class Solution {
        public static class Data{
            int year;
            int month;
            int day;

            public Data(String date, int addMonth){
                year = Integer.parseInt(date.substring(0,4));
                month = Integer.parseInt(date.substring(5,7));
                day = Integer.parseInt(date.substring(8,10));

                month += addMonth;

                while(month > 12){
                    month -= 12;
                    year++;
                }
            }

            public boolean compare(Data today){
                if(this.year < today.year)
                    return true;
                else if(this.year > today.year)
                    return false;

                if(this.month < today.month)
                    return true;
                else if(this.month > today.month)
                    return false;

                if(this.day <= today.day)
                    return true;
                else
                    return false;
            }
        }


        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answer = new ArrayList<>();

            Data dataToday = new Data(today,0);
            for(int i =0 ; i < privacies.length; i++){
                String date = privacies[i].substring(0,10);
                String type = privacies[i].substring(11,12);
                int addMonth = getTypeMonth(terms, type);


                Data dataPri = new Data(date,addMonth);
                if(dataPri.compare(dataToday))
                    answer.add(i + 1);
            }

            int[] array = new int[answer.size()];
            for(int i = 0 ; i < answer.size(); i++){
                array[i] = answer.get(i);
            }
            return array;
        }

        private int getTypeMonth(String[] terms, String type) {
            for (String term : terms) {
                String termType = term.substring(0, 1);

                if (termType.equals(type))
                    return Integer.parseInt(term.substring(2));
            }

            return 0;
        }

    }
}
