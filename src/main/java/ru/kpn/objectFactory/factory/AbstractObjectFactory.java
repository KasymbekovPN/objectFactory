package ru.kpn.objectFactory.factory;

import ru.kpn.objectFactory.datum.Datum;
import ru.kpn.objectFactory.result.Result;
import ru.kpn.objectFactory.type.DatumType;

abstract public class AbstractObjectFactory<D extends Datum<? extends DatumType>, RT, S> implements ObjectFactory<D, RT, S> {
    @Override
    public Result<RT, S> create(D datum) {
        return datum.getType().isValid() ? getResult(datum) : getWrongResult(datum);
    }

    protected abstract Result<RT,S> getResult(D datum);
    protected abstract Result<RT,S> getWrongResult(D datum);
}
