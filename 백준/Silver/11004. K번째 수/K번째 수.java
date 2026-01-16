import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K-1);
        bw.write(A[K-1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void quickSort(int[] A, int low, int high, int K){
        if(low < high){
            int pivot = partition(A, low, high);
            if(pivot == K){
                return;
            }
            else if(K < pivot){
                quickSort(A, low, pivot - 1, K);
            }
            else{
                quickSort(A, pivot + 1, high, K);
            }
        }
    }
    public static int partition(int[] A, int low, int high){
        if(low + 1 == high){
            if(A[low] > A[high]) {
                swap(A, low, high);
                return high;
            }
        }
        int mid = (low + high)/2;
        swap(A, low, mid);
        int pivot = A[low];
        int i = low + 1, j = high;
        while(i <= j){
            while(j >= low + 1 && pivot < A[j]){
                j--;
            }
            while(i <= high && pivot > A[i]){
                i++;
            }
            if(i <= j){
                swap(A, i++, j--);
            }
        }
        A[low] = A[j];
        A[j] = pivot;
        return j;
    }
    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}