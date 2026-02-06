import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static boolean[] V;
    static int[] S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new int[N];
        V = new boolean[N];
        backtracking(0);

        br.close();
        bw.flush();
        bw.close();
    }
    private static void backtracking(int length){
        if(length == M){
            for(int i=0;i<M;i++){
                System.out.print(S[i] + 1 + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<N;i++){
            if(!V[i]){
                V[i] = true;
                S[length] = i;
                backtracking(length + 1);
                V[i] = false;
            }
        }
    }
}