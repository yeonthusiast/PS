import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 거리의 최댓값 사이에 새로운 사람을 앉힌다.
        // 가장 가까운 거리는 원래부터 가까웠거나, 앉혀서 줄어든 거리 중 하나다.
        // 1/2가 가장 가까운 거리보다 큰지 작은지를 구한다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] drr = new int[n];
        String s = sc.next();
        for(int i=0;i<n;i++){
            arr[i] = s.charAt(i) - 48;
            drr[i] = -1;
        }
        int dcnt = 0;
        int d = n-1;
        int sIdx = 0;
        int eIdx = n-1;
        for(int i=1;i<n;i++){
            if(arr[i] == 1){
                eIdx = i;
                drr[dcnt] = eIdx-sIdx;
                dcnt++;
                sIdx = i;
            }
        }

        Arrays.sort(drr, 0, dcnt);
        // drr의 0이 최솟값, dcnt-1이 최댓값
        int newD = drr[dcnt-1]/2;
        if(newD > drr[0]){
            System.out.println(drr[0]);
        }
        else{
            System.out.println(newD);
        }

        
    }
}