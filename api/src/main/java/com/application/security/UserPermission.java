package com.application.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserPermission {
    READ("read"),
    WRITE("write");

    private final String permission;
}