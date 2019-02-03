
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Class Test
 *
 */

public class PolishRecordTest {
    @Test
    /**
     *  сheck answer actual and expected
     */
    public void decodedExpression() throws Exception {
        ArrayList<String> actualExpression = new ArrayList<String>();
        ArrayList<String> expectedExpression = new ArrayList<String>();
        BufferedReader reader = new BufferedReader
                (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualDecoded.csv"));
        BufferedReader reader1 = new BufferedReader
                (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expectedDecoded.csv"));
        String actual="";
        String expected="";
        Read(actual, reader, actualExpression);
        Read(expected, reader1, expectedExpression);
     Assert.assertEquals(actualExpression, expectedExpression);

    }

    @Test
    /**
     *
     *check answer actual and expected
     */
    public void calculationResult() {
        ArrayList<String> actualExpression = new ArrayList<String>();
        ArrayList<String> expectedExpression = new ArrayList<String>();
        String actual="";
        String expected="";
        try {
            BufferedReader reader = new BufferedReader
                    (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualResult.csv"));
            BufferedReader reader1 = new BufferedReader
                    (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expectedResult.csv"));
            Read(actual, reader,actualExpression );
            Read(expected, reader1, expectedExpression);
          assertEquals(actualExpression, expectedExpression);

        } catch (Exception e) {
            e.getMessage();
        }
//        double e = 3.65;
//        double h = 3.64;
//        assertEquals(e, h, 0.01);
    }



    @Test
    /**
     * check line expression in the not number
     */
    public void correctExpression() throws  Exception {
        PolishRecord r = new PolishRecord("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expression.csv");
        String s = r.ReadToFile(r.sourceExpression);
        r.Expression = s.split(" ");
        for (int i=0; i<r.Expression.length; i++) {
            String e = r.CorrectExpression(r.Expression[i]);
            if(e.length()!=0) {
                System.out.println("This is not number = " + e);
                throw new Exception("Please, correct your expression");
            }
        }
    }


    /**
     *
     * @param s
     * @param reader
     * @param expression
     */
    private void Read(String s, BufferedReader reader, ArrayList<String> expression){
        try {
            while ((s = reader.readLine()) != null) {
                if (!s.isEmpty()) {
                    expression.add(s);
                }
            }
        }catch (Exception  e){
            e.getMessage();
        }
    }
}