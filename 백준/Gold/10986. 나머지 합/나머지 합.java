import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N];
        long[] C = new long[M];
        long result = 0;

        st = new StringTokenizer(br.readLine());
        S[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N; i++){
            int value = (int)(S[i] % M);
            if(value==0)
                result++;
            C[value]++;
        }

        for(int i=0;i<M;i++){
            if(C[i] > 1){
                result += (C[i] * (C[i]-1) / 2);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}