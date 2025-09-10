import java.util.Arrays;
import java.util.Comparator;
public class QuickSort<T> {


    public void sort(T[] arr, Comparator<T> comparator) {
        quickSort(0, arr.length - 1, arr, comparator);
    }

    void showPartofArray(T[] vetor, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(vetor[i] + " | ");
        }
        System.out.println("\n");
    }

    private void quickSort(int left, int right, T[] arr, Comparator<T> comparator) {
        if (left < right) {
            int pivotIndex = partition(left, right, arr, comparator);
            System.out.println("Após partição com pivô em índice " + pivotIndex + ": " + Arrays.toString(arr));
            
            quickSort(left, pivotIndex - 1, arr, comparator);    // subarray esquerdo
            quickSort(pivotIndex + 1, right, arr, comparator);   // subarray direito
        }
    }

    private int partition(int left, int right, T[] arr, Comparator<T> comparator) {
        int pivotIndex = left;
        T pivot = arr[pivotIndex];
        int storeIndex = pivotIndex + 1;

        System.out.println("\nPartição iniciada: ");
        showPartofArray(arr, left, right);
        System.out.println("Indices: left=" + left + ", right=" + right);
        System.out.println("Pivô = " + pivot + " (índice " + pivotIndex + ")");

        for (int i = pivotIndex + 1; i <= right; i++) {
            if (comparator.compare(arr[i], pivot) < 0 ) {
                troca(i, storeIndex, arr);
                System.out.println("  Troca: arr[" + i + "] com arr[" + storeIndex + "] --> ");
                showPartofArray(arr, left, right);
                storeIndex++;
            }
        }

        // Coloca pivô na posição correta
        troca(pivotIndex, storeIndex - 1, arr);
        System.out.println("  Pivô trocado: arr[" + pivotIndex + "] com arr[" + (storeIndex - 1) + "] -> ");
        showPartofArray(arr, left, right);

        return storeIndex - 1; // nova posição do pivô
    }

    private void troca(int i, int j, T[] arr) {
        if (i != j) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void sort(T[] array){
         sort(array, (a,b)->((Comparable<T>) a).compareTo(b));
    }


}