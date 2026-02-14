import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[][] A = new int[10][10];
    static int[] stock = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        if(result == Integer.MAX_VALUE){
            bw.write(-1 + "\n");
        }
        else{
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    private static void backtracking(int xy, int count){
        if(xy == 100){
            result = Math.min(count, result);
            return;
        }
        int x = xy % 10;
        int y = xy / 10;

        if(result <= count) return;
        if(A[y][x] == 1){
            for(int i=5;i>0;i--){
                if(stock[i] > 0 && check(x,y,i)){
                    stock[i]--;
                    fill(x,y,i,0);
                    backtracking(xy+1, count+1);
                    stock[i]++;
                    fill(x,y,i,1);
                }
            }
        }
        else{
            backtracking(xy+1, count);
        }
    }
    static void fill(int x, int y, int size, int num){
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                A[i][j] = num;
            }
        }
    }
    static boolean check(int x, int y, int size){
        if(x+size>10 || y+size>10) return false;
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(A[i][j]!=1) return false;
            }
        }
        return true;
    }
}