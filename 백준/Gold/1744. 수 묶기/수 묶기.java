import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        int zero = 0;
        int one = 0;

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num < 0){
                minusQ.add(num);
            }
            else if(num > 0){
                if(num == 1)
                    one++;
                else
                    plusQ.add(num);
            }
            else if(num == 0){
                zero++;
            }
        }

        long sum = 0;
        int d1 = 0;
        int d2 = 0;

        while(minusQ.size() > 1){
            d1 = minusQ.remove();
            d2 = minusQ.remove();
            sum += d1*d2;
        }
        if(minusQ.size() != 0){
            if(zero == 0)
                sum += minusQ.remove();
        }

        while(plusQ.size() > 1){
            d1 = plusQ.remove();
            d2 = plusQ.remove();
            sum += d1*d2;
        }
        if(plusQ.size() != 0){
            sum += plusQ.remove();
        }

        sum += one;

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}