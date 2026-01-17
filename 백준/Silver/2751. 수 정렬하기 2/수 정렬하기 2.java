import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static int[] A, tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        A = new int[N+1];
        tmp = new int[N+1];

        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N);

        for(int i = 1; i <= N; i++){
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mergeSort(int s, int e){
        if(e -s < 1)
            return;
        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);
        for(int i=s;i<=e;i++){
            tmp[i] = A[i];
        }
        int k = s;
        int idx1 = s;
        int idx2 = m + 1;

        while(idx1 <= m && idx2 <= e){
            if(tmp[idx1] > tmp[idx2]){
                A[k] = tmp[idx2];
                k++;
                idx2++;
            }
            else {
                A[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }

        while(idx1 <= m){
            A[k] = tmp[idx1];
            k++;
            idx1++;
        }

        while(idx2 <= e){
            A[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}