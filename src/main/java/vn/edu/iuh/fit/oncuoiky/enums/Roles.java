package vn.edu.iuh.fit.oncuoiky.enums;

import lombok.Getter;

@Getter
public enum Roles {
    ADMIN(1),
    STAFF(2),
    MANAGER(3),
    EXECUTIVE(4);

    private final int value;

    Roles(int value) {
        this.value = value;
    }

}
