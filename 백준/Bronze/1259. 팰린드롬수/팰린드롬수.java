import java.io.*;
import java.util.ArrayList;

public class Main{
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true){
            String n = br.readLine();
            boolean istrue = true;
            if(Integer.parseInt(n) == 0){
                break;
            }


            for(int i=0;i<(n.length()/2);i++){
                if(n.charAt(i) != n.charAt(n.length()-i-1)){
                    istrue = false;
                    break;
                }
            }
            if(!istrue)
                bw.write("no\n");
            else
                bw.write("yes\n");
        }

    
        br.close();
        bw.flush();
        bw.close();
    }
}