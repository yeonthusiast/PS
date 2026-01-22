import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    s.push(n);
                    break;
                case "pop":
                    if(!s.empty()){
                        bw.write(s.pop() + "\n");
                    }
                    else
                        bw.write(-1 + "\n");
                    break;
                case "size":
                    bw.write(s.size() + "\n");
                    break;
                case "empty":
                    if(!s.empty()){
                        bw.write(0 + "\n");
                    }
                    else
                        bw.write(1 + "\n");
                    break;
                case "top":
                    if(!s.empty()){
                        bw.write(s.peek() + "\n");
                    }
                    else
                        bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}