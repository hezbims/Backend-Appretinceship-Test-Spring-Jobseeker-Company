package com.jobseekerapprenticeship.spring_api_test.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserType {
    ADMIN(AuthorityName.ADMIN),
    NON_ADMIN(AuthorityName.NON_ADMIN);

    public final String authorityName;


    public static class AuthorityName {
        public static final String ADMIN = "ADMIN";
        public static final String NON_ADMIN = "NON_ADMIN";
    }
}
