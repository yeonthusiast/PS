import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        String s = sc.next();
        for(int i=0;i<n;i++){
            arr[i] = s.charAt(i) - 48;
        }

        int sIdx = 0;
        int eIdx = n-1;
        int max = 0;
        // 1과 1 사이에 두는 경우
        for(int i=0;i<n;i++){
            if(arr[i] == 1){
                for(int j=i+1;j<n;j++){
                    if(arr[j] == 1){
                        if(max < j-i){
                            sIdx = i;
                            eIdx = j;
                            max = eIdx - sIdx;
                        }
                        break;
                    }
                }
            }
        }

        // max/2보다 아래가 크면 아래로 결정해야 함.
        // 시작점이 0이라서 시작점에 두는 경우
        int sd = 0;
        if(arr[0] == 0){
            for(int i=1;i<n;i++){
                if(arr[i] == 1){
                    if((max/2) < i){
                        sd = i;
                    }
                    break;
                }
            }
        }

        // 끝점이 0이라서 끝점에 두는 경우
        int ed = 0;
        if(arr[n-1] == 0){
            for(int i=n-2;i>=0;i--){
                if(arr[i] == 1){
                    if((max/2) < (n-1)-i){
                        ed = (n-1)-i;
                    }
                    break;
                }
            }
        }

        // 새로운 사람 배치
        // 1과 1 사이에 뒀을 때 거리와, 시작점, 끝점에 뒀을 때 거리 비교
        if(sd != 0 && sd >= ed){
            arr[0] = 1;
        }
        else if(sd < ed){
            arr[n-1] = 1;
        }
        else{
            arr[(eIdx+sIdx)/2] = 1;
        }

        // 다시 거리 계산
        int min = n;
        for(int i=0;i<n;i++){
            if(arr[i] == 1){
                for(int j=i+1;j<n;j++){
                    if(arr[j] == 1){
                        min = Math.min(min, j-i);
                    }
                }                
            }
        }
        System.out.println(min);
    }
}