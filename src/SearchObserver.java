public abstract class SearchObserver<T> {
    public void notifyComparison(T current, T target, int index) {
        System.out.println("Comparando índice " + index + ": " + current + " com " + target);
    }

 public void notifyFound(T element, int index) {
        System.out.println("Elemento encontrado! " + element + " no índice " + index);
    }

    public void notifyNotFound(T target) {
        System.out.println("Elemento " + target + " não encontrado no array.");
    }
    
}
