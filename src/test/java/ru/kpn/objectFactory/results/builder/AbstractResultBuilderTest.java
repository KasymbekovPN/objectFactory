package ru.kpn.objectFactory.results.builder;

import org.junit.jupiter.api.Test;
import ru.kpn.objectFactory.results.result.Result;
import ru.kpn.objectFactory.results.result.SimpleResult;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractResultBuilderTest {
    private static final Integer VALUE = 123;
    private static final String STATUS = "some status";

    @Test
    void shouldCheckSuccessBuilding() {
        Result<Integer, String> result = new ResultBuilderWrapper(true).buildResult();
        assertThat(result.getSuccess()).isTrue();
        assertThat(result.getValue()).isEqualTo(VALUE);
        assertThat(result.getStatus()).isNull();
    }

    @Test
    void shouldCheckFailBuilding() {
        Result<Integer, String> result = new ResultBuilderWrapper(false).buildResult();
        assertThat(result.getSuccess()).isFalse();
        assertThat(result.getValue()).isNull();
        assertThat(result.getStatus()).isEqualTo(STATUS);
    }

    private static class ResultBuilderWrapper extends AbstractResultBuilder<Integer, String>{

        public ResultBuilderWrapper(Boolean success) {
            this.success = success;
        }

        @Override
        protected Result<Integer, String> buildOnSuccess() {
            return new SimpleResult<>(VALUE);
        }

        @Override
        protected Result<Integer, String> buildOnFailure() {
            return new SimpleResult<>(success, STATUS);
        }
    }
}