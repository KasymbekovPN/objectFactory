package ru.kpn.objectFactory.results.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleResultTest {

    private static final Boolean SUCCESS = true;
    private static final Integer VALUE = 123;
    private static final String STATUS = "some status";

    @Test
    void shouldCheckFullConstruction() {
        final SimpleResult<Integer, String> result = new SimpleResult<>(SUCCESS, VALUE, STATUS);
        assertThat(SUCCESS).isEqualTo(result.getSuccess());
        assertThat(VALUE).isEqualTo(result.getValue());
        assertThat(STATUS).isEqualTo(result.getStatus());
    }

    @Test
    void shouldCheckStatusConstruction() {
        final SimpleResult<Integer, String> result = new SimpleResult<>(SUCCESS, STATUS);
        assertThat(SUCCESS).isEqualTo(result.getSuccess());
        assertThat(result.getValue()).isNull();
        assertThat(STATUS).isEqualTo(result.getStatus());
    }

    @Test
    void shouldCheckValueConstruction() {
        final SimpleResult<Integer, String> result = new SimpleResult<>(VALUE);
        assertThat(result.getSuccess()).isTrue();
        assertThat(result.getValue()).isEqualTo(VALUE);
        assertThat(result.getStatus()).isNull();
    }
}
