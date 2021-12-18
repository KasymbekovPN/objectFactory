package ru.kpn.objectFactory.results.result;

abstract public class AbstractResult<V, S> implements Result<V, S>{
    protected Boolean success;
    protected V value;
    protected S status;

    public AbstractResult(Boolean success, V value, S status) {
        this.success = success;
        this.value = value;
        this.status = status;
    }

    public AbstractResult(Boolean success, S status) {
        this.success = success;
        this.status = status;
    }

    public AbstractResult(V value) {
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
