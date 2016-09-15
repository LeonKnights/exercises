package domain;

public class BinaryTree {
    public Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void addNode(int key, String name) {
        Node createdNode = new Node(key, name);
        if (this.root == null) {
            this.root = createdNode;
        } else {
            Node focusNode = this.root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.getKey()) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(createdNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null) {
                        parent.setRightChild(createdNode);
                        return;
                    }
                }

            }
        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.getLeftChild());
            System.out.println("Focus node: \n"
                    + "key: " + focusNode.getKey()
                    + " | "
                    + "name: " + focusNode.getName());
            inOrderTraverseTree(focusNode.getRightChild());
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println("Focus node: \n"
                    + "key: " + focusNode.getKey()
                    + " | "
                    + "name: " + focusNode.getName());
            preOrderTraverseTree(focusNode.getLeftChild());
            preOrderTraverseTree(focusNode.getRightChild());
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.getLeftChild());
            postOrderTraverseTree(focusNode.getRightChild());
            System.out.println("Focus node: \n"
                    + "key: " + focusNode.getKey()
                    + " | "
                    + "name: " + focusNode.getName());
        }
    }

    public Node findNode(int key) {
        Node focusNode = this.root;
        while (focusNode.getKey() != key) {
            if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else {
                focusNode = focusNode.getRightChild();
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public boolean remove(int key) {
        Node focusNode = this.root;
        Node parent = this.root;
        boolean isItALeftChild = true;
        while (focusNode.key != key) {
            parent = focusNode;
            if (key < focusNode.getKey()) {
                isItALeftChild = true;
                focusNode = focusNode.getLeftChild();
            } else {
                isItALeftChild = false;
                focusNode.getRightChild();
            }
            if (focusNode == null) {
                return false;
            }
            if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
                if (focusNode == this.root) {
                    this.root = null;
                } else if (isItALeftChild) {
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            } else if (focusNode.getRightChild() == null) {
                if (focusNode == root) {
                    this.root = focusNode.getLeftChild();
                } else if (isItALeftChild) {
                    parent.setLeftChild(focusNode.getLeftChild());
                } else {
                    parent.setRightChild(focusNode.getLeftChild());
                }
            } else if (isItALeftChild) {
                parent.setLeftChild(focusNode.getRightChild());
            } else {
                Node replacement = getReplacementNode(focusNode);
                if (focusNode == this.root) {
                    this.root = replacement;
                }
            }
        }
        return isItALeftChild;
    }

    private Node getReplacementNode(Node focusNode) {
        return null;
    }
}
