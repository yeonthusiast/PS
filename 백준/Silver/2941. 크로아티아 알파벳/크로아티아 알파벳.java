import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word = br.readLine();
        int count = 0;
        int idx = 0;
        char next;
        while(idx != word.length()){
            char w = word.charAt(idx);
            if(idx == word.length() - 1){
                count++;
                break;
            }
            switch(w){
                case 'c':
                    next = word.charAt(idx+1);
                    if(next == '=' || next == '-'){
                        idx++;
                    }
                    break;
                case 'd':
                    next = word.charAt(idx+1);
                    if(next == '-'){
                        idx++;
                    }
                    else if(next == 'z' && idx != word.length() - 2){
                        next = word.charAt(idx+2);
                        if(next == '='){
                            idx += 2;
                        }
                    }
                    break;
                case 'l':
                    next = word.charAt(idx+1);
                    if(next == 'j'){
                        idx++;
                    }
                    break;    
                case 'n':
                    next = word.charAt(idx+1);
                    if(next == 'j'){
                        idx++;
                    }
                    break;
                case 's':
                    next = word.charAt(idx+1);
                    if(next == '='){
                        idx++;
                    }
                    break;    
                case 'z':
                    next = word.charAt(idx+1);
                    if(next == '='){
                        idx++;
                    }
                    break;                                    
            }    
            count++;
            idx++;
        }
        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}