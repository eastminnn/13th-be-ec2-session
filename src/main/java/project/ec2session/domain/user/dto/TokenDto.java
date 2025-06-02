package project.ec2session.domain.user.dto;

public record TokenDto(
        String accessToken,
        Long userId
) {
    public static TokenDto of(String accessToken, Long userId) {
        return new TokenDto(accessToken, userId);
    }
}
