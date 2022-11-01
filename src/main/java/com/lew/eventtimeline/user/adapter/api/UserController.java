package com.lew.eventtimeline.user.adapter.api;

import com.lew.eventtimeline.user.domain.port.api.ChangePasswordUseCase;
import com.lew.eventtimeline.user.domain.port.api.LoginUseCase;
import com.lew.eventtimeline.user.domain.port.api.UserDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/user")
public class UserController {

    LoginUseCase loginUseCase;
    ChangePasswordUseCase changePasswordUseCase;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody UserDto user) {

        return loginUseCase.login(user);
    }

    @PutMapping("/password/{username}")
    public ResponseEntity<?> changePassword(@PathVariable String username,
                                            @Valid @RequestBody UserDto user) {
        changePasswordUseCase.change(user);

        return ResponseEntity.ok().build();
    }
}
