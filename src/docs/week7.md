# package

Java의 패키지는 클래스, 하위 패키지 및 인터페이스 그룹을 캡슐화하는 메커니즘입니다. 패키지는 다음 용도로 사용됩니다.

- 중복 클래스 이름 방지
- 클래스, 인터페이스, enum 클래스, 애노테이션의 검색과 찾기를 쉽게 만들어줍니다.
- `protected` `default` 는 패키지 수준의 접근 제어자입니다. 
    - `protected`는 동일한 패키지 및 `protected` 메서드를 가지고 있는 클래스의 하위 클래스에서만 호출할 수 있습니다.
    - `default`는 동일한 패키지 클래스에서만 호출할 수 있습니다. (하위 패키지도 X)

## package가 동작하는 방법

- 패키지와 디렉토리 구조는 밀접하게 관련되어 있습니다.
- 패키지 이름이 college.staff.cse인 경우 세 개의 디렉토리, college, staff, cse가 있으므로
    - cse는 staff에
    - staff는 college에 있습니다.
    - college 디렉토리는 `CLASSPATH` 변수를 통해 접근할 수 있습니다.
        - college의 상위 디렉토리 경로는 `CLASSPATH`에 존재합니다.

## 패키지 내부의 클래스 접근 방법

```java
import java.util.vector;
import java.util.*;
```
- `java` 내부의 `util` 패키지에서 Vector 클래스를 가져옵니다.
- `*`은 `util` 패키지 하위 클래스를 모두 가져옵니다.

## 패키지 유형

- 패키지는 내장 패키지와 사용자 지정 패키지가 있습니다.

### 내장 패키지

- 내장 패키지는 많은 `Java API`로 구성되어 있습니다.
- 자주 사용되는 내장 패키지는 아래와 같습니다.

#### 1. Java.lang

- 언어 지원 클래스를 포함하고 있습니다.
- 이 패키지는 자동으로 가져옵니다. (import로 명시되지 않음)

#### 2. Java.io

- 입출력 작업을 지원하기 위한 클래스를 포함하고 있습니다.

#### 3. Java.util

- List, Map과 같은 데이터 구조를 구현하는 유틸리티 클래를 포함합니다.

#### 4. Java.applet

- 애플릿을 생성하기 위한 클래스를 포함합니다.

#### 5. Java.awt

- GUI 구성요소를 구현하기 위한 클래스를 포함합니다.

#### 6. Java.net

- 네트워킹 작업을 지원하기 위한 클래스를 포함합니다.

### 사용자 지정 패키지

- 사용자가 정의한 패키지입니다.
- 디렉토리를 만들고 디렉토리 아래에 클래스를 만듭니다.
    - 클래스 첫 줄에 package 이름을 명시해야합니다.

## static import

- `static import`는 Java 5에 도입된 기능입니다.
- 해당 필드가 정의된 클래스를 지정하지 않고 클래스에 `public static`으로 정의된 멤버, 메서드를 Java 코드에서 사용할 수 있습니다.
- `static import`의 예시는 아래와 같습니다.

```java
import static java.lang.System.*;

class StaticImportEx {

    public static void main(String[] args) {
        out.println("Hello!");
    }
}
```

# Reference

https://www.geeksforgeeks.org/packages-in-java/

