import java.io.*;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<N-1;i++){
            for(int j=0;j<N-i-1;j++){
                if(num[j] > num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }

        for(int i=0;i<N;i++){
            bw.write(num[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}