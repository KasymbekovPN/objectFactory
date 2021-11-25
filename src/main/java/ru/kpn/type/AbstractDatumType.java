package ru.kpn.type;

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
}
