package ru.kpn.objectFactory.factory;

import ru.kpn.objectFactory.datum.Datum;
import ru.kpn.objectFactory.results.result.Result;
import ru.kpn.objectFactory.type.DatumType;

public interface ObjectFactory<D extends Datum<? extends DatumType>, RT, S> {
    Result<RT, S> create(D datum);
}
