import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            Stack<Character> s = new Stack<>();
            String input = br.readLine();
            char[] data = input.toCharArray();
            boolean vps = true;

            for(int j=0;j<data.length;j++){
                if(data[j] == '('){
                    s.push(data[j]);
                }
                else{
                    if(!s.empty()){
                        s.pop();
                    }
                    else{
                        bw.write("NO\n");
                        vps = false;
                        break;
                    }
                }
            }
            if(!s.empty()){
                bw.write("NO\n");
            }
            else if(s.empty() && vps){
                bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}