package project.ec2session.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.ec2session.domain.user.dto.UserReq;

public interface AuthControllerSwagger {
    @Operation(summary = "로그인", description = "로그인 시도")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    {
                                    "accessToken" : "<accessToken>"
                                    }
                                    """)
                    })),
            @ApiResponse(responseCode = "500", description = "서버 에러",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    {
                                    "status" : 500,
                                    "message" : "서버 에러입니다. 서버 팀에 연락주세요."
                                    }
                                    """)
                    })),
            @ApiResponse(responseCode = "404", description = "로그인 실패",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(name = "유저 이름 불일치", value = """
                                    {
                                    "status": 404,
                                    "message": "정보를 정확히 입력해주세요."
                                    }
                                    """),
                            @ExampleObject(name = "비밀번호 불일치", value = """
                                    {
                                    "status": 404,
                                    "message": "잘못된 비밀번호입니다."
                                    }
                                    """)
                    }))
    })
    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    ResponseEntity<?> signIn(
            @RequestBody @Valid UserReq.SignInDto request
    );


    @Operation(summary = "회원가입", description = "회원가입 시도")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    {
                                    "userId" : 1
                                    }
                                    """)
                    })),
            @ApiResponse(responseCode = "500", description = "서버 에러",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    {
                                    "status" : 500,
                                    "message" : "서버 에러입니다. 서버 팀에 연락주세요."
                                    }
                                    """)
                    })),
            @ApiResponse(responseCode = "400", description = "필수 입력 값 누락",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    {
                                    "password": "비밀번호는 필수 입력 값입니다.",
                                    "nickname": "닉네임은 필수 입력 값입니다.",
                                    "username": "아이디는 필수 입력 값입니다."
                                    }
                                    """)
                    }))
    })
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    ResponseEntity<?> signUp(@RequestBody @Valid UserReq.SignUpDto request);
}
