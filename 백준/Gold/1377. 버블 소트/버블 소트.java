import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        for(int i=0;i<N;i++){
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);
        int max = 0;
        for(int i=0;i<N;i++){
            if(max < A[i].index - i){
                max = A[i].index - i;
            }
        }
        bw.write(max+1 + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static class mData implements Comparable<mData>{
        int value;
        int index;

        public mData(int value, int index){
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o){
            return this.value - o.value;
        }
    }
}