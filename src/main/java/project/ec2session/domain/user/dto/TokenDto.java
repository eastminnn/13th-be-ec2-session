package project.ec2session.domain.user.dto;

public record TokenDto(
        String message,
        String accessToken,
        Long userId
) {
    public static TokenDto of(String message, String accessToken, Long userId) {
        return new TokenDto(message, accessToken, userId);
    }
}
