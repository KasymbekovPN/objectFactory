// TODO: 18.12.2021 restore
package ru.kpn.objectFactory.results.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAbstractResultTest {

    private static final Boolean SUCCESS = true;
    private static final Integer VALUE = 123;
    private static final String STATUS = "some status";

    @Test
    void shouldCheckFullConstruction() {
        final AbstractResultWrapper result = new AbstractResultWrapper(SUCCESS, VALUE, STATUS);
        assertThat(SUCCESS).isEqualTo(result.getSuccess());
        assertThat(VALUE).isEqualTo(result.getValue());
        assertThat(STATUS).isEqualTo(result.getStatus());
    }

    @Test
    void shouldCheckStatusConstruction() {
        final AbstractResultWrapper result = new AbstractResultWrapper(SUCCESS, STATUS);
        assertThat(SUCCESS).isEqualTo(result.getSuccess());
        assertThat(result.getValue()).isNull();
        assertThat(STATUS).isEqualTo(result.getStatus());
    }

    @Test
    void shouldCheckValueConstruction() {
        final AbstractResultWrapper result = new AbstractResultWrapper(VALUE);
        assertThat(result.getSuccess()).isTrue();
        assertThat(result.getValue()).isEqualTo(VALUE);
        assertThat(result.getStatus()).isNull();
    }

    private static class AbstractResultWrapper extends AbstractResult<Integer, String> {
        public AbstractResultWrapper(Boolean success, Integer value, String status) {
            super(success, value, status);
        }

        public AbstractResultWrapper(Boolean success, String status) {
            super(success, status);
        }

        public AbstractResultWrapper(Integer value) {
            super(value);
        }
    }
}
