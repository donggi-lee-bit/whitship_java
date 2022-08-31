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

## 메서드 오버라이딩

### 오버라이딩이란

Java의 오버라이딩은 조상 클래스로부터 상속받은 메서드의 내용을 재정의하는 것을 이야기합니다. 상속받은 메서드를 그대로 사용할 수 있지만, 자손 클래스 자신에 맞게 변경해야하는 경우 오버라이딩하게 됩니다.

### 오버라이딩의 조건

오버라이딩은 메서드의 내용만 새로 작성하는 것이므로 메서드 선언부는 조상 클래스에서 정의한 것과 동일해야 합니다.
<br>
오버라이딩이 성립하기 위해서는 다음과 같은 조건을 만족해야 합니다.
- 메서드 이름
- 매개변수
- 반환 타입

이 세 가지 조건을 만족해야 오버라이딩 성립하게 됩니다. 
<br>
세 가지 조건은 선언부에 속하는 부분인데 이 때 접근 제어자와 예외는 제한된 조건 하에서 다르게 변경할 수 있습니다.
<br>
또한 자손 클래스에서 오버라이딩된 메서드에서 조상 클래스에서 오버라이딩하려는 메서드를 호출 할 수 있습니다.

### 접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경 할 수 없다.

- 조상 클래스에 정의된 메서드의 접근 제어자가 `protected`라면, 오버라이딩하는 자손 클래스의 메서드는 접근 제어자가 `protected`이거나 `public`이어야만 합니다. 
- 접근 제어자의 접근 범위를 넓은 것에서 좁은 것 순으로 나열하면 `public` `protected` `default` `private` 순서가 됩니다.

### 오버라이딩과 예외

오버라이딩과 관련하여 예외 처리를 할 때 주의할 두 가지가 있습니다.

**조상 클래스에서 오버라이딩 메서드가 예외를 던지고 있지 않을 때, 자손 클래스의 오버라이딩 메서드는 `unchecked exception`만 던질 수 있습니다.**
<br> 
- `checked exception`을 던지고자 한다면 `compile time error`가 발생하게 됩니다.

**조상 클래스의 오버라이딩 메서드가 예외를 던지고 있다면, 자손 클래스의 재정의된 오버라이딩 메서드는 조상 클래스의 오버라이딩 메서드가 던지는 예외와 동일하거나 하위 클래스의 예외만 던질 수 있습니다.**
<br>
- 이보다 상위 계층의 예외를 던지면 컴파일 오류가 발생하게 됩니다.
- 동일하거나 하위 클래스 예외만 던질 수 있습니다.
- 또한 하위 클래스 오버라이딩 메서드가 예외를 발생시키지 않아도 상관없습니다.

### 오버라이딩과 추상 메서드

인터페이스, 추상 클래스의 추상 메서드는 구현 클래스에서 오버라이딩(재정의) 해주어야합니다. 그러지 않으면 `compile time error`가 발생하게 됩니다.


<br>
이 외에 특정한 경우 자손 클래스에서 오버라이딩 할 수 없습니다.
<br>
<br>


### final 키워드가 붙은 메서드는 오버라이딩 할 수 없다.

조상 클래스에서 메서드를 정의할 때 `final` 키워드를 붙였다면 해당 메서드는 자손 클래스에서 오버라이딩 할 수 없습니다.

### private 접근 제어자를 가진 메서드는 오버라이딩 할 수 없다.

`private` 접근 제어자를 가진 메서드는 자손 클래스에서 오버라이딩 할 수 없습니다.

### `static` 메서드는 오버라이딩이 아닌 `method hiding`

오버라이딩 조건이 갖춰진 `static` 메서드를 자손 클래스에서 정의하면 이는 오버라이딩이 아닌 `method hiding`이 발생합니다. 조상 클래스에 정의된 `static` 메서드를 오버라이딩을 통해 재정의하는 게 아닌 자손 클래스에서 하나의 `static` 메서드를 새로이 정의하는것처럼 동작하게 됩니다.



## 간단 정리
정리해보면 오버라이딩을 할 땐

- 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없습니다.
- 예외는 조상 클래스의 메서ㅁ드보다 많이 선언할 수 없습니다.
- 인스턴스 메서드를 static 메서드로 혹은 그 반대로 변경할 수 없습니다.

# 다이나믹 메서드 디스패치

다이나믹 메서드 디스패치는 `Overriding`된 메서드에 대한 호출이 `compile-time`이 아닌 `runtime`에 결정되는 메커니즘입니다.
- `Overriding` 메서드가 조상 클래스 참조를 통해 호출될 때 `Java`는 호출이 발생할 때 참조되는 `Object`의 유형에 따라 실행할 메서드의 버전을 결정합니다.
    - 이 결정은 `runtime`에 이루어집니다.

## 예시

```java
public class Fruit {
    void m1() {
        System.out.println("Eat some Fruit");
    }
}

class Apple extends Fruit {
    void m1() {
        System.out.println("Eat some Apple");
    }
}

class Banana extends Fruit {
    void m1() {
        System.out.println("Eat some Banana");
    }
}

class Dispatch {
    public static void main(String args[]) {
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Banana banana = new Banana();


        Fruit ref;
        ref = fruit;
        ref.m1();

        ref = apple;
        ref.m1();

        ref = banana;
        ref.m1();
    }
}

```
- Apple, Banana 클래스는 Fruit 클래스를 상속 받고 있습니다.
- 각각의 자손 클래스에서는 `m1()`를 재정의하고 있습니다.
- `Fruit` 클래스 유형의 참조 변수를 선언합니다.
- `Apple`, `Banana` 인스턴스 변수를 각각 `ref` 변수에 할당하여 `m1()` 메서드를 호출하면 재정의한 메서드가 호출되는 걸 볼 수 있습니다.

```java
public class A {
    int x = 10;
}

class B extends A {
    int x = 20;
}

class Test {
    public static void main(String[] args) {
        A a = new B(); // object of type B

        // Data member of class A will be accessed
        System.out.println(a.x);
        // 10
    }
}

```
- Java에서 메서드만 오버라이드가 가능합니다. 
- 변수는 오버라이드가 불가능한데 이것에 대한 예시 코드입니다.
- B 클래스는 A 클래스를 상속 받고 있습니다.
    - 두 클래스 모두 x라는 멤버 변수를 갖고 있습니다.
    - `A` 클래스 유형인 참조 변수 `a`로 `B` 클래스 객체를 만듭니다.
    - 멤버 변수 `x`는 재정의되지 않기 때문에 `runtime` 시점에 결정되는 `다이나믹 메서드 디스패치`가 이루어지지 않고 조상 클래스 `A`의 멤버 변수 `x`의 값이 출력되게 됩니다

## Dynamic Method Dispatch의 장점

1. Dynamic Method Dispatch를 통해 Java는 runtime-polymorphism 핵심인 Override Method를 지원할 수 있습니다.
2. 이를 통해 상속 관계를 통해 코드 중복을 줄일 수 있고, 자손 클래스에서 일부 메서드를 재정의할 수 있게 됩니다.

## 정적 바인딩과 동적 바인딩

- 정적 바인딩은 compile-time 동안 수행되고 동적 바인딩은 runtime 중에 수행됩니다.
- `private`, `final`, `static` `method`와 `변수`들은 `정적 바인딩`을 사용하여 `compiler`에 의해 연결되는 반면 `Override method`는 runtime 객체 유형에 따라 runtime 시점에 결합하게 됩니다.

# 추상 클래스

추상화(abstraction) 는 특정 세부 사항을 숨기고 사용자에게 필수적인 정보만 보여줍니다. `abstract class` 혹은 `interface`를 통해 추상화 할 수 있습니다.

`abstract` 키워드를 이용해 추상 클래스를 만들 수 있습니다. 메서드에도 `abstract` 키워드를 이용하여 추상 메서드를 만들 수 있습니다.

- `abstract class` : 추상 클래스는 인스턴스를 만들 수 없습니다.
- `abstract method` : 추상 클래스에서만 사용할 수 있으며 본문은 작성하지 않습니다. 본문은 상속된 하위 클래스에서 작성되게 됩니다.

## 예시

```java
abstract class Base {

    public Base() {
        System.out.println("Base class constructor");
    }

    abstract void fun();
}

class Derived extends Base {

    public Derived() {
        System.out.println("Derived class constructor");
    }

    void fun() {
        System.out.println("Derived fun() called");
    }
}

class Main {

    public static void main(String[] args) {
        Base b = new Derived();
        b.fun();
        // Base class constructor
        // Derived class constructor
        // Derived fun() called
    }
}

```
- `abstract method`의 본문은 자손 클래스에서 작성되었습니다.
- 추상 클래스는 `기본 생성자`를 가질 수 있는데 이는 `상속 받은 자손 클래스`의 `인스턴스`가 생성될 때 호출됩니다.
- 추상 클래스는 추상 메서드 없이 작성할 수 있습니다. 추상 클래스는 `인스턴스화` 할 수 없고, `상속`만 가능하게 됩니다.

## 그 외

- 그 외에도 추상 클래스는 `static` 메서드를 정의할 수 있습니다.
- 클래스에 추상 메서드가 포함되어 있으면 반드시 클래스를 `abstract`로 선언해야 합니다. 
- 추상 클래스를 상속 받는 자손 클래스가 추상 메서드를 구현할 수 없는 경우 다음 자식 클래스가 나머지 추상 클래스를 구현할 수 있도록 해당 자식 클래스를 추상 클래스로 선언해줘야 합니다.

## 간단 정리

- 추상 클래스는 `기본 생성자`를 가질 수 있고, 기본 생성자는 상속 관계의 자손 클래스의 `인스턴스`가 생성될 때 호출됩니다.
- 추상 클래스는 `추상 메서드` 없이 작성 가능하고, 추상 메서드를 선언할 경우 `본문`은 상속 관계의 `자손 클래스`에서 작성하게 됩니다.
- 추상 클래스는 `인스턴스화` 할 수 없고, `상속`만 가능합니다.
- 추상 클래스는 `static` 메서드를 정의할 수 있습니다.



final 키워드
Object 클래스


# **References**

자바의 정석 chapter 7

https://www.geeksforgeeks.org/inheritance-in-java/

https://www.geeksforgeeks.org/super-keyword/

https://www.geeksforgeeks.org/overriding-in-java/

https://www.geeksforgeeks.org/dynamic-method-dispatch-runtime-polymorphism-java/

https://www.w3schools.com/java/java_abstract.asp

https://www.geeksforgeeks.org/abstract-classes-in-java/