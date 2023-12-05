class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] rcja = new int[4];
        int[] score = {0,3,2,1,0,-1,-2,-3};
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < survey.length; i++){
            String firstChar = survey[i].substring(0,1);
            if(firstChar.equals("R")) rcja[0] += score[choices[i]];
            else if(firstChar.equals("T")) rcja[0] -= score[choices[i]];
            else if(firstChar.equals("C")) rcja[1] += score[choices[i]];
            else if(firstChar.equals("F")) rcja[1] -= score[choices[i]];
            else if(firstChar.equals("J")) rcja[2] += score[choices[i]];
            else if(firstChar.equals("M")) rcja[2] -= score[choices[i]];
            else if(firstChar.equals("A")) rcja[3] += score[choices[i]];
            else if(firstChar.equals("N")) rcja[3] -= score[choices[i]];
        }
        
        if(rcja[0]<0) answer.append("T");
        else answer.append("R");
        
        if(rcja[1]<0) answer.append("F");
        else answer.append("C");
        
        if(rcja[2]<0) answer.append("M");
        else answer.append("J");
        
        if(rcja[3]<0) answer.append("N");
        else answer.append("A");
        
        return answer.toString();
    }
}