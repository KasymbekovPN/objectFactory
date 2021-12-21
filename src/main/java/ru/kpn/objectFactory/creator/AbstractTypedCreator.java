package ru.kpn.objectFactory.creator;

import ru.kpn.objectFactory.results.builder.AbstractResultBuilder;
import ru.kpn.objectFactory.results.result.Result;

public abstract class AbstractTypedCreator<T, D, RT, S> implements TypedCreator<T, D, RT, S> {
    @Override
    public Result<RT, S> create(D datum) {
        return createBuilder(datum)
                .check()
                .calculateValue()
                .buildResult();
    }

    protected abstract AbstractResultBuilder<RT,S> createBuilder(D datum);
}
