import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        // 메시지 정보(발송자, 안읽은사람수)
        char[] c = new char[m+1];
        int[] u = new int[m+1];
        for(int i=1;i<=m;i++){
            c[i] = sc.next().charAt(0);
            u[i] = sc.nextInt();
        }

        // 어떤 사람이 어디까지 읽었는지를 저장한다.
        // A = 0, B = 1... (c - 65로 계산)
        int[] pro = new int[n];
        for(int i=0;i<n;i++){
            pro[i] = 0;
        }

        for(int i=1;i<=m;i++){
            int sender = c[i] - 65;
            // 보낸 사람은 읽음
            pro[sender] = i;
            // 0이면 다 읽음
            if(u[i] == 0){
                for(int j=0;j<n;j++){
                    pro[j] = i;
                }
            }
            // 안 읽은 사람이 유지되면 새로운 사람은 의심대상이 아님
            if(i != 1 && u[i] == u[i-1]){
                for(int j=0;j<n;j++){
                    if(pro[j] >= i-1) pro[j] = i;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(pro[i] < p){
                System.out.print((char)(i + 65) + " ");
            }
        }
        System.out.println();
    }
}
