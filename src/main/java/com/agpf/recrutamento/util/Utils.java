package com.agpf.recrutamento.util;

import java.util.function.Consumer;

public class Utils {
    public static <T> void updateField(T fieldValue, Consumer<T> setter) {
        if(fieldValue != null)
            setter.accept(fieldValue);
    }
}
