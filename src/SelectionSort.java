import java.util.*;
public class SelectionSort<T> extends ObservableSort<T> {

    
    private void troca(T[] array, int i, int j){
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            notificarTroca(i, j);
    }   

    private int indiceMenorValorVetor(T[] array, int pos, 
                                Comparator<T> comparator){
         int minIndice = pos;
         for(int i=pos+1;i<array.length;i++){
            notificarComparacao(minIndice, i);
            if(comparator.compare(array[i],array[minIndice])<0)
                minIndice = i;
         }// fim for         
         return minIndice;          
    }

    public T[] sort(T[] array, Comparator<T> comparator){
        for(int i=0;i<array.length-1;i++){
            int indiceMenor = indiceMenorValorVetor(array, i, comparator);
                troca(array, i, indiceMenor);
        }// fim for
        notificarConclusao();
        return  array;
    }

    public T[] sort(T[] array){
        return sort(array, (a,b)->((Comparable<T>) a).compareTo(b));
    }
}
