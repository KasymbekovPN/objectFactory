package ru.kpn.objectFactory.results.result;

public interface Result<V, S> {
    Boolean getSuccess();
    V getValue();
    S getStatus();
}
