package ru.kpn.objectFactory.datum;

import org.junit.jupiter.api.Test;
import ru.kpn.objectFactory.type.DatumType;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractDatumTest {

    @Test
    void shouldCheckTypeGetting() {
        String key = "some.key";
        TestDatum datum = new TestDatum();
        datum.setType(key);
        assertThat(datum.getType()).isEqualTo(new TestDatumType(key));
    }

    private static class TestDatum extends AbstractDatum<TestDatumType>{
        @Override
        public void setType(String type) {
            this.type = new TestDatumType(type);
        }
    }

    private static class TestDatumType implements DatumType {
        private final String key;

        public TestDatumType(String key) {
            this.key = key;
        }

        @Override
        public Boolean isValid() {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestDatumType that = (TestDatumType) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
