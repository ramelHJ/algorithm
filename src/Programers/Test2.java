package Programers;

import java.util.List;
import java.util.ArrayList;

/*
    1번 조건 : 더 많은 완주를 한사람이 순위가 높음
    2번 조건 : 더 어려운 코스를 완주한 사람의 순위가 높음
    3번 조건 : 금메달 수 -> 은메달 수 -> 동메달 수
    4번 조건 : 완주시간의 합을 따짐
    5번 조건 : 이름이 빠른 순
 */
class Test2 {

    class Rank{
        String name;
        int course1;
        int course2;
        int course3;
        int course4;
        int course5;

        int completeCount;
        int order;

        int gold;
        int silver;
        int bronze;
        public Rank(String name, int c1, int c2, int c3, int c4, int c5){
            this.name = name;
            this.course1 = c1;
            this.course2 = c2;
            this.course3 = c3;
            this.course4 = c4;
            this.course5 = c5;
            countComplete();
        }

        private void countComplete(){
            if(course1 > 0)
                completeCount++;
            if(course2 > 0)
                completeCount++;
            if(course3 > 0)
                completeCount++;
            if(course4 > 0)
                completeCount++;
            if(course5 > 0)
                completeCount++;
        }

        public int getCourse(int num){
            if(num == 5)
                return course5;
            if(num == 4)
                return course4;
            if(num == 3)
                return course3;
            if(num == 2)
                return course2;
            if(num == 1)
                return course1;

            return 0;
        }
    }

    public String[] solution(String[] record) {
        String[] answer = {};
        int[] countCourse = new int[6];

        List<Rank> ranks = new ArrayList<>();
        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(":");
            String[] r = info[1].split(",");
            Rank rank = new Rank(info[0], Integer.valueOf(r[0]), Integer.valueOf(r[1]), Integer.valueOf(r[2]), Integer.valueOf(r[3]), Integer.valueOf(r[4]));
            ranks.add(rank);
            if(rank.course1 != 0)
                countCourse[1]++;
            if(rank.course2 != 0)
                countCourse[2]++;
            if(rank.course3 != 0)
                countCourse[3]++;
            if(rank.course4 != 0)
                countCourse[4]++;
            if(rank.course5 != 0)
                countCourse[5]++;
        }
        
         countMedal(countCourse, ranks);
        
        int order = 1;
        for(int i = 5; i > 0; i--){
            List<Rank> target = courseCompleteCount(i, ranks);
            //코스 별로 나누기
            for(int j = 5; j > 0; j--){
                List<Rank> target2 = courseComplete(j, target);
                //메달 수 따지기
            }



        }


        return answer;
    }

    private void countMedal(int[] countCourse, List<Rank> ranks) {
        

        for(int i = 1; i <= 5; i++){

        }



    }

    private List<Rank> courseComplete(int course, List<Rank> target) {
        List<Rank> result = new ArrayList<>();
        for(Rank r : target){
            if(r.getCourse(course) != 0)
                result.add(r);
        }
        return result;
    }

    private List<Rank> courseCompleteCount(int completeCount, List<Rank> ranks){
        List<Rank> result = new ArrayList<>();
        for(Rank r : ranks){
            if(r.completeCount == completeCount)
                result.add(r);
        }
        return result;
    }
}
