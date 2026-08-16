import java.util.Scanner;
public class Main {
    public static boolean possible(int d, int v, int x){
        for(int i=v;i>=1;i--){
            d += i;
        }
        if(d > x) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        int d = 1;
        int s = 1;
        int v = 1;

        while(d < x){
            // v를 1 늘렸을 때 가능한지 검증, 유지 안되면 줄임
            if(possible(d, v+1, x)) v++;
            else if(!possible(d, v, x)) v--;

            d += v;
            s++;
        }

        System.out.println(s);
    }
}