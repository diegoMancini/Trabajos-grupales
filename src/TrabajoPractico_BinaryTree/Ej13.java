package TrabajoPractico_BinaryTree;

/**
 * Created by Tomas on 26/3/2017.
 */
public class Ej13 {
    public <T> int weight (BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
        else
            return 1 + weight(a.getLeft()) + weight(a.getRight());
    }

    public <T> int completeNodes(BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
        if (a.getLeft().isEmpty())
            return completeNodes(a.getRight());
        if (a.getRight().isEmpty())
            return completeNodes(a.getLeft());
        return 1 + completeNodes(a.getRight()) + completeNodes(a.getLeft());
    }

    public <T> int leaves(BinaryTree<T> a){
        if (a.isEmpty())
            return 0;
        if (a.getLeft().isEmpty() && a.getRight().isEmpty())
            return 1;
        return leaves(a.getLeft()) + leaves(a.getRight());
    }

    public <T> int height(BinaryTree<T> a){
        if (a.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(height(a.getLeft()), height(a.getRight()));
    }

    public <T> void inOrden(BinaryTree<T>  a){
        if(!a.isEmpty()){
            inOrden(a.getLeft());
            System.out.println(a.getRoot());
            inOrden(a.getRight());
        }
    }

    public <T> void preOrden (BinaryTree<T> a){
        if (!a.isEmpty()) {
            System.out.print(a.getRoot());
            preOrden(a.getLeft());
            preOrden(a.getRight());
        }
    }

    public <T> void postOrden (BinaryTree<T> a){
        if (!a.isEmpty()) {
            postOrden(a.getLeft());
            postOrden(a.getRight());
            System.out.print(a.getRoot());
        }
    }

    public <T> int ocurrencias(BinaryTree<T> a, Object o){
        if(a.isEmpty())
            return 0;
        if(a.getRoot().equals(o))
            return 1 + ocurrencias(a.getLeft(),o)+ocurrencias(a.getRight(),o);
        else
            return ocurrencias(a.getLeft(),o)+ocurrencias(a.getRight(),o);
    }
}

