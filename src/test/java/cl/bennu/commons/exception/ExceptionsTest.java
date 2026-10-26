package cl.bennu.commons.exception;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionsTest {

    @ParameterizedTest
    @ValueSource(classes = {AppException.class, AuthorizationException.class, ForeignKeyException.class,
            NoDataException.class, UniqueException.class})
    void testConstructors(Class<? extends Exception> clazz) throws Exception {
        Throwable cause = new IllegalStateException("cause");

        Exception empty = clazz.getConstructor().newInstance();
        assertNull(empty.getMessage());
        assertNull(empty.getCause());

        Exception withMessage = clazz.getConstructor(String.class).newInstance("message");
        assertEquals("message", withMessage.getMessage());
        assertNull(withMessage.getCause());

        Exception withMessageAndCause = clazz.getConstructor(String.class, Throwable.class).newInstance("message", cause);
        assertEquals("message", withMessageAndCause.getMessage());
        assertSame(cause, withMessageAndCause.getCause());

        Exception withCause = clazz.getConstructor(Throwable.class).newInstance(cause);
        assertEquals(cause.toString(), withCause.getMessage());
        assertSame(cause, withCause.getCause());

        assertFalse(RuntimeException.class.isAssignableFrom(clazz), "Debe ser una checked exception");
    }

}
