package ru.kpn.datum;

import ru.kpn.type.DatumType;

abstract public class AbstractDatum<T extends DatumType> implements Datum<T> {

    protected T type;

    @Override
    public T getType() {
        return type;
    }
}
