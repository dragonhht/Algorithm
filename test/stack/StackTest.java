package stack;

import org.junit.Test;
import stack.linear.LinearStack;
import stack.orader.OraderStack;
import java.util.Stack;

/**
 * Java栈.
 * User: huang
 * Date: 17-7-10
 */
public class StackTest {

    /**
     * Java自带栈类的测试.
     */
    @Test
    public void testStack() {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < 1000; i++) {
            stack.add("" + i);
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 测试顺序栈.
     */
    @Test
    public void testOraderStack() {
        OraderStack<String> stack = new OraderStack<>();
        for (int i = 0; i < 500; i++) {
            stack.push("" + i);
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 测试链式栈.
     */
    @Test
    public void testLinearStack() {
        LinearStack<String> stack = new LinearStack<>();
        for (int i = 0; i < 500; i++) {
            stack.push("" + i);
        }
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pop());
        }
    }
}
