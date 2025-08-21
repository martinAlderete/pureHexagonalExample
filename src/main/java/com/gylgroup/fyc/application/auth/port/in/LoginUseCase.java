package com.gylgroup.fyc.application.auth.port.in;

import com.gylgroup.fyc.application.auth.dto.LoginRequest;
import com.gylgroup.fyc.application.auth.dto.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest loginRequest);
}