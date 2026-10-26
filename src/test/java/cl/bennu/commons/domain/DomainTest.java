package cl.bennu.commons.domain;

import cl.bennu.commons.domain.base.BaseDomain;
import cl.bennu.commons.domain.base.Error;
import cl.bennu.commons.domain.base.LightDomain;
import cl.bennu.commons.domain.base.StackTrace;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DomainTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testBaseDomain() {
        BaseDomain domain = new BaseDomain();
        domain.setId(1L);
        domain.setActive(true);
        domain.setInUse(false);

        BaseDomain other = new BaseDomain();
        other.setId(1L);
        other.setActive(true);
        other.setInUse(false);

        assertEquals(domain, other);
        assertEquals(domain.hashCode(), other.hashCode());

        other.setInUse(true);
        assertNotEquals(domain, other);
    }

    @Test
    void testExample() {
        Example example = new Example();
        example.setId(1L);
        example.setName("name");
        example.setActive(true);

        Example other = new Example();
        other.setId(1L);
        other.setName("name");
        other.setActive(true);

        assertEquals(example, other);
        assertEquals(example.hashCode(), other.hashCode());

        other.setName("other");
        assertNotEquals(example, other);
    }

    @Test
    void testExampleJsonRoundTrip() {
        Example example = new Example();
        example.setId(1L);
        example.setName("name");
        example.setActive(true);

        Example result = objectMapper.readValue(objectMapper.writeValueAsString(example), Example.class);
        assertEquals(example, result);
    }

    @Test
    void testLightDomain() {
        LightDomain domain = new LightDomain();
        assertNull(domain.getId());
        assertNull(domain.getName());
        assertNull(domain.getTag());
    }

    @Test
    void testLightDomainFromJson() {
        LightDomain domain = objectMapper.readValue("{\"id\":1,\"name\":\"name\",\"tag\":\"tag\"}", LightDomain.class);
        assertEquals(1L, domain.getId());
        assertEquals("name", domain.getName());
        assertEquals("tag", domain.getTag());
    }

    @Test
    void testError() {
        StackTrace stackTrace = new StackTrace();
        stackTrace.setClazz("cl.bennu.Clazz");
        stackTrace.setMethod("method");
        stackTrace.setLine(10);
        stackTrace.setError("error");

        Error error = new Error();
        error.setType("type");
        error.setCode(500);
        error.setError("error");
        error.setStackTraces(List.of(stackTrace));

        assertEquals("type", error.getType());
        assertEquals(500, error.getCode());
        assertEquals("error", error.getError());
        assertEquals(1, error.getStackTraces().size());
        assertEquals("cl.bennu.Clazz", error.getStackTraces().get(0).getClazz());
        assertEquals("method", error.getStackTraces().get(0).getMethod());
        assertEquals(10, error.getStackTraces().get(0).getLine());
        assertEquals("error", error.getStackTraces().get(0).getError());
    }

}
