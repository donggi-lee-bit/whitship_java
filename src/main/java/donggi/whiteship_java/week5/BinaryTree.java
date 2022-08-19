package donggi.whiteship_java.week5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        // 명령
        root = insertRecursive(root, value);
    }

    public boolean search(int value) {
        this.root = searchRecursive(root, value);
        if (root != null) {
            return true;
        } else {
            return false;
        }
    }

    // 중위 순회 : 왼쪽 자식노드, 내 노드, 오른쪽 자신노드 순서로 방문한다
    public void inOrder() {
        inOrderRecursive(root);
    }

    // 전위 순회 : 내 노드, 왼쪽 자식노드, 오른쪽 자식노드 순서로 방문한다.
    public void preOrder() {
        preOrderRecursive(root);
    }

    // 후위 순회 : 왼쪽 자식노드, 오른쪽 자식노드, 내 노드 순서로 방문한다.
    public void postOrder() {
        postOrderRecursive(root);
    }

    public void bfsCommand() {
        bfs(root);
    }

    public void dfsCommand() {
        dfs();
    }


    private List<Integer> bfs(Node node) {
        List<Integer> values = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            values.add(pollNode.value);
            System.out.print(pollNode.value + " ");

            if (pollNode.left != null) {
                queue.add(pollNode.left);
            }

            if (pollNode.right != null) {
                queue.add(pollNode.right);
            }
        }

        return values;
    }

    private void dfs() {
        // 왼쪽, 루트, 오른쪽 순으로 순회한다.
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.value + " ");
            inOrderRecursive(root.right);
        }
    }

    private void preOrderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    private void postOrderRecursive(Node root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.value + " ");
        }
    }

    private Node insertRecursive(Node root, int value) {
        // 쿼리
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursive(root.right, value);
        }
        return root;
    }

    private Node searchRecursive(Node root, int value) {
        if (root == null || root.value == value) {
            return root;
        }
        if (root.value > value) {
            return searchRecursive(root.left, value);
        }
        return searchRecursive(root.right, value);
    }


    static class Node {
        // 이진 트리
        // 각각의 노드가 최대 두 개의 자식 노드를 가지는 트리 자료 구조
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


}
