package edu.secourse.patientportal.pmfrontend.util;

public class SessionManager {
    private static String token;
    private static String role;

    public static void setSession(String jwt, String userRole) {
        token = jwt;
        role = userRole;
    }

    public static String getToken() {
        return token;
    }

    public static String getRole() {
        return role;
    }

    public static void clear() {
        token = null;
        role = null;
    }
}
