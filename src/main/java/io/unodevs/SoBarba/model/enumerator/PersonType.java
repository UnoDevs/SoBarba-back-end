package io.unodevs.SoBarba.model.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum PersonType {
    CUSTOMER,
    SUPPLIER,
    EMPLOYEE,
    OWNER
}
