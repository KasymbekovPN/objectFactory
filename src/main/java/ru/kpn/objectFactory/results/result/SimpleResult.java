package ru.kpn.objectFactory.results.result;

public class SimpleResult<V, S> implements Result<V, S>{
    private Boolean success;
    private V value;
    private S status;

    public SimpleResult(Boolean success, V value, S status) {
        this.success = success;
        this.value = value;
        this.status = status;
    }

    public SimpleResult(Boolean success, S status) {
        this.success = success;
        this.status = status;
    }

    public SimpleResult(V value) {
        this.success = true;
        this.value = value;
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
}
