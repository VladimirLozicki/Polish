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

public class PolishRecordTest extends PolishRecord {
    @Test
    @After
    public void decodedExpression() throws Exception {
        ArrayList<String> act = new ArrayList<String>();
        ArrayList<String> ac = new ArrayList<String>();
        BufferedReader reader = new BufferedReader
                (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualDecoded.csv"));
        BufferedReader reader1 = new BufferedReader
                (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expectedDecoded.csv"));
        String actual;
        String expected;
        while ((actual = reader.readLine()) != null) {
            if (!actual.isEmpty()) {
               // System.out.println(actual);
                act.add(actual);
            }
        }
        while ((expected = reader1.readLine()) != null) {
            if (!expected.isEmpty()) {
                // System.out.println(expected);
                ac.add(expected);
            }
        }
     assertEquals(act,ac);
     Assert.assertEquals(act, ac);
    }



    @Test
    @After
    public void toAnswer() throws Exception {
        try {
            ArrayList<String> act1 = new ArrayList<String>();
            ArrayList<String> ac1 = new ArrayList<String>();
            BufferedReader reader = new BufferedReader
                    (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/actualResult.csv"));
            BufferedReader reader1 = new BufferedReader
                    (new FileReader("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expectedResult.csv"));
            String actual;
            String expected;
            while ((actual = reader.readLine()) != null) {
                if (!actual.isEmpty()) {
                    act1.add(actual);
                }
            }
            while ((expected = reader1.readLine()) != null) {
                if (!expected.isEmpty()) {
                    ac1.add(expected);
                }
            }


            Assert.assertEquals(act1, ac1);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test
    @Before
    public void ReadToFile() throws Exception {
        PolishRecord r = new PolishRecord();
        String s = r.ReadToFile("/Users/vladimirlozickiy/Desktop/PolishRecord/src/main/resources/expression.csv");
        String[] Expression = s.split(" ");
        Double f[] = new Double[Expression.length];
        for (int i=0; i<Expression.length; i++) {
            String e = r.CorrectExpression(Expression[i]);
            if(e.length()==0){
               continue;
            }
            if(e.length()!=0) {
                System.out.println("This is not number = " + e);
                throw new Exception("Please, correct your expression");
                //System.out.println(e);
            }
        }
        }

    @Test
    public void calculationResult() {
    }

    @Test
    public void readToFile() {
    }

    @Test
    public void writeToFile() {
    }

    @Test
    public void correctExpression() {
    }
}