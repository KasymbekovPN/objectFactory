package ru.kpn.result;

abstract public class AbstractResult<V, S> implements Result<V, S>{
    protected Boolean success;
    protected V value;
    protected S status;

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public S getStatus() {
        return status;
    }

    @Override
    public void setStatus(S status) {
        this.status = status;
    }
}
