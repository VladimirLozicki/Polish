import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PolishRecordTest {


    @org.junit.Test
    public void newExpression() throws Exception {
    String actual = PolishRecord.NewExpression("2+2*2");
    String expected = "2 2 2*+";
    assertEquals(actual,expected);

    }


    @Test
    public void toAnswer() {
        double actual = PolishRecord.ToAnswer(PolishRecord.NewExpression("2+2*2"));
        double  expected = 6.0;
        assertEquals(actual,expected);



    }


}