import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        Arrays.sort(arr);
        int cnt = 0;
        // 이동할 땐 무조건 사이로 간다.
        // 0, 1, 2 중 하나임
        while(true){
            // 거리가 1이면 종료
            if(arr[0]+1==arr[1] && arr[1]+1==arr[2]) break;
            
            // 두 구간 거리를 구함
            int a = arr[1] - arr[0];
            int b = arr[2] - arr[1];

            // 이미 어떤 구간이 2면 그 사이로 넣고 종료
            if(a == 2){
                arr[2] = arr[0] + 1;
            }
            else if(b == 2){
                arr[0] = arr[1] + 1;
            }
            // 어떤 구간이 1이면 다른 구간 사이로 넣음
            else if(b == 1){
                arr[2] = arr[0] + 2;
            }
            else if(a == 1){
                arr[0] = arr[1] + 2;
            }
            // 둘 다 2 이상이면 더 작은 구간 사이로 넣음
            else if(a <= b){
                arr[2] = arr[0] + 2;
            }
            else if(a >= b){
                arr[0] = arr[1] + 2;
            }
            cnt++;
            Arrays.sort(arr);
        }
        System.out.println(cnt);
    }
}