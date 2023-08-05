package java_lab.inheritance.inheritance1;

import java_lab.inheritance.inheritance1.exClass.B;
import java_lab.inheritance.inheritance1.exClass.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class AInterfaceTest {

    @DisplayName("")
    @Test
    public void name() {
        //given
        B b = new B();
        C c = new C();

        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");

        stack.add(0, "4");

        Assertions.assertEquals("4", stack.pop()); // false

        //when
        //then
    }
}