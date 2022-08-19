package donggi.whiteship_java.week5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.insert(45);
        binaryTree.insert(10);
        binaryTree.insert(7);
        binaryTree.insert(12);
        binaryTree.insert(90);
        binaryTree.insert(50);
    }

    @Test
    void inOrderTest() {
        binaryTree.inOrder();
    }

    @Test
    void preOrderTest() {
        binaryTree.preOrder();
    }

    @Test
    void postOrderTest() {
        binaryTree.postOrder();
    }
}
