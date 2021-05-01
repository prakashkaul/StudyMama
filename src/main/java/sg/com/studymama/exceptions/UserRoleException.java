package sg.com.studymama.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UserRoleException extends AuthenticationException {
    public UserRoleException(final String msg) {
        super(msg);
    }

}