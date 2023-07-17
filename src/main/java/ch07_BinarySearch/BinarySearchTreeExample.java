package ch07_BinarySearch;

import java.util.Comparator;

public class BinarySearchTreeExample {

    static class BinarySearchTree<E>{
        private Node<E> root;
        private int size;
        private final Comparator<? super E> comparator;

        public BinarySearchTree(){
            this(null);
        }

        public BinarySearchTree(Comparator<? super E> comparator) {
            this.comparator = comparator;
            this.root = null;
            this.size = 0;
        }

        public boolean add(E key){
            return comparator == null ? add(key, null):add(key, comparator);
        }
        public boolean add(E key, Comparator<? super E> comparator){
            Node<E> current = root;
            if(current == null){
                root = new Node<>(key);
                size+=1;
                return true;
            }

            Node<E> currentParent;
            Comparable<? super E> comparableKey = (Comparable<? super E>) key;
            int compareResult;

            do {
                currentParent = current;
                compareResult = comparator == null ? comparableKey.compareTo(current.key): comparator.compare(key, current.key);
                if(compareResult < 0){
                    current = current.left;
                }else if(compareResult > 0){
                    current = current.right;
                }else{
                    return false;
                }
            }while(current != null);

            Node<E> newNode = new Node<>(key, currentParent);
            if(compareResult < 0){
                currentParent.left = newNode;
            }else {
                currentParent.right = newNode;
            }
            size += 1;
            return true;
        }

        public Node<E> delete(E key){
            return comparator == null ? delete(key, null) : delete(key, comparator);
        }

        public Node<E> delete(E key, Comparator<? super E> comparator){
            Node<E> current = comparator == null ? findNode(key) : findNode(key, comparator);
            if(current == null){
                return null;
            }
            if(current.parent == null){
                size -= 1;
                root = null;
                return current;
            }
            if(current.left == null && current.right == null){
                if(current.parent.left.equals(current)){
                    current.parent.left = null;
                }else{
                    current.parent.right = null;
                }
            }else if(current.left != null && current.right != null){
                Node<E> temp;
                if(current.parent.left.equals(current)){
                    temp = current.right;
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    delete(temp.key, comparator);
                    current.parent.left = temp;
                }else {
                    temp = current.left;
                    while(temp.right != null){
                        temp = temp.right;
                    }
                    delete(temp.key, comparator);
                    current.parent.right = temp;
                }
                size += 1;
                current.right.parent = temp;
                current.left.parent = temp;
                temp.parent = current.parent;
                temp.right = current.right;
                temp.left = current.left;
            }else{
                if(current.parent.left.equals(current)){
                    current.parent.left = current.left == null ? current.right : current.left;
                }else{
                    current.parent.right = current.left == null ? current.right : current.left;
                }
            }
            size -= 1;
            return current;
        }

        public Node<E> findNode(E key){
            return comparator == null ? findNode(key, null) : findNode(key, comparator);
        }

        public Node<E> findNode(E key, Comparator<? super E> comparator){
            Node<E> current = root;
            if(current == null){
                return null;
            }
            Comparable<? super E> comparableKey = (Comparable<? super E>) key;
            int compareResult;
            do{
                compareResult = comparator == null ? comparableKey.compareTo(current.key): comparator.compare(key, current.key);
                if(compareResult < 0)
                    current = current.left;
                else if(compareResult > 0)
                    current = current.right;
                else
                    return current;
            }while(current != null);
            return null;
        }

        public int getSize(){
            return this.size;
        }

        public boolean isEmpty(){
            return getSize() == 0;
        }

        public void clear(){
            this.size = 0;
            root = null;
        }

        public boolean contains(E key){
            return comparator == null? findNode(key) == null: findNode(key, comparator) == null;
        }
    }

    static class Node<E>{
        E key;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        Node(E key){
            this(key, null);
        }

        Node(E key, Node<E> parent){
            this.key = key;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }
    }
}
