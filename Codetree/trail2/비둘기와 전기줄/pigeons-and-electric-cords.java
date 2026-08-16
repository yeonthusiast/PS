import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        int[] x = new int[n];
        for(int i=0;i<n;i++){
            p[i] = sc.nextInt();
            x[i] = sc.nextInt();
        }
        int sum = 0;
        // 비둘기마다 건넌 횟수 세기(1~10번)
        for(int i=1;i<=10;i++){
            int cnt = 0;
            int prev = -1;
            for(int j=0;j<n;j++){
                if(p[j] == i){
                    if(prev == -1){
                        prev = x[j];
                    }
                    else if(prev != x[j]){
                        cnt++;
                        prev = x[j];
                    }
                }
            }
            sum += cnt;
        }
        System.out.println(sum);
    }
}