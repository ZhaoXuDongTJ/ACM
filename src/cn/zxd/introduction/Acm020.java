package cn.zxd.introduction;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author 921982
 */

public class Acm020 {
    /**
     * My code --Accepted
     * 1.特殊输入  "(" ")" "((" "([)"
     * 2.注意输入的位数;
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<String> container = new Stack<String>();
        if(s.charAt(0)==')'||s.charAt(0)==']'||s.charAt(0)=='}'||s.length()==1){
            return false;
        }else{
            container.push(s.charAt(0)+"");
        }

        int point = 1;
        for(int i=0;i<s.length()-1;i++,point++){



            switch (s.charAt(point)) {
                case '(':
                    container.push("(");
                    break;
                case ')':
                    if(!container.empty()){
                        if("(".equals(container.peek())){
                            container.pop();
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                    break;
                case '[':
                    container.push("[");
                    break;
                case ']':
                    if(!container.empty()){
                        if("[".equals(container.peek())){
                            container.pop();
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                    break;
                case '{':
                    container.push("{");
                    break;
                case '}':
                    if(!container.empty()){
                        if("{".equals(container.peek())){
                            container.pop();
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }

                    break;

                default:
                    return false;
            }
        }

        if(container.isEmpty()){
            return true;
        }else {
            return false;
        }

    }

    /***
     * Best code
     * 并非使用stack。使用数组。
     * 有一个开就有一个关，最后数组里面如果没符号 那就是空。
     * @param s
     * @return
     */
    public boolean isValidOne(String s) {
        char[] input = new char[s.length()];
        int head = 0;
        input = s.toCharArray();
        for(int i = 0; i < input.length; i++) {
            switch(input[i]) {
                case '(':
                case '[':
                case '{':
                    input[head++] = input[i];
                    break;
                case ')':
                    if(head == 0 || input[--head] != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if(head == 0 || input[--head] != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if(head == 0 || input[--head] != '{') {
                        return false;
                    }
                    break;
            }
        }

        return head == 0;
    }


}
