import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int len = N.length();
        int[] num = new int[len];
        for(int i=0;i<len;i++){
            num[i] = Integer.parseInt(N.substring(i, i+1));
        }

        int max;
        for(int i=0;i<len;i++){
            max = i;
            for(int j=i+1;j<len;j++){
                if(num[max] < num[j]){
                    max = j;
                }
            }
            if(num[i] < num[max]){
                int temp = num[i];
                num[i] = num[max];
                num[max] = temp;
            }
        }

        for(int i=0;i<len;i++){
            bw.write(String.valueOf(num[i]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}