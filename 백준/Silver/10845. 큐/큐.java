import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st;
        int back = -1;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    back = num;
                    q.add(num);
                    break;
                case "pop":
                    if(q.size() == 0)
                        bw.write(-1 + "\n");
                    else
                        bw.write(q.poll() + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    if(q.size() == 0)
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;
                case "front":
                    if(q.size() == 0)
                        bw.write(-1 + "\n");
                    else
                        bw.write(q.peek() + "\n");
                    break;
                case "back":
                    if(q.size() == 0)
                        bw.write(-1 + "\n");
                    else
                        bw.write(back + "\n");
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}