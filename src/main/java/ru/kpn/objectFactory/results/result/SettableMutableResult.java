package ru.kpn.objectFactory.results.result;

public class SettableMutableResult<V, S> implements MutableResult<V, S> {
    private final Setter<V,S> successSetter;
    private final Setter<V,S> valueSetter;
    private final Setter<V,S> statusSetter;

    private Boolean success;
    private V value;
    private S status;

    public static <V, S> Builder<V, S> builder(){
        return new Builder<>();
    }

    public static <V, S> SettableMutableResult<V,S> defaultResult(){
        return SettableMutableResult.<V, S>builder().build();
    }

    private SettableMutableResult(Setter<V, S> successSetter, Setter<V, S> valueSetter, Setter<V, S> statusSetter) {
        this.successSetter = successSetter;
        this.valueSetter = valueSetter;
        this.statusSetter = statusSetter;
    }

    @Override
    public void setSuccess(Boolean success) {
        if (calculateAndUpdate(successSetter))
            return;
        this.success = success;
    }

    @Override
    public void setValue(V value) {
        if (calculateAndUpdate(valueSetter))
            return;
        this.value = value;
    }

    @Override
    public void setStatus(S status) {
        if (calculateAndUpdate(statusSetter))
            return;
        this.status = status;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public S getStatus() {
        return status;
    }

    private boolean calculateAndUpdate(Setter<V,S> setter) {
        final boolean result = setter != null;
        if (result){
            setter.calculate(this);
            this.success = setter.getSuccess();
            this.value = setter.getValue();
            this.status = setter.getStatus();
        }
        return result;
    }

    public static class Builder<V, S>{
        private Setter<V,S> successSetter;
        private Setter<V,S> valueSetter;
        private Setter<V,S> statusSetter;

        public Builder<V, S> successSetter(Setter<V, S> successSetter){
            this.successSetter = successSetter;
            return this;
        }

        public Builder<V, S> valueSetter(Setter<V, S> valueSetter){
            this.valueSetter = valueSetter;
            return this;
        }

        public Builder<V, S> statusSetter(Setter<V, S> statusSetter){
            this.statusSetter = statusSetter;
            return this;
        }

        public SettableMutableResult<V, S> build(){
            return new SettableMutableResult<>(successSetter, valueSetter, statusSetter);
        }
    }

    abstract public static class Setter<V, S>{
        protected Boolean success;
        protected V value;
        protected S status;

        public Boolean getSuccess() {
            return success;
        }

        public V getValue() {
            return value;
        }

        public S getStatus() {
            return status;
        }

        abstract public void calculate(Result<V, S> result);
    }
}
