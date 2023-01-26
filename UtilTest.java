import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class UtilTest {

    @Test
    public void testReadTwoArrayFromString() {
        String a = "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]";
        var result = Util.readFromStringAs2DArray(a);
        System.out.println(Arrays.deepToString(result));
        assertEquals(3, result.length);
    }
}
