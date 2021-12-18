package ru.kpn.objectFactory.creator;

import ru.kpn.objectFactory.results.result.Result;

public interface Creator<D, RT, S> {
    Result<RT, S> create(D datum);
}
