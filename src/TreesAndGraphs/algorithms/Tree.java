package TreesAndGraphs.algorithms;

public class Tree<T> {

    private T data;
    private Tree<T>[] children;     // this allows for more general extension to binary, ternary or other m-ary trees

    public Tree(T data) {
        this.data = data;
    }
}
