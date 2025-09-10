import java.util.Comparator;

public class Busca<T> {

    public int linear(T[] array, T x){
        for(int i=0;i<array.length;i++){
            if(x.equals(array[i]))
                return i;
        }// fim for
        return -1;        
    }

    public int linear(T[] array, T x, Comparator comparator){
        for(int i=0;i<array.length;i++){
            if(comparator.compare(x, array[i]) == 0) // mudar e testar no main
                return i;
        }// fim for
        return -1;        
    }
    
    public int binaria(T[] array, T x, Comparator<T> comparator) {
    	int inicio = 0, meio, fim = array.length - 1;
    	
    	while(inicio <= fim) {
    		meio = (inicio+fim)/2;
    		int comparacao = comparator.compare(x, array[meio]);
    		if(comparacao == 0) {
    			return meio;
    		}
    		if(comparacao < 0) {
    			fim = meio + 1;
    		}
    		else{
    			fim = meio - 1;
    		}
    	}
    	return -1;
    }

    public int binaria(T[] array, T x) {
    	return binaria(array, x, (a,b)->((Comparable<T>) a).compareTo(b));
    }
    
}
