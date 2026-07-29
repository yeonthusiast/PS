import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = Integer.MAX_VALUE;
        // 최솟값 i가 [i, i+k]여야 하도록 하는 비용을 계산한다.
        for(int i=1;i<=10000;i++){
            int cost = 0;
            for(int j=0;j<n;j++){
                if(arr[j] >= i && arr[j] <= i+k) continue;
                else if(arr[j] < i){
                    cost += (i - arr[j]);
                }
                else if(arr[j] > i+k){
                    cost += (arr[j]-(i+k));
                }
            }
            result = Math.min(cost, result);
        }

        System.out.println(result);
    }
}