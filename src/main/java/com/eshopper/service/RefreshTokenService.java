package com.eshopper.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.eshopper.advice.ResourceNotFoundException;
import com.eshopper.advice.TokenRefreshException;
import com.eshopper.model.RefreshToken;
import com.eshopper.repository.RefreshTokenRepository;
import com.eshopper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;


@Service
public class RefreshTokenService {

    private final Long refreshTokenDurationMs;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public RefreshTokenService(@Value("${app.jwtRefreshExpirationMs:120000}") Long refreshTokenDurationMs,
                               RefreshTokenRepository refreshTokenRepository,
                               UserRepository userRepository) {
        this.refreshTokenDurationMs = refreshTokenDurationMs;
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    final RefreshToken refreshToken = new RefreshToken(user, UUID.randomUUID().toString(), Instant.now().plusMillis(refreshTokenDurationMs));
                    return refreshTokenRepository.save(refreshToken);
                })
                .orElseThrow(() -> new ResourceNotFoundException(format("User: %s, not found", userId)));
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }

        return token;
    }

    @Transactional
    public int deleteByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(refreshTokenRepository::deleteByUser)
                .orElseThrow(() -> new ResourceNotFoundException(format("User: %s, not found", userId)));
    }
}
