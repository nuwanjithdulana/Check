public class BinaryTree {
    
    private Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.traverseInOrder(); // prints "3 5 7"
    }

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = insert(node.rightChild, value);
        }

        return node;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.value) {
            return true;
        } else if (value < node.value) {
            return contains(node.leftChild, value);
        } else {
            return contains(node.rightChild, value);
        }
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.leftChild);
            System.out.print(node.value + " ");
            traverseInOrder(node.rightChild);
        }
    }
}
