
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {

//
//
      PolishRecord expression = new PolishRecord();
        String s = expression.ReadToFile("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expression.csv");
        String[] Expression = s.split(" ");
        //PolishRecord t =new PolishRecord();
        //System.out.println(expression.CorrectExpression(Expression[0]));


        String [] Decoded = new String[Expression.length];
        String [] answer = new String[Expression.length];
        PolishRecord r = new PolishRecord();
        for(int i = 0; i< Expression.length; i++) {
            Decoded[i] =r.decodedExpression(Expression[i]);
            answer[i] = String.valueOf(r.calculationResult(Decoded[i]));
           // System.out.println(Decoded[i]);
            //System.out.println(answer[i]);
        }
        r.WriteToFile("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualResult.csv", answer);

        r.WriteToFile("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualDecoded.csv", Decoded);





    }


}





