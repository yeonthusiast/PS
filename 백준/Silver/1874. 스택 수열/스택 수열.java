import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int p = 0;
        boolean can = true;
        Stack<Integer> s = new Stack<>();
        for(int i=1;i<=n;i++){
            s.push(i);
            sb.append("+\n");
            while(!s.empty() && s.peek() == A[p]){
                s.pop();
                sb.append("-\n");
                p++;
            }
            if(!s.empty() && s.peek() > A[p]){
                bw.write("NO");
                can = false;
                break;
            }
        }

        if(can)
            bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}