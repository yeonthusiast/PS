import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;

        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(st.nextToken());
            if(max<score[i])
                max = score[i];
        }

        long sum = 0;
        for(int i=0; i<N; i++){
            sum += score[i];
        }

        double mean = sum * 100.0 / max / N;
        bw.write(String.valueOf(mean));
        bw.flush();
    }
}