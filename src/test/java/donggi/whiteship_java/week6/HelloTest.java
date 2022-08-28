package donggi.whiteship_java.week6;

import static org.assertj.core.api.Assertions.assertThat;

import donggi.whiteship_java.week6.extends_ex.Hello;
import donggi.whiteship_java.week6.extends_ex.HelloParents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTest {

    Hello h;

    @BeforeEach
    void setUp() {
        h = new Hello();
    }

    @DisplayName("상속 받은 자손 클래스에서 조상 클래스의 멤버변수 값을 변경하면 멤버 변수의 값이 바뀐다")
    @Test
    void agePlusTest() {
        int result = 1;

        assertThat(h.plusAge()).isEqualTo(result);
    }

    @Test
    void superClassMemberVariableTest() {
        HelloParents parents = new HelloParents();
        h.plusAge();

        int result = 1;

        assertThat(parents.age).isEqualTo(1);

    }
}
