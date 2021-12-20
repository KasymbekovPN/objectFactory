package ru.kpn.objectFactory.results.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SettableMutableResultTest {

    private static final Random RANDOM = new Random();
    private static final Boolean SUCCESS = true;
    private static final Integer VALUE = 123;
    private static final String STATUS = "some status";

    private SettableMutableResult.Builder<Integer, String> builder;
    private TestSetter setter;

    @BeforeEach
    void setUp() {
        builder = SettableMutableResult.<Integer, String>builder();
        setter = new TestSetter(SUCCESS, VALUE, STATUS);
    }

    @Test
    void shouldCheckDefaultSuccessSetting() {
        SettableMutableResult<Integer, String> result = builder.build();
        for (Boolean expectedSuccess : Set.of(false, true)) {
            result.setSuccess(expectedSuccess);
            assertThat(expectedSuccess).isEqualTo(result.getSuccess());
        }
    }

    @RepeatedTest(10)
    void shouldCheckDefaultValueSetting() {
        SettableMutableResult<Integer, String> result = builder.build();
        int expectedValue = RANDOM.nextInt();
        result.setValue(expectedValue);
        assertThat(expectedValue).isEqualTo(result.getValue());
    }

    @RepeatedTest(10)
    void shouldCheckDefaultStatusSetting() {
        SettableMutableResult<Integer, String> result = builder.build();
        String expectedStatus = String.valueOf(RANDOM.nextInt());
        result.setStatus(expectedStatus);
        assertThat(expectedStatus).isEqualTo(result.getStatus());
    }

    @Test
    void shouldCheckSuccessSettingWithSetter() {
        SettableMutableResult<Integer, String> result = builder.successSetter(setter).build();
        for (Boolean success : Set.of(false, true)) {
            result.setSuccess(success);
            assertThat(SUCCESS).isEqualTo(result.getSuccess());
            assertThat(VALUE).isEqualTo(result.getValue());
            assertThat(STATUS).isEqualTo(result.getStatus());
        }
    }

    @Test
    void shouldCheckValueSettingWithSetter() {
        SettableMutableResult<Integer, String> result = builder.valueSetter(setter).build();
        result.setValue(0);
        assertThat(SUCCESS).isEqualTo(result.getSuccess());
        assertThat(VALUE).isEqualTo(result.getValue());
        assertThat(STATUS).isEqualTo(result.getStatus());
    }

    @Test
    void shouldCheckStatusSettingWithSetter() {
        SettableMutableResult<Integer, String> result = builder.statusSetter(setter).build();
        result.setStatus("");
        assertThat(SUCCESS).isEqualTo(result.getSuccess());
        assertThat(VALUE).isEqualTo(result.getValue());
        assertThat(STATUS).isEqualTo(result.getStatus());
    }

    private static class TestSetter extends SettableMutableResult.Setter<Integer, String>{
        public TestSetter(Boolean success, Integer value, String status) {
            this.success = success;
            this.value = value;
            this.status = status;
        }

        @Override
        public void calculate(Result<Integer, String> result) {}
    }
}