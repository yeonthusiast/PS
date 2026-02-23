import java.io.*;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        int d1 = 0;
        int d2 = 0;

        while(q.size() != 1){
            d1 = q.remove();
            d2 = q.remove();
            sum += d1 + d2;
            q.add(d1 + d2);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}