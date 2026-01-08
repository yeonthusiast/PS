import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        s.push(0);

        int[] result = new int[N];

        for(int i=1;i<N;i++){
            while(!s.empty() && A[s.peek()] < A[i]){
                result[s.pop()] = A[i];
            }
            s.push(i);
        }

        while(!s.empty()){
            result[s.pop()] = -1;
        }

        for(int i=0;i<N;i++){
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}