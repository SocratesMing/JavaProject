package szm;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class AssertTests {

    @Test(timeout=100)
    public void testWithTimeout() {
        try {
            TimeUnit.SECONDS.sleep(103);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExceptionMessage() {
        List<Object> list = new ArrayList<>();

        try {
            list.get(0);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    @Test
    public void testExceptionAndState() {
        List<Object> list = new ArrayList<>();

        IndexOutOfBoundsException thrown = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.add(1, new Object()));

        // assertions on the thrown exception
        assertEquals("Index: 1, Size: 0", thrown.getMessage());
        // assertions on the state of a domain object after the exception has been thrown
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }

    @Test
    public void testAssertEquals() {
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void testAssertFalse() {
        assertFalse("failure - should be false", false);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull("should not be null", new Object());
    }

    @Test
    public void testAssertNotSame() {
        assertNotSame("should not be same Object", new Object(), new Object());
    }

    @Test
    public void testAssertNull() {
        assertNull("should be null", null);
    }

    @Test
    public void testAssertSame() {
        Integer aNumber = Integer.valueOf(768);
        assertSame("should be same", aNumber, aNumber);
    }

    @Test
    public void testAssertTrue() {
        assertTrue("failure - should be true", true);
    }
}
