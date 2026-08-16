import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for(int i=0;i<n;i++){
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        boolean isExist = false;
        for(int i=1;i<=100;i++){
            // i는 x값, j를 하나씩 빼본다.
            for(int j=0;j<n;j++){
                int cnt = 0;
                for(int k=0;k<n;k++){
                    if(k == j) continue;
                    if(x1[k] <= i && x2[k] >= i) cnt++;
                }
                if(cnt == n-1){
                    isExist = true;
                    System.out.println("Yes");
                    break;
                }
            }
            if(isExist) break;
        }
        if(!isExist) System.out.println("No");
    }
}