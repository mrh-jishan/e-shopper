package com.eshopper.payload.response;

import com.eshopper.model.Roles;
import lombok.Getter;

import java.util.Set;

@Getter
public class JwtResponse {
    private String token;
    private String refreshToken;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private Set<String> roles;

    public JwtResponse(String accessToken,
                       String refreshToken,
                       Long id,
                       String username,
                       String email,
                       Set<String> roles) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
