package ru.kpn.objectFactory.datum;

import ru.kpn.objectFactory.type.DatumType;

abstract public class AbstractDatum<T extends DatumType> implements Datum<T> {

    protected T type;

    @Override
    public T getType() {
        return type;
    }
}
