package his.implementation;

import com.google.common.collect.Lists;

import java.util.List;

public final class Roles {
    private Roles() {
    }

    public static final String ROLE_EMPTY = "General user";
    public static final String ROLE_ADMIN = "Administrative officer";
    public static final String ROLE_RECEPTIONIST = "Receptionist";
    public static final String ROLE_SURGEON = "Surgeon";
    public static final String ROLE_ONCOLOGIST = "Oncologist";
    public static final String ROLE_PRIV_DOC = "Privileged doctor";

    public static List<String> get() {
        return Lists.newArrayList(
                ROLE_EMPTY,
                ROLE_ADMIN,
                ROLE_RECEPTIONIST,
                ROLE_SURGEON,
                ROLE_ONCOLOGIST,
                ROLE_PRIV_DOC
        );
    }
}
