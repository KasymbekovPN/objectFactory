package ru.kpn.objectFactory.datum;

import ru.kpn.objectFactory.type.DatumType;

public interface Datum<T extends DatumType> {
    T getType();
    void setType(String type);
}
