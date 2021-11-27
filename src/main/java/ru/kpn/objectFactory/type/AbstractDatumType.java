package ru.kpn.objectFactory.type;

import java.util.Objects;

abstract public class AbstractDatumType implements DatumType {
    
    protected final String strType;
    private Boolean validity;

    public AbstractDatumType(String strType) {
        this.strType = strType;
    }

    @Override
    public Boolean isValid() {
        if (validity == null){
            validity = checkValidity();
        }
        return validity;
    }

    protected abstract Boolean checkValidity();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDatumType that = (AbstractDatumType) o;
        return Objects.equals(strType, that.strType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strType);
    }
}
