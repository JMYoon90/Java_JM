package edu.java.inheritance04;

public class InheritanceMain04 {

    public static void main(String[] args) {
        // 다형성과 타입 강제 변환(casting) % instanceof 연산자
        Parent ch1 = new Child();
        // ch1 변수는 Parent로 선언되어 있기 때문에 Parent의 메서드만 보임.
        ch1.testParent();
        // ch1은 실제로 Child 타입의 변수이기 때문에 Child의 메서드도 사용할 수 있어야 함.
        ((Child) ch1).testChild(); // 캐스팅을 해서 서브클래스의 명령어도 호출 가능.
        
        Parent ch2 = new AnotherChild();
//        ((Child) ch2).TestChild(); 
        // AnotherChild와 Child 클래스는 서로 casting 될 수 없는 클래스이기 때문에
        // 문법적으로는 가능하나 실행할 때 에러가 발생하게 된다.
        // 변수 instanceof 클래스이름:
        // 변수가 클래스 타입의 인스턴스이면 true, 그렇지 않으면 false.
        // 슈퍼클래스를 가장 마지막에 넣어야 올바르게 검사가능(서브클래스가 슈퍼클래스의 내용을 담고 있기 때문에)
        if (ch2 instanceof Child) {
            ((Child) ch2).testChild();
        } else if (ch2 instanceof AnotherChild) {
            ((AnotherChild) ch2).testAnotherchild();
        }else {
            ch2.testParent();
        }
        
        // final 메서드: override 할 수 없는 메서드.
        // final 클래스: 상속받을 수 없는 클래스.

    }

}

class Parent{
    public void testParent() {
        System.out.println("i'm your father!");
    }
}

class Child extends Parent {
    public void testChild() {
        System.out.println("child...");
    }
}

class AnotherChild extends Parent {
    public void testAnotherchild() {
        System.out.println("another child...");
    }
}