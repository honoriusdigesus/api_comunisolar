package com.api.comunisolar.domain.utils;

import org.springframework.stereotype.Component;

@Component
public class MyValidator {
    public boolean NullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
