package ru.kpn.objectFactory.results.result;

public interface MutableResult<V, S> extends Result<V, S>{
    void setSuccess(Boolean success);
    void setValue(V value);
    void setStatus(S status);
}
