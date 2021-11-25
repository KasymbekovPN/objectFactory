package ru.kpn.datum;

import ru.kpn.type.DatumType;

public interface Datum<T extends DatumType> {
    T getType();
    void setType(String type);
}
