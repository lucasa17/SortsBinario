
import java.util.Comparator;


public class InsertionSort<T> extends ObservableSort<T> {
    
    private void insert(T[] array, int i, Comparator<T> comparator){
        T eleito = array[i];
        int indiceComparacao = i-1;
        while(indiceComparacao>=0 && 
              comparator.compare(eleito,array[indiceComparacao])<0){
            notificarComparacao(indiceComparacao, i);
            array[indiceComparacao+1] = array[indiceComparacao];
            notificarTroca(indiceComparacao+1, indiceComparacao);
            indiceComparacao--;    
        }// fim while
        notificarComparacao(indiceComparacao+1, i);
        array[indiceComparacao+1] =  eleito;
    }

    public T[] sort(T[] array, Comparator<T> comparator){
        for(int i=1;i<array.length;i++){
            insert(array, i, comparator);
        }
        notificarConclusao();
        return array;
    }

    public T[] sort(T[] array){
        return sort(array, (a,b)->((Comparable<T>) a).compareTo(b));
    }

}
