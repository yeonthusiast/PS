import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N;i++){
            int idx = i;
            int idxVal = P[i];
            for(int j=i-1;j>=0;j--){
                if(P[i] > P[j]){
                    idx = j+1;
                    break;
                }
                if(j==0){
                    idx = 0;
                }
            }
            for(int j=i;j>idx;j--){
                P[j] = P[j-1];
            }
            P[idx] = idxVal;
        }

        S[0] = P[0];
        int sum = S[0];
        for(int i=1;i<N;i++){
            S[i] = S[i-1] + P[i];
            sum += S[i];
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}