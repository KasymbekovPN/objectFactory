// TODO: 18.12.2021 restore
//package ru.kpn.objectFactory.factory;
//
//import org.junit.jupiter.api.Test;
//import ru.kpn.objectFactory.datum.AbstractDatum;
//import ru.kpn.objectFactory.results.result.AbstractResult;
//import ru.kpn.objectFactory.results.result.Result;
//import ru.kpn.objectFactory.type.AbstractDatumType;
//
//import java.util.Arrays;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class AbstractObjectFactoryTest {
//
//    private static final String WRONG = "WRONG";
//
//    @Test
//    void shouldCheckSuccessCreation() {
//        String value = "value";
//        TestDatum datum = new TestDatum(value);
//        datum.setType(TestDatumType.TYPES.TYPE_0.name());
//        TestFactory factory = new TestFactory();
//        Result<String, String> result = factory.create(datum);
//
//        assertThat(result.getSuccess()).isTrue();
//        assertThat(result.getValue()).isEqualTo(value);
//    }
//
//    @Test
//    void shouldCheckFailCreation() {
//        String value = "value";
//        TestDatum datum = new TestDatum(value);
//        datum.setType(WRONG);
//        TestFactory factory = new TestFactory();
//        Result<String, String> result = factory.create(datum);
//
//        assertThat(result.getSuccess()).isFalse();
//        assertThat(result.getStatus()).isEqualTo(WRONG);
//    }
//
//    private static class TestFactory extends AbstractObjectFactory<TestDatum, String, String>{
//        @Override
//        protected Result<String, String> getResult(TestDatum datum) {
//            TestResult result = new TestResult();
//            result.setSuccess(true);
//            result.setValue(datum.getValue());
//            return result;
//        }
//
//        @Override
//        protected Result<String, String> getWrongResult(TestDatum datum) {
//            TestResult result = new TestResult();
//            result.setSuccess(false);
//            result.setStatus(WRONG);
//            return result;
//        }
//    }
//
//    private static class TestResult extends AbstractResult<String, String>{}
//
//    private static class TestDatum extends AbstractDatum<TestDatumType>{
//
//        private final String value;
//
//        public TestDatum(String value) {
//            this.value = value;
//        }
//
//        @Override
//        public void setType(String type) {
//            this.type = new TestDatumType(type);
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//
//    private static class TestDatumType extends AbstractDatumType{
//
//        public TestDatumType(String strType) {
//            super(strType);
//        }
//
//        @Override
//        protected Boolean checkValidity() {
//            Set<String> allowedTypes = Arrays.stream(TYPES.values()).map(Enum::name).collect(Collectors.toSet());
//            return allowedTypes.contains(strType);
//        }
//
//        public enum TYPES{
//            TYPE_0
//        }
//    }
//}