package com.jumzip.arcana.api.controller;

import com.jumzip.arcana.api.service.UserService;
import com.jumzip.arcana.db.entity.TimeCard;
import com.jumzip.arcana.db.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(description = "USER API", name = "USER")
@RestController
@RequestMapping("api/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /* Firebase */
    // uid 헤더로 받아오기, uid로 검색
    // 없는 uid라면 DB에 추가(신규회원) > 닉네임
    // 있는 uid라면 기존회원

/*    @GetMapping("/uid/{email}")
    @Operation(summary = "UID 체크", description = "기존 사용자라면 true를 리턴한다")
    public ResponseEntity<Boolean> CheckUid(@PathVariable String email) {
        return userService.CheckUid(email) + "";
        boolean result = userService.CheckUid(email);
        return ResponseEntity.status(200).body(result);
    }*/

/*
    OAuth 액세스 토큰이 포함된 샘플 응답
    https://firebase.google.com/docs/reference/rest/auth?hl=ko

    {
        "federatedId": "http://facebook.com/1234567890",
            "providerId": "facebook.com",
            "localId": "5xwsPCWYo...",
            "emailVerified": true,
            "email": "user@example.com",
            "oauthAccessToken": "[FACEBOOK_ACCESS_TOKEN]",
            "firstName": "John",
            "lastName": "Doe",
            "fullName": "John Doe",
            "displayName": "John Doe",
            "idToken": "[ID_TOKEN]",
            "photoUrl": "https://scontent.xx.fbcdn.net/v/...",
            "refreshToken": "[REFRESH_TOKEN]",
            "expiresIn": "3600",
            "rawUserInfo": "{\"updated_time\":\"2017-02-22T01:10:57+0000\",\"gender\":\"male\", ...}"
    }
*/
    @Operation(summary = "UserInfo 조회", description = "사용자의 정보를 리턴한다")
    @GetMapping("info")
    public User GetUserInfo(@RequestHeader String uid) {
        User user = new User();
        return user;
    }

    @Operation(summary = "UserInfo 조회", description = "사용자의 정보를 리턴한다")
    @PutMapping("nickname")
    public User UpdateUserNickname(@RequestHeader String uid, @RequestParam String nickname) {
        User user = new User();
        return user;
    }

    @Operation(summary = "UserInfo 조회", description = "사용자의 정보를 리턴한다")
    @DeleteMapping("delete")
    public String DeleteUser(@RequestHeader String uid) {
        User user = new User();
        return user.getUid() + " Delete Complete";
    }

}
