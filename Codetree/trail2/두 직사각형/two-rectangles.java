import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();        
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        
        // xy 기준: ab가 동, 북, 서, 남
        if(x2 < a1 || y2 < b1 || a2 < x1 || b2 < y1){
            System.out.println("nonoverlapping");
        }
        else{
            System.out.println("overlapping");
        }
    }
}