package io.unodevs.SoBarba.model.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum PersonType {
    CUSTOMER(1),
    SUPPLIER(2),
    EMPLOYEE(3),
    OWNER(4);

    private final Integer id;

    PersonType(Integer id) {
        this.id = id;
    }

    @JsonValue
    public Integer getId(){
        return this.id;
    }

    @JsonCreator
    public static PersonType fromValue(Integer id){
        for (PersonType type : values()){
            Integer typeId = type.getId();
            if (Objects.equals(typeId, id)){
                return type;
            }
        }
        throw new IllegalArgumentException(id + " is a invalid id for PersonType");
    }
}
