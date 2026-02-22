import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;
        long ans = 0;

        while(start <= end){
            long mid = (start+end)/2;
            long count = 0;
            for(int i=1;i<=N;i++){
                count += Math.min(mid / i, N);
            }
            if(count < k){
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid - 1;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}