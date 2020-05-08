package stack;

import node.Node;
import org.junit.Test;
import stack.linear.LinearStack;
import stack.orader.OraderStack;

import java.util.LinkedList;
import java.util.List;
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

    @Test
    public void testCalculate() {
        String expression = "3*5-4*(5-4)*((1+1)*(3-1))+3";
        // 计算括号
        String result = calculate(expression);
        System.out.println(expression + " = " + result);
    }

    private String calculate(String expression) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Stack<Character> all = new Stack<>();
        double num = 0.0;
        boolean hasNum = false;
        int index = 0;
        for (char ch : expression.toCharArray()) {
            all.push(ch);
            index++;
            switch (ch) {
                case '(':
                    if (hasNum)
                        vals.push(num);
                    hasNum = false;
                    num = 0;
                    break;
                case '+':
                    if (hasNum)
                        vals.push(num);
                    hasNum = false;
                    num = 0;
                    ops.push("+");
                    break;
                case '-':
                    if (hasNum)
                        vals.push(num);
                    hasNum = false;
                    num = 0;
                    ops.push("-");
                    break;
                case '*':
                    if (hasNum)
                        vals.push(num);
                    hasNum = false;
                    num = 0;
                    ops.push("*");
                    break;
                case '/':
                    if (hasNum)
                        vals.push(num);
                    hasNum = false;
                    num = 0;
                    ops.push("/");
                    break;
                case  ')':
                    if (hasNum)
                        vals.push(num);
                    hasNum = false;
                    num = 0;
                    Double n2 = vals.pop();
                    double n1 = vals.pop();
                    String op = ops.pop();
                    Double result = getVal(n1, n2, op);
                    // TODO 当前数值只有一位
                    all.pop();
                    all.pop();
                    all.pop();
                    all.pop();
                    all.pop();
                    all.push(String.valueOf(result.intValue()).toCharArray()[0]);
                    vals.push(result);
                    System.out.println(n1 + op + n2 + "=" + result);
                    break;
                default:
                    hasNum = true;
                    num = num * 10 + convertDouble(ch);
                    if (index >= expression.length() - 1)
                        vals.push(num);
            }
        }
        char[] chars = new char[all.size()];
        for (int i = all.size() - 1; i >= 0; i--) {
            chars[i] = all.pop();
        }
        return new String(chars);
    }

    private Double convertDouble(Character ch) {
        return Double.parseDouble(ch.toString());
    }

    private Double getVal(double n1, double n2, String operator) {
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                return 0.0;
        }
    }

    @Test
    public void test_1_3_4() {
        String str = "{[()]}()";
        boolean ok = false;
        Stack<Character> stack = new Stack<>();
        for (Character ch : str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
            if (ch == '}' || ch == ']' || ch == ')') {
                stack.pop();
            }
        }
        if (stack.size() == 0) ok = true;
        if (ok) System.out.println("括号匹配");
        else System.out.println("括号不完全匹配");
    }

    /**
     * 中序转前序
     * 1、反转输入字符串，如“2*3/(2-1)+3*(4-1)” 反转后为“ )1-4(*3+)1-2(/3*2”，
     * 2、从字符串中取出下一个字符
     * 　　2.1.如果是操作数，则直接输出
     * 　　2.2.如果是“)”，压入栈中
     * 　　2.3.如果是运算符但不是“(”，“)”,则不断循环进行以下处理
     * 　　　　2.3.1.如果栈为空，则此运算符进栈，结束此步骤
     * 　　　　2.3.2.如果栈顶是“)”,则此运算符进栈，结束此步骤
     * 　　　　2.3.2.如果此运算符与栈顶优先级相同或者更高，此运算符进栈，结束此步骤
     * 　　　　2.3.4.否则，运算符连续出栈，直到满足上述三个条件之一，然后此运算符进栈
     * 　　2.4、如果是“(”，则运算符连续出栈，直到遇见“)”为止,将“)”出栈且丢弃之
     * 3、如果还有更多的字符串，则转到第2步
     * 4、不在有未处理的字符串了，输出栈中剩余元素
     * 5、再次反转字符串得到最终结果
     */
    @Test
    public void test() {
        String str = "2*3/(2-1)+3*(4-1)";
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ')') {
                stack.push(")");
                continue;
            }
            if (chars[i] == '+' || chars[i] == '-' || chars[i] == '/' || chars[i] == '*') {
                handleOp(chars[i], stack, sb);
                continue;
            }
            if (chars[i] == '(') {
                handlerLeft(' ', stack, sb);
                continue;
            }
            sb.append(chars[i]);
        }
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chs = sb.toString().toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            stringBuilder.append(chs[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    private void handlerLeft(char op, Stack<String> stack, StringBuilder sb) {
        if (op == ')') return;
        op = stack.pop().charAt(0);
        if (op != ')') sb.append(op);
        handlerLeft(op, stack, sb);
    }

    private void handleOp(char op, Stack<String> stack, StringBuilder sb) {
        if (stack.size() == 0) {
            stack.push(String.valueOf(op));
            return;
        }
        if (stack.peek().equals(")")) {
            stack.push(String.valueOf(op));
            return;
        }
        if (checkRunFirst(op, stack.peek().charAt(0))) {
            stack.push(String.valueOf(op));
            return;
        }
        sb.append(stack.pop());
        handleOp(op, stack, sb);
    }

    private boolean checkRunFirst(char op, char stackOp) {
        if (op == stackOp) return true;
        if (op == '+' || op == '-') {
            return stackOp != '*' && stackOp != '/';
        }
        return op == '*' || op == '/';
    }

    @Test
    public void testHandlerExpression() {
        String str = "3*23+25*((2+3)+(3-1))+2";
    }

    /**
     * 获取表达式数组，多位数值为一个
     * @param expression
     * @return
     */
    private String[] handlerExpression(String expression) {
        List<String> list = new LinkedList<>();
        boolean flag = false;
        int num = 0;
        for (char ch : expression.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                flag = true;
                num = 10 * num + Integer.parseInt(String.valueOf(ch));
            } else {
                if (flag) {
                    list.add(String.valueOf(num));
                    flag = false;
                    num = 0;
                }
                list.add(String.valueOf(ch));
            }
        }
        if (flag) {
            list.add(String.valueOf(num));
        }
        return list.toArray(new String[0]);
    }

    @Test
    public void testMaxFromLink() {
        Node<Integer> first = new Node<>(2, null);
        Node<Integer> p = first;
        for (int i = 0; i < 45; i++) {
            Node<Integer> node = new Node<>(i, null);
            p.setNext(node);
            p = node;
        }
        System.out.println(getMaxFrom(first, 0));
    }

    private int getMaxFrom(Node<Integer> node, int max) {
        if (node == null) return max;
        if (node.getData() > max) max = node.getData();
        return getMaxFrom(node.getNext(), max);
    }
}
