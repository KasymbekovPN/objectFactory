package ru.kpn.objectFactory.type;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractDatumTypeTest {

    @Test
    void shouldCheckWithRightType() {
        TestDatumType datumType = new TestDatumType(TestDatumType.TYPES.SOME_TYPE.name());
        assertThat(datumType.isValid()).isTrue();
    }

    @Test
    void shouldCheckWithWrongType() {
        TestDatumType datumType = new TestDatumType("WRONG_TYPE");
        assertThat(datumType.isValid()).isFalse();
    }

    private static class TestDatumType extends AbstractDatumType{
        public TestDatumType(String strType) {
            super(strType);
        }

        @Override
        protected Boolean checkValidity() {
            Set<Object> typeNames = Arrays.stream(TYPES.values()).map((Function<TYPES, Object>) Enum::name).collect(Collectors.toSet());
            return typeNames.contains(strType);
        }

        private enum TYPES{
            SOME_TYPE
        }
    }
}
