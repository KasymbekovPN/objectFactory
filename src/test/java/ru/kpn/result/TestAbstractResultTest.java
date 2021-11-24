package ru.kpn.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAbstractResultTest {

    @Test
    void shouldCheckSuccessField() {
        Result result = new Result();
        result.setSuccess(true);
        assertThat(result.getSuccess()).isTrue();
    }

    @Test
    void shouldCheckValueField() {
        Result result = new Result();
        String value = "value";
        result.setValue(value);
        assertThat(result.getValue()).isEqualTo(value);
    }

    @Test
    void shouldCheckStatusField() {
        Result result = new Result();
        int errorCode = 1;
        result.setStatus(new Status(errorCode));
        assertThat(errorCode).isEqualTo(result.getStatus().getErrorCode());
    }

    private static class Result extends AbstractResult<String, Status>{}

    private static class Status {
        private final Integer errorCode;

        public Status(Integer errorCode) {
            this.errorCode = errorCode;
        }

        public Integer getErrorCode() {
            return errorCode;
        }
    }
}
