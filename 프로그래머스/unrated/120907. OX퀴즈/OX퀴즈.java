class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] strArr = quiz[i].split(" = ");
            int result = Integer.parseInt(strArr[1]);
            if(quiz[i].contains("+")){
                int first = Integer.parseInt(strArr[0].split(" \\+ ")[0]);
                int second = Integer.parseInt(strArr[0].split(" \\+ ")[1]);
                if(first + second == result) answer[i] = "O";
                else answer[i] = "X";
            }else{
                int first = Integer.parseInt(strArr[0].split(" - ")[0]);
                int second = Integer.parseInt(strArr[0].split(" - ")[1]);
                if(first - second == result) answer[i] = "O";
                else answer[i] = "X";
            }
        }
        return answer;
    }
}