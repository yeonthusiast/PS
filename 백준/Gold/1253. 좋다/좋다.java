import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int count = 0;

        for(int k=0;k<N;k++){
            int i=0;
            int j=N-1;

            while(i<j){
                if(i==k){
                    i++;
                }
                else if(j==k){
                    j--;
                }
                else if(A[i] + A[j] < A[k]){
                    i++;
                }
                else if(A[i] + A[j] > A[k]){
                    j--;
                }
                else{
                    count++;
                    break;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}