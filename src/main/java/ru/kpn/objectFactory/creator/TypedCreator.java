package ru.kpn.objectFactory.creator;

public interface TypedCreator<T, D, RT, S> extends Creator<D, RT, S>{
    T getType();
}
