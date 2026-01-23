import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] coord = new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coord[i][0] = x;
            coord[i][1] = y;
        }

        Arrays.sort(coord, (e1, e2) -> {
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }
            else{
                return e1[0] - e2[0];
            }
        });

        for(int i=0; i<N; i++){
            bw.write(coord[i][0] + " " + coord[i][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}