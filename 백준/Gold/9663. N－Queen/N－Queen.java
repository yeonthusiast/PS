import java.io.*;

public class Main{
    static int[] A;
    static int N;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        backtracking(0);
        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
    private static void backtracking(int row){
        if(row == N){
            result++;
            return;
        }
        for(int i=0;i<N;i++){
            A[row] = i;
            if(check(row)){
                backtracking(row+1);
            }
        }
        
    }
    private static boolean check(int row){
        for(int i=0;i<row;i++){
            if(A[i] == A[row]){
                return false;
            }
            if(Math.abs(row - i) == Math.abs(A[i] - A[row])){
                return false;
            }
        }
        return true;
    }
}