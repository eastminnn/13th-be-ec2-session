package project.ec2session.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import project.ec2session.domain.user.entity.User;

public class UserReq {

    @Schema(name = "SignUpDto", description = "회원가입 요청 DTO")
    public record SignUpDto(
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            @Schema(description = "아이디", example = "dongmin123")
            String username,
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            @Schema(description = "비밀번호", example = "q1w2e3r4@")
            String password,
            @NotBlank(message = "닉네임은 필수 입력 값입니다.")
            @Schema(description = "닉네임", example = "eastmin")
            String nickname
    ) {
        public User toEntity(String encodedPassword) {
            return User.builder()
                    .username(username)
                    .password(encodedPassword)
                    .nickname(nickname)
                    .build();
        }
    }

    @Schema(name = "SignInDto", description = "로그인 요청 DTO")
    public record SignInDto(
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            @Schema(description = "아이디", example = "dongmin123")
            String username,
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            @Schema(description = "비밀번호", example = "q1w2e3r4@")
            String password
    ) { }

    @Schema(name = "UpadateInfo", description = "닉네임 변경 요청 DTO")
    public record UpdateInfo(
            @NotBlank(message = "닉네임은 필수 입력 값입니다.")
            @Schema(description = "변경할 닉네임", example = "westmin")
            String nickname
    ) { }
}
