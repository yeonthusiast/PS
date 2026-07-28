import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        int maxVal = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            maxVal = Math.max(maxVal, arr[i]);
        }
        // h 이상인 수의 개수가 h개 이상이도록 하는 수 h 중 최댓값
        //0~l개의 수를 1 올려서 만들 수 있음
        // h 수를 설정하고 반복문을 돌림. 큰 수부터 내려가기
        //h로 가능한 수는 수열의 최댓값+1부터.
        int max = 0;
        for(int i=maxVal+1;i>=0;i--){
           int h = i;
           // 0개~l개의 수를 +1할 수 있음을 모두 탐색해서, h 이상인 수가 h개 이상인지 찾는다.
           int hCnt = 0;
           int lCnt = l;
           for(int j=0;j<n;j++){
            if(arr[j] >= h) hCnt++;
            else if(arr[j] + 1 >= h && lCnt > 0){
                hCnt++;
                lCnt--;
            }
           }
           if(hCnt >= h){
            max = h;
            break;
           }
        }
        System.out.println(max);

    }
}