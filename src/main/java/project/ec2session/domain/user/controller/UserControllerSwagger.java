package project.ec2session.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.ec2session.common.auth.CustomUserDetails;
import project.ec2session.domain.user.dto.UserReq;

public interface UserControllerSwagger {
    @Operation(summary = "유저 정보 조회", description = "유저 조회 시도")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저 정보 조회 성공",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    {
                                        "userId": "1",
                                        "username": "동민",
                                        "nickname": "eastmin"
                                    }
                                    """)
                    })),
            @ApiResponse(responseCode = "404", description = "유저 정보 조회 실패",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    {
                                        "status" : 404,
                                        "message" : "존재하지않는 회원입니다."
                                    }
                                    """)
                    }))
    })
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    ResponseEntity<?> getUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails);


    @Operation(summary = "닉네임 변경", description = "닉네임 변경 시도")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "닉네임 변경 성공",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = "요청 성공")
                    })),
            @ApiResponse(responseCode = "404", description = "유저 정보 조회 실패",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    {
                                        "status" : 404,
                                        "message" : "존재하지않는 회원입니다."
                                    }
                                    """)
                    }))
    })
    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<?> updateUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails,
                                            @RequestBody @Valid UserReq.UpdateInfo request);


    @Operation(summary = "전체 유저 정보 조회", description = "전체 유저 조회 시도")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "전체 유저 정보 조회 성공",
                    content = @Content(mediaType = "application/json", examples = {
                            @ExampleObject(value = """
                                    [
                                        {
                                            "userId": 1,
                                            "username": "동민",
                                            "nickname": "eastmin"
                                        },
                                        {
                                            "userId": 2,
                                            "username": "남민",
                                            "nickname": "southmin"
                                        }
                                    ]
                                    """)
                    }))
    })
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAllUser();

}
