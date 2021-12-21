package ru.kpn.objectFactory.factory;

import ru.kpn.objectFactory.creator.TypedCreator;
import ru.kpn.objectFactory.datum.Datum;
import ru.kpn.objectFactory.results.builder.AbstractResultBuilder;
import ru.kpn.objectFactory.results.result.Result;
import ru.kpn.objectFactory.type.DatumType;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractObjectFactory<D extends Datum<? extends DatumType>, RT, S> implements ObjectFactory<D, RT, S> {
    @Override
    public Result<RT, S> create(D datum) {
        return datum.getType().isValid() ? getResult(datum) : getWrongResult(datum);
    }

    protected abstract Result<RT,S> getResult(D datum);
    protected abstract Result<RT,S> getWrongResult(D datum);

    protected abstract static class AbstractBuilder<D extends Datum<? extends DatumType>, RT, S> extends AbstractResultBuilder<ObjectFactory<D, RT, S>, S> {
        protected final Map<DatumType, TypedCreator<DatumType, D, RT, S>> creators = new HashMap<>();

        public AbstractBuilder<D, RT, S> creator(TypedCreator<DatumType, D, RT, S> creator){
            creators.put(creator.getType(), creator);
            return this;
        }
    }
}
