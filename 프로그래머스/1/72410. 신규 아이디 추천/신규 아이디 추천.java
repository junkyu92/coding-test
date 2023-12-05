class Solution {
    public String solution(String new_id) {
        //1
        String answer = lower(new_id);
        
        //2
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        //3
        while(!answer.equals(answer.replace("..","."))){
            answer = answer.replace("..",".");
        }
        
        //4
        if(answer.length()>0){
            if(answer.substring(0,1).equals(".")) answer = answer.substring(1);
        }
        if(answer.length()>0){
            if(answer.substring(answer.length()-1, answer.length()).equals(".")) answer = answer.substring(0,answer.length()-1);
        }
        
        //5
        if(answer.equals("")) answer = "a";
        
        //6
        if(answer.length()>=16) answer = answer.substring(0,15);
        if(answer.substring(answer.length()-1, answer.length()).equals(".")) answer = answer.substring(0,answer.length()-1);
        
        //7
        if(answer.length()<=2) {
            String c = answer.substring(answer.length()-1, answer.length());
            while(answer.length()<3){
                answer += c;
            }
        }
            
        answer = answer.replace("..",".");
        return answer;
    }
    
    //1
    public String lower(String id){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < id.length(); i++){
            char c = id.charAt(i);
            if(c>=65 && c<=90) {
                c += 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }

}