import java.io.*;

public class Main{
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] s = input.split("-");
        for(int i=0;i<s.length;i++){
            int temp = mySum(s[i]);
            if(i==0)
                answer += temp;
            else
                answer -= temp;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int mySum(String a){
        int sum = 0;
        String temp[] = a.split("[+]");
        for(int i=0;i<temp.length;i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}