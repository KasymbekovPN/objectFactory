package ru.kpn.result;

public interface Result<V, S> {
    Boolean getSuccess();
    void setSuccess(Boolean success);
    V getValue();
    void setValue(V value);
    S getStatus();
    void setStatus(S status);
}
