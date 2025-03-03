public class RedBlackTree {
    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node(int value, Color color) {
            this.value = value;
            this.color = color;
        }
    }

    private enum Color {
        BLACK,
        RED
    }

    public void insert(int value) {
        root = insert(root, value);
        if (root != null) {
            root.color = Color.BLACK;  // Корень всегда должен быть черным
        }
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value, Color.RED);  // Новая нода всегда красная
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        // Балансировка дерева
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            swapColors(node);
        }

        return node;
    }

    public Node find(int value) {
        return find(root, value);
    }

    private Node find(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value == node.value) {
            return node;
        }
        if (value < node.value) {
            return find(node.left, value);
        } else {
            return find(node.right, value);
        }
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    private Node leftRotate(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = Color.RED;
        return temp;
    }

    private Node rightRotate(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = Color.RED;
        return temp;
    }

    private void swapColors(Node node) {
        node.color = (node.color == Color.RED ? Color.BLACK : Color.RED);
        if (node.left != null) node.left.color = Color.BLACK;
        if (node.right != null) node.right.color = Color.BLACK;
    }
}
