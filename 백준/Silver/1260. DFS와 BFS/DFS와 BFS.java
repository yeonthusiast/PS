import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        A = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }

        for(int i=1;i<=V;i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[V+1];
        DFS(start);
        System.out.println();
        visited = new boolean[V+1];
        BFS(start);
        System.out.println();

        br.close();
    }
    private static void DFS(int start){
        System.out.print(start + " ");
        visited[start] = true;
        for(int i : A[start]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
    private static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v + " ");
            for(int i : A[v]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}