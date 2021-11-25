package ru.kpn.creator;

import ru.kpn.result.Result;

public interface Creator<D, RT, S> {
    Result<RT, S> create(D datum);
}
