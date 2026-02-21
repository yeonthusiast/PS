import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(start < A[i])
                start = A[i];
            end += A[i];
        }

        while(start <= end){
            int mid = (start+end)/2;
            int sum = 0;
            int count = 0;
            for(int i=0;i<N;i++){
                if(sum + A[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }
            if(sum != 0){
                count++;
            }
            
            if(count > M){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        bw.write(start + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}