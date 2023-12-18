import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    static Stack<String> stack1;
    static Stack<String> stack2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stack1 = new Stack<>();
        stack2 = new Stack<>();
        for(String s : br.readLine().split("")) stack1.push(s);
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            command(br.readLine());
        }

        while (!stack2.isEmpty()) stack1.push(stack2.pop());
        bw.write(String.join("", stack1));
        bw.flush();
    }

    public static void command(String command){
        if(command.equals("L")){
            if(!stack1.isEmpty()) stack2.push(stack1.pop());
        }else if(command.equals("D")){
            if(!stack2.isEmpty()) stack1.push(stack2.pop());
        }else if(command.equals("B")){
            if(!stack1.isEmpty()) {
                stack1.pop();
            }
        }else {
            String character = command.split(" ")[1];
            stack1.push(character);
        }
    }

}
