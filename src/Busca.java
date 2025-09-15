import java.util.Comparator;
public class Busca<T> extends SearchObserver<T>{

    public int linear(T[] array, T x){
        for(int i=0;i<array.length;i++){
            notifyComparison(array[i], x, i);
        if(x.equals(array[i]))
            notifyFound(array[i], i);
        return i;
        }// fim for
        notifyNotFound(x);  
        return -1;  
            
    }

    public int linear(T[] array, T x, Comparator comparator){
        for(int i=0;i<array.length;i++){
            notifyComparison(array[i], x, i);
        if(comparator.compare(x,array[i])==0) // mudar e testar no main
             notifyFound(array[i], i);
        return i;
        }// fim for
        notifyNotFound(x);  
        return -1;        
    }

    public int binaria(T[] array, T x, Comparator<T> comparator){
        int inicio =0, fim = array.length-1;
        int meio;
        while(inicio<=fim){
            meio = (inicio+fim)/2;
            notifyComparison(array[meio], x, meio);

            int comparacao = comparator.compare(x, array[meio]);
            if(comparacao==0){
                notifyFound(array[meio], meio);
            return meio;
            }
            if(comparacao<0)
                fim = meio-1;
            else
                inicio = meio+1;        
        }// fim while
        notifyNotFound(x); 
        return -1;
    }

    public int binaria(T[] array, T x){
        return binaria(array, x, (a,b)->((Comparable<T>) a).compareTo(b));
    }



    
}
