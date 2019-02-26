public class InfixToPostfixConverter implements ExpressionConverterInterface {

    private LinkedStack operatorStack;
    private String infix;
    private String postfix = "";

    public InfixToPostfixConverter() {
        operatorStack = new LinkedStack();
    }

    public InfixToPostfixConverter(LinkedStack stack) {
        operatorStack = stack;
    }

    public String convert(String in) throws InvalidExpressionException {
        infix = in;
        for (int j = 0; j < in.length(); j++) {
            char nextCharacter = in.charAt(j);
            switch (nextCharacter) {
                case '+':
                case '-':
                    while (!operatorStack.isEmpty()) {
                        char top = (char) operatorStack.pop();
                        if (top == '(') {
                            operatorStack.push(top);
                            break;
                        } else {
                            int prec2;
                            if (top == '+' || top == '-') {
                                prec2 = 1;
                            } else {
                                prec2 = 2;
                            }
                            if (prec2 < 1) {
                                operatorStack.push(top);
                                break;
                            } else {
                                postfix += top;
                            }
                        }
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '*':
                case '/':
                    while (!operatorStack.isEmpty()) {
                        char top = (char) operatorStack.pop();
                        if (top == '(') {
                            operatorStack.push(top);
                            break;
                        } else {
                            int prec2;
                            if (top == '+' || top == '-') {
                                prec2 = 1;
                            } else {
                                prec2 = 2;
                            }
                            if (prec2 < 2) {
                                operatorStack.push(top);
                                break;
                            } else {
                                postfix += top;
                            }
                        }
                    }
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    while (!operatorStack.isEmpty()) {
                        char chx = (char) operatorStack.pop();
                        if (chx == '(') {
                            break;
                        } else {
                            postfix += chx;
                        }
                    }
                    break;
                default:
                    postfix += nextCharacter;
                    break;
            }
        }
        while (!operatorStack.isEmpty()) {
            postfix += operatorStack.pop();
        }
        return postfix;
    }
}
