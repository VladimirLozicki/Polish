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
    @After
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
        String actual;
        String expected;
        while ((actual = reader.readLine()) != null) {
            if (!actual.isEmpty()) {
                actualExpression.add(actual);
            }
        }
        while ((expected = reader1.readLine()) != null) {
            if (!expected.isEmpty()) {
                expectedExpression.add(expected);
            }
        }
     Assert.assertEquals(actualExpression, expectedExpression);
    }

    @Test
    @After
    /**
     *
     *check answer actual and expected
     */
    public void calculationResult() {
        try {
            ArrayList<String> actualExpression = new ArrayList<String>();
            ArrayList<String> expectedExpected = new ArrayList<String>();
            BufferedReader reader = new BufferedReader
                    (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualResult.csv"));
            BufferedReader reader1 = new BufferedReader
                    (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expectedResult.csv"));
            String actual;
            String expected;
            while ((actual = reader.readLine()) != null) {
                if (!actual.isEmpty()) {
                    actualExpression.add(actual);
                }
            }
            while ((expected = reader1.readLine()) != null) {
                if (!expected.isEmpty()) {
                    expectedExpected.add(expected);
                }
            }
            Assert.assertEquals(actualExpression, expectedExpected);
        } catch (Exception e) {
            e.getMessage();
        }
    }



    @Test
    @Before
    /**
     * check line expression in the not number
     */
    public void correctExpression() throws  Exception {
        PolishRecord r = new PolishRecord("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expression.csv");
        String s = r.ReadToFile("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expression.csv");
        r.Expression = s.split(" ");


        for (int i=0; i<r.Expression.length; i++) {
            String e = r.CorrectExpression(r.Expression[i]);
            if(e.length()==0){
                continue;
            }
            if(e.length()!=0) {
                System.out.println("This is not number = " + e);
                throw new Exception("Please, correct your expression");
            }
        }
    }
}