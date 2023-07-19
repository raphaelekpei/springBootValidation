package com.raphael.springbootvalidation.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    PENDING("Pending"),
    BLOCKED("Blocked"),
    DELETED("Deleted"),
    SUSPENDED("Suspended"),
    AWAITING_VERIFICATION("Awaiting Verification"),
    LOCKED("Locked"),
    ARCHIVED("Archived");


    private final String statusName;

//    UserStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatus() {
//        return status;
//    }

}
