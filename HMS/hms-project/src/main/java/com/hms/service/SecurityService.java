package com.hms.service;

import com.hms.exception.UnauthorizedAccessException;
import com.hms.model.User;
import com.hms.model.UserRole;

public class SecurityService {
    public static void verifyRole(User currentUser, UserRole requiredRole) {
        if (currentUser == null) {
            throw new UnauthorizedAccessException("Authentication required.");
        }
        if (currentUser.getRole() != UserRole.ADMIN && currentUser.getRole() != requiredRole) {
            throw new UnauthorizedAccessException("Access Denied: Role " + currentUser.getRole() + " lacks permission.");
        }
    }
}