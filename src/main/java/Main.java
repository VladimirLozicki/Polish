
import java.io.*;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        PolishRecord expr = new PolishRecord("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expression.csv");
        expr.sourceExpression = expr.ReadToFile("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expression.csv");
        expr.Expression = expr.sourceExpression.split(" ");
        expr.Decoded = new String[expr.Expression.length];
        expr.answer = new String[expr.Expression.length];
        PolishRecord record = new PolishRecord("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expression.csv");
        for(int i = 0; i< expr.Expression.length; i++) {
            expr.Decoded[i] =record.decodedExpression(expr.Expression[i]);
            expr.answer[i] = String.valueOf(record.calculationResult(expr.Decoded[i]));
        }
        record.WriteToFile("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualResult.csv", expr.answer);
        record.WriteToFile("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualDecoded.csv", expr.Decoded);
    }


}





