import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Here realiazation transfer in polish
 * record and calculation expression
 */
public class PolishRecord {
    private static final char MINUS = '-';
    private static final char PLUS = '+';
    private static final char MULTIPLY = '*';
    private static final char DIVIDED = '/';
    private static final char SPACE = ' ';
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';
    public  int priority;
    public String sourceExpression;
    String[] Expression;
    String [] Decoded;
    String [] answer;

    /**
     * constructor
     * @param sourceExpression
     */
    public PolishRecord(String sourceExpression) {

        this.sourceExpression = sourceExpression;
    }

    /**
     * first method
     *
     * @param sourceExpression
     * @return String polishRecord
     */

    public String decodedExpression(String sourceExpression) {
        StringBuffer polishRecord = new StringBuffer();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < sourceExpression.length(); i++) {
            priority = GetPriority(sourceExpression.charAt(i));

            switch (priority) {
                case 0:
                    PriorityZero(polishRecord, sourceExpression, i);
                    break;
                case 1:
                    PriorityOne(stack, i,sourceExpression);
                    break;
                case -1:
                    PriorityLessOne(polishRecord, stack);
                    break;
                case 2 :
                    case 3:
                        polishRecord.append(SPACE);
                        while (!stack.isEmpty()) {
                            if (GetPriority(stack.peek()) >= priority) {
                                polishRecord.append(stack.pop());
                            } else break;
                        }
                        stack.push(sourceExpression.charAt(i));
                      //  PriorityMoveOne(polishRecord, stack, i, priority);
            }
        }
        Append(polishRecord, stack);
        return polishRecord.toString();
    }

    /**
     *
     * @param polishRecord
     * @param sourceExpression
     * @param i
     */
    private void PriorityZero(StringBuffer polishRecord, String sourceExpression, int i){
            polishRecord.append(sourceExpression.charAt(i));
    }

    /**
     *
     * @param stack
     * @param i
     * @param sourceExpression
     */
    private void PriorityOne(ArrayDeque<Character> stack , int i, String sourceExpression){
        stack.push(sourceExpression.charAt(i));
    }

    /**
     *
     * @param polishRecord
     * @param stack
     */
    private void PriorityLessOne(StringBuffer polishRecord, ArrayDeque<Character> stack){
        polishRecord.append(SPACE);
        while (GetPriority(stack.peek()) != 1) {
            polishRecord.append(stack.pop());
        }
        stack.pop();
    }

    /**
     *
     * @param polishRecord
     * @param stack
     */
    private void Append(StringBuffer polishRecord, ArrayDeque<Character>stack){
        while (!stack.isEmpty()) {
            polishRecord.append(stack.pop());
        }
    }

    /**
     *  Get input string with decodedExpression,
     *  calculate this expression and return value
     *  @param decodedExpression return method decodedExpression
     */
    StringBuffer br = new StringBuffer();
    ArrayDeque<Double> stack = new ArrayDeque<Double>();
    public double calculationResult(String decodedExpression) {

        for (int i = 0; i < decodedExpression.length(); i++) {
           switch (decodedExpression.charAt(i)){
               case SPACE:
                   continue;

           }
           switch (GetPriority(decodedExpression.charAt(i))){
               case 0:
                   while (decodedExpression.charAt(i) != SPACE && GetPriority(decodedExpression.charAt(i)) == 0) {
                       br.append(decodedExpression.charAt(i++));
                       if (i == decodedExpression.length()) {
                           break;
                       }
                   }
                   stack.push(Double.parseDouble(br.toString()));
                   br = new StringBuffer();
            }
            if (GetPriority(decodedExpression.charAt(i)) > 1) {
                CalculationSign(decodedExpression, i);
            }
        }
        return stack.pop();
    }

    /**
     *
     * @param decodedExpression
     * @param i
     */

    private void CalculationSign(String decodedExpression, int i){
        double a = stack.pop(), b = stack.pop();
        if (decodedExpression.charAt(i) == PLUS) {
            stack.push(b + a);
        }
        else if (decodedExpression.charAt(i) == MINUS) {
            stack.push(b - a);
        }
        else if (decodedExpression.charAt(i) == MULTIPLY) {
            stack.push(b * a);
        }
        else  if(decodedExpression.charAt(i) == DIVIDED) {
            stack.push(b / a);
        }
    }

/**
 * Get priority
   @param a
 */
    private  int GetPriority(char a) {
        switch (a) {
            case MULTIPLY:
            case DIVIDED:
                return 3;
            case PLUS:
            case MINUS:
                return 2;
            case LEFT_BRACKET:
                return 1;
            case RIGHT_BRACKET:
                return -1;
            default:
                return 0;
        }
    }

/**
  Method reading input file with expression
  @param name input name file
 */

    public String ReadToFile(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    sourceExpression=str;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return sourceExpression;
    }

/**
 Writting to file data
 @param name this parametr set name writting file
 @param s [] s massive Expression
 */

    public String[] WriteToFile(String name, String [] s) {
        try {

            FileWriter writer = new FileWriter(name);
            for(int i=0;i<s.length; i++) {
                writer.write(s[i]);
                writer.append('\n');
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

/**
 * Get line of file Expression and checks on other
 * symbols, such us !@#$%^& etc.
 * @param s input string with expression
 */

    public  String CorrectExpression(String s ){
         StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++){
            char p = s.charAt(i);
            switch (p){
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                    continue;
            }
            if(p < 47 || p > 58 ){
                sb.append(p);
           }
        }
        return sb.toString();
    }
}