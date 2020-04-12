package org.onlineSolutions.FunnyTrip.service.loginService;

import java.util.Map;

import org.onlineSolutions.FunnyTrip.config.security.AuthRequestBody;

public interface I_LoginService {

	Map<Object, Object> login(AuthRequestBody authRequestBody);
}
