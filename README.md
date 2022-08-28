# whitship_java
백기선 자바 스터디 레포

# 6주차 상속

## 자바 상속의 특징

### Java의 상속이란

Java에서 상속이란 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것입니다. 상속을 통해 클래스를 작성하면 적은 양의 코드로 새로운 클래스를 작성할 수 있고 코드를 공통적으로 관리할 수 있어 코드의 추가 및 변경에 매우 용이한 장점을 갖게 됩니다.

### 구현 방식

Java에서 상속을 구현하는 방법에 대해 알아보겠습니다.
새로 만들고자 하는 클래스의 이름 뒤에 상속받고자 하는 클래스의 이름을 `extends` 키워드와 함께 써주면 됩니다.

```java
public class Tv {
    boolean power;
    int channel;

    void power() {
        power = !power;

    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }

    static class CaptionTv extends Tv {
        boolean caption;

        void displayCation(String text) {
            if (caption) {
                System.out.println(text);
            }
        }
    }
}

class TvTest {

    @Test
    void CaptionTvTest() {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCation("Hello, World!");
        ctv.caption = true;
        ctv.displayCation("Hello, World!!!");
    }
}
```

<img width="418" alt="Screen Shot 2022-08-29 at 12 02 23 AM" src="https://user-images.githubusercontent.com/73376468/187080723-da858de6-12b8-413a-90fc-209525a46da8.png">

자바의 정석 chapter 7 예제 코드를 참조하였습니다.

- CaptionTv 클래스는 Tv 클래스를 상속 받고 있습니다
    - 여기서 Tv 클래스가 조상 클래스, CaptionTv 클래스는 자손 클래스가 됩니다
- CaptionTv 객체를 만들면 조상 클래스인 Tv의 멤버 변수 channel을 호출할 수 있습니다
- channel의 값을 10으로 할당해주고 channelUp() 메서드를 호출하여 channel의 값이 변경되는지 출력해보니 11이 출력되는 걸 볼 수 있습니다


## super 키워드

- `super` 키워드는 상속 관계가 맺어진 클래스의 조상 클래스 객체를 참조합니다. 
- 상속이라는 개념으로 인해 `super` 키워드가 등장하게 됩니다.

### 1. 변수와 함께 `super` 키워드의 사용

상속 관계를 가진 클래스가 각각 같은 멤버 변수를 가졌을 때 사용됩니다.
```java
class Vehicle {
    int maxSpeed = 120;
}
  
class Car extends Vehicle {
    int maxSpeed = 180;
  
    void display() {
        System.out.println("Maximum Speed: " + super.maxSpeed);
    }
}
  
class Test {
    public static void main(String[] args) {
        Car small = new Car();
        small.display();
    }
}
```

<img width="442" alt="Screen Shot 2022-08-29 at 12 18 35 AM" src="https://user-images.githubusercontent.com/73376468/187081434-ebf6b788-4d9c-4697-91ce-dcc17ceb587d.png">

- Car, Vehicle 클래스가 상속 관계를 갖고 있습니다.
- Vehicle 클래스의 멤버 변수 maxSpeed는 값이 120이 할당 되었고, Car 클래스에선 180이 할당되어 있습니다.
- `super` 키워드를 이용해 maxSpeed를 출력하면 조상 클래스인 Vehicle 클래스에 정의된 maxSpeed의 값이 출력되는 걸 볼 수 있습니다. 

### 2. 메서드와 함께 `super` 키워드의 사용

조상 클래스의 메서드를 호출 할 때 사용됩니다. 변수를 호출할 때처럼 조상 클래스와 자손 클래스에 같은 이름의 메서드가 있을 경우 호출하고자 하는 메서드를 명확히 할 수 있습니다.

```java
public class Person {
    void message() {
        System.out.println("This is person class");
    }
}

class Student extends Person {
    void message() {
        System.out.println("This is student class");
    }
    void display() {
        message();
        super.message();
    }
}

class Test {

    public static void main(String args[]) {
        Student s = new Student();
        s.display();
    }
}

```

<img width="458" alt="Screen Shot 2022-08-29 at 12 51 42 AM" src="https://user-images.githubusercontent.com/73376468/187082953-285e8340-4ccf-4c53-9928-2851e19b4f9a.png">

- 자손 클래스의 message() 메서드가 동작하고, 조상 클래스의 message() 메서드가 동작하는 걸 볼 수 있습니다.

### 3. 생성자와 함께 `super` 키워드의 사용

조상 클래스의 생성자를 호출할 때 사용됩니다. 조상 클래스에 매개변수가 있는 생성자와 매개변수가 없는 생성자가 모두 정의되어있을 때, `super` 키워드를 이용해 조상 클래스의 매개변수가 있는 생성자와 매개변수가 없는 생성자를 모두 호출할 수 있습니다.

```java
public class Person {

    int age;
    Person() {
        System.out.println("Person class Constructor");
    }

    public Person(int age) {
        this.age = age;
        System.out.println("Person class Constructor with age");
    }
}

class Student extends Person {
    Student() {
        super(10);
        // super();
        System.out.println("Student class Constructor");
    }
}

class Test {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println("super class variable age is : " + s.age);
    }
}
```

<img width="447" alt="Screen Shot 2022-08-29 at 1 09 43 AM" src="https://user-images.githubusercontent.com/73376468/187083674-1213e513-a964-4b5a-bd54-bf5fd9f4b739.png">

<img width="427" alt="Screen Shot 2022-08-29 at 1 09 56 AM" src="https://user-images.githubusercontent.com/73376468/187083691-59ec983d-b35e-4389-97a2-e8bb9627239a.png">

- 매개변수가 없는 생성자를 `super` 키워드를 이용해 호출하여 조상 클래스의 생성자가 호출되는 걸 볼 수 있습니다.
- 매개변수를 입력하여 생성자를 `super` 키워드를 이용해 호출하여 정수 값을 입력 받는 생성자를 호출하여 생성자 내부의 로직이 실행된 것을 볼 수 있습니다.
- 자손 클래스의 생성자에서 `super` 키워드를 이용해 조상 클래스의 생성자를 호출할 땐 생성자 본문의 첫 번째로 작성되어야 합니다.

# **References**

자바의 정석 chapter 7

https://www.geeksforgeeks.org/inheritance-in-java/
https://www.geeksforgeeks.org/super-keyword/