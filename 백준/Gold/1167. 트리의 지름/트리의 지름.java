import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    static ArrayList<Edge>[] A;
    static int[] d;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            A[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true){
                int num = Integer.parseInt(st.nextToken());   
                if(num == -1){
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                A[node].add(new Edge(num, distance));
            }
        }

        d = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);
        int Max = 1;
        for(int i=2;i<=N;i++){
            if(d[Max] < d[i]){
                Max = i;
            }
        }

        d = new int[N+1];
        visited = new boolean[N+1];
        BFS(Max);
        Arrays.sort(d);
        bw.write(d[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(Edge i : A[node]){
                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    visited[e] = true;
                    q.add(e);
                    d[e] = d[node] + v;
                }
            }
        }
    }
}

class Edge{
    int e;
    int value;
    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}