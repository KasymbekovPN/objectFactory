package ru.kpn.objectFactory.results.builder;

import ru.kpn.objectFactory.results.result.Result;

public abstract class AbstractResultBuilder<V, S> implements ResultBuilder<V, S> {
    protected boolean success = true;
    protected V value;
    protected S status;

    @Override
    public Result<V, S> buildResult() {
        return success ? buildOnSuccess() : buildOnFailure();
    }

    protected abstract Result<V,S> buildOnSuccess();
    protected abstract Result<V,S> buildOnFailure();
}
