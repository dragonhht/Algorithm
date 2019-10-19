package stack;

import org.junit.Test;

import java.util.*;

/**
 * 中序、前序及后序表达式.
 *
 * @author: dragonhht
 * @Date: 2019-10-19
 */
public class ExpressionTest {

    // 中序表达式
    private final String expression = "25+4*((42-21)+(3+6/3))";

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

    private String print(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 中序转前序
     * 1、反转输入字符串，
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
    public void testMedToPre() {
        System.out.println("中序表达式为: " + expression);
        System.out.println("前序表达式为: " + print(medToPre(expression)));
    }

    private String[] medToPre(String expression) {
        Stack<String> resultTemp = new Stack<>();
        Stack<String> stack = new Stack<>();
        String[] expStr = handlerExpression(expression);
        for (int i = expStr.length - 1; i >= 0; i--) {
            if (")".equals(expStr[i])) {
                stack.push(")");
                continue;
            }
            if ("+".equals(expStr[i]) || "-".equals(expStr[i])
                    || "/".equals(expStr[i]) || "*".equals(expStr[i])) {
                handleOp(expStr[i], stack, resultTemp);
                continue;
            }
            if ("(".equals(expStr[i])) {
                handlerLeft("", stack, resultTemp, ")");
                continue;
            }
            resultTemp.push(expStr[i]);
        }
        while (stack.size() > 0) {
            resultTemp.push(stack.pop());
        }
        List<String> result = new LinkedList<>();
        while (resultTemp.size() > 0) {
            result.add(resultTemp.pop());
        }
        return result.toArray(new String[0]);
    }

    private void handlerLeft(String op, Stack<String> stack, Stack<String>  sb, String target) {
        if (target.equals(op)) return;
        op = stack.pop();
        if (!target.equals(op)) sb.push(op);
        handlerLeft(op, stack, sb, target);
    }

    private void handleOp(String op, Stack<String> stack, Stack<String> sb) {
        if (stack.size() == 0) {
            stack.push(op);
            return;
        }
        if (stack.peek().equals(")")) {
            stack.push(op);
            return;
        }
        if (checkRunFirst(op, stack.peek())) {
            stack.push(op);
            return;
        }
        sb.push(stack.pop());
        handleOp(op, stack, sb);
    }

    private boolean checkRunFirst(String op, String stackOp) {
        if (Objects.equals(op, stackOp)) return true;
        if ("+".equals(op) || "-".equals(op)) {
            return !("*".equals(stackOp) || "/".equals(stackOp));
        }
        return "*".equals(op) || "/".equals(op);
    }

    /**
     * 中序转后序
     * 1、从字符串中取出下一个字符
     *     2.1.如果是操作数，则直接输出
     *     2.2.如果是“(”，压入栈中
     *     2.3.如果是")"，则将栈中元素依次出栈，直到遇到"("
     *     2.4.若操作遇到"+"、"-"、"*"、"/"，则按一下顺序执行
     *          2.4.1.如果栈为空，此运算符进栈，结束此步骤
     *          2.4.2.如果栈顶元素为"(".此运算符进栈，结束此步骤
     *          2.4.3.如果此运算符比栈顶优先级更高，此运算符进栈，结束此步骤
     *          2.4.4.如果此操作符等于或小于栈顶优先级，则栈顶元素出栈，重复执行2.4，直到操作符被插入
     *     2.5.不在有未处理的字符串了，输出栈中剩余元素
     *     2.6.最终结果则为后序表达式
     */
    @Test
    public void testMedToPost() {
        System.out.println("中序表达式为: " + expression);
        System.out.println("前序表达式为: " + print(medToPost(expression)));
    }

    private String[] medToPost(String expression) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        String[] expStr = handlerExpression(expression);
        for (int i = 0; i < expStr.length; i++) {
            if ("(".equals(expStr[i])) {
                stack.push(expStr[i]);
                continue;
            }
            if (")".equals(expStr[i])) {
                handlerLeftForPost("", stack, queue, "(");
                continue;
            }
            if ("+".equals(expStr[i]) || "-".equals(expStr[i])
                    || "/".equals(expStr[i]) || "*".equals(expStr[i])) {
                handleOpForPost(expStr[i], stack, queue);
                continue;
            }
            queue.add(expStr[i]);
        }
        while (stack.size() > 0) {
            queue.add(stack.pop());
        }
        return queue.toArray(new String[0]);
    }

    private void handleOpForPost(String op, Stack<String> stack, Queue<String> queue) {
        if (stack.size() == 0) {
            stack.push(op);
            return;
        }
        if ("(".equals(stack.peek())) {
            stack.push(op);
            return;
        }
        if (checkRunFirstForPost(op, stack.peek())) {
            stack.push(op);
            return;
        }
        queue.add(stack.pop());
        handleOpForPost(op, stack, queue);
    }

    private void handlerLeftForPost(String op, Stack<String> stack, Queue<String>  queue, String target) {
        if (target.equals(op)) return;
        op = stack.pop();
        if (!target.equals(op)) queue.add(op);
        handlerLeftForPost(op, stack, queue, target);
    }

    private boolean checkRunFirstForPost(String op, String stackOp) {
        int opLevel = opLevel(op);
        int stackLevel = opLevel(stackOp);
        return opLevel > stackLevel;
    }

    private int opLevel(String op) {
        return ("+".equals(op) || "-".equals(op)) ? 1 : 2;
    }
}
