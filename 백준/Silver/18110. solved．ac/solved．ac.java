import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int ex = (int)Math.round(N*0.15);
        int[] A = new int[N];

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int result = 0;
        for(int i=ex;i<N-ex;i++){
            result += A[i];
        }

        if(N!=0){
            result = (int)Math.round((double)result/(N-(2*ex)));
        }

        bw.write(result+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
}