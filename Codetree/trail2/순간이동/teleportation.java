import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int min = 100;

        // 그냥 A에서 B까지 걷기
        min = Math.min(min, Math.abs(a-b));
        // x에서 y로 순간이동: AtoX + YtoB
        int ax = Math.abs(a-x);
        int yb = Math.abs(y-b);
        min = Math.min(min, ax+yb);
        // y에서 x로 순간이동
        int ay = Math.abs(a-y);
        int xb = Math.abs(x-b);
        min = Math.min(min, ay+xb);

        System.out.println(min);
    }
}