import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int check[];
    static int pw[];
    static int checkSecret;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        char[] dna = br.readLine().toCharArray();
        check = new int[4];
        pw = new int[4];
        checkSecret = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            check[i] = Integer.parseInt(st.nextToken());
            if(check[i]==0)
                checkSecret++;
        }

        for(int i=0;i<P;i++){
            Add(dna[i]);
        }
        if(checkSecret==4)
            result++;

        for(int i =P; i<S;i++){
            int j = i-P;
            Add(dna[i]);
            Remove(dna[j]);
            if(checkSecret==4)
                result++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void Add(char c){
        switch(c){
            case 'A':
                pw[0]++;
                if(pw[0]==check[0])
                    checkSecret++;
                break;
            case 'C':
                pw[1]++;
                if(pw[1]==check[1])
                    checkSecret++;
                break;
           case 'G':
                pw[2]++;
                if(pw[2]==check[2])
                    checkSecret++;
                break;
           case 'T':
                pw[3]++;
                if(pw[3]==check[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c){
        switch(c){
            case 'A':
                if(pw[0]==check[0])
                    checkSecret--;
                pw[0]--;
                break;
            case 'C':
                if(pw[1]==check[1])
                    checkSecret--;
                pw[1]--;
                break;
            case 'G':
                if(pw[2]==check[2])
                    checkSecret--;
                pw[2]--;
                break;
            case 'T':
                if(pw[3]==check[3])
                    checkSecret--;
                pw[3]--;
                break;
        }
    }
}