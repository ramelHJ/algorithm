package Algorithm;

public class Problem5 {
    public static void Problem(){
        String rrn = "780316-2376152";
        char rrnBackFirstNum = rrn.charAt(7);
        int rrnYearNum = Integer.valueOf(rrn.substring(0,2));
        String age = "0";
        char sex = 'M';

        switch(rrnBackFirstNum){
            case '1':
                sex = 'M';
                age = String.valueOf(120 - rrnYearNum);
                break;
            case '2':
                sex = 'W';
                age = String.valueOf(120 - rrnYearNum);
                break;
            case '3':
                sex = 'M';
                age = String.valueOf(20 - rrnYearNum);
                break;
            case '4':
                sex = 'W';
                age = String.valueOf(20 - rrnYearNum);
                break;
        }

        System.out.println(age + " " + sex);
    }
}
