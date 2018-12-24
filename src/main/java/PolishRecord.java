import java.util.Stack;

public class PolishRecord {

    public static String NewExpression(String expr){

        String current= "";
        Stack<Character> stack = new Stack<Character>();
        int priority;
        for(int i=0; i<expr.length(); i++){
            priority= GetPriority(expr.charAt(i));
            if(priority==0) current+=expr.charAt(i);
            if(priority==1){
                stack.push(expr.charAt(i));
            }
            if(priority>1){
                current+= ' ';

                while(!stack.empty()){
                    if(GetPriority(stack.peek()) >= priority)
                        current+=stack.pop();
                    else break;
                }
                stack.push(expr.charAt(i));
            }
            if(priority == -1){
                current +=' ';
                while(GetPriority(stack.peek()) !=1 )current+=stack.pop();
                stack.pop();
            }
        }
        while(!stack.empty())current+=stack.pop();
        return current;
    }



    public static double ToAnswer(String rpn){
        String operand = new String();
        Stack<Double> stack= new Stack<Double>();

        for(int i=0; i<rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') continue;

            if (GetPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && GetPriority(rpn.charAt(i)) == 0) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length())
                        break; }

                stack.push(Double.parseDouble(operand));
                operand = new String();
            }

            if (GetPriority(rpn.charAt(i)) > 1) {
                double a = stack.pop(), b = stack.pop();
                if (rpn.charAt(i) == '+') stack.push(b + a);
                if (rpn.charAt(i) == '-') stack.push(b - a);
                if (rpn.charAt(i) == '*') stack.push(b * a);
                if (rpn.charAt(i) == '/') stack.push(b / a);
            }

        }
        return stack.pop();
    }

    private static int GetPriority(char a){
        switch(a){
            case '*': case '/':
                return 3;
            case '+':  case '-':
                return 2;
            case '(':
                return 1;
            case ')':
                return -1;
            default:
                return 0;
        }
    }


}
