package com.example.carmanager.models;

public enum ERole {
    ROLE_USER,
    ROLE_MODERATOR,
    ROLE_ADMIN;

    public static ERole toERole(String roleName) {
        if (roleName.equals("ROLE_ADMIN")) return ROLE_ADMIN;
        if (roleName.equals("ROLE_MODERATOR")) return ROLE_MODERATOR;
        return ROLE_USER;
    }
}
