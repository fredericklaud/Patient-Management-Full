package edu.secourse.patientportal.pmbackend.dto;

import edu.secourse.patientportal.pmbackend.model.User;

public record UserResponse(
    String username,
    String name,
    String email,
    String role
) {
    // Static factory method to make mapping easier in controller
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getUsername(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
