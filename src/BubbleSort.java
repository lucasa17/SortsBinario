import java.util.*;
public class BubbleSort<T> extends ObservableSort<T> {
    
    private void troca(T[] array, int i, int j){
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            notificarTroca(i, j);
    }   

    public T[] sort(T[] array, Comparator<T> comparator){
        int n = array.length;
        for(int fase=1;fase<n;fase++){
            for(int j=0;j<n-fase;j++){
                notificarComparacao(j,j+1);
                if(comparator.compare(array[j],array[j+1]) >0){
                    troca(array, j, j+1);
                }// fim if
            }// fim for j
        }// fim for fase
        notificarConclusao();
        return array;
    } 

    public T[] sortOptimized(T[] array, Comparator<T> comparator){
        boolean flagTrocou = false;
        int n = array.length;
        for(int fase=1;fase<n;fase++){
            
            for(int j=0;j<n-fase;j++){
                
                if(comparator.compare(array[j],array[j+1]) >0){
                    troca(array, j, j+1);
                    flagTrocou = true;
                }// fim if
            }// fim for j
            if(!flagTrocou) break; 
            flagTrocou = false; 
        }// fim for fase
        return array;
    }

    public T[] sort(T[] array, Comparator<T> comparator, boolean verbose){
        Scanner leia = new Scanner(System.in);
        if(verbose==true){
        int n = array.length;
        for(int fase=1;fase<n;fase++){
            System.out.println("Fase:"+fase); //
           System.out.println( Arrays.toString(array)); // printa vetor
            leia.nextLine(); // pause

            for(int j=0;j<n-fase;j++){
                if(comparator.compare(array[j],array[j+1]) >0){
                    troca(array, j, j+1);
                }// fim if
            }// fim for j
        }// fim for fase
        }// fim if verbose
        return array;
    } 
    public T[] sort(T[] array, boolean verbose){
        if(verbose==true)
            return sort(array, (a,b)->((Comparable<T>) a).compareTo(b), verbose);
         else   
            return sort(array, (a,b)->((Comparable<T>) a).compareTo(b));
    }

    public T[] sort(T[] array){
        return sort(array, (a,b)->((Comparable<T>) a).compareTo(b));
    }

    public T[] sortOptimized(T[] array){
        return sortOptimized(array, (a,b)->((Comparable<T>) a).compareTo(b));
    }

}
