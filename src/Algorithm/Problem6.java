package Algorithm;

public class Problem6 {
    public static void Problem(){
        String str = "g0en2Ts8eSoft";
        //정규표현식으로 추출
        int intStr = Integer.valueOf(str.replaceAll("[^0-9]", ""));

        //아스키 코드를 이용해서 추출
        int ASCIIResult = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(48 <= ch && ch <= 57){
                ASCIIResult *= 10;
                ASCIIResult += Character.getNumericValue(ch);
            }
        }

        System.out.println(intStr);
        System.out.println(ASCIIResult);
    }
}
