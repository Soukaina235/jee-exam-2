package org.example.jeeexam2.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        // Authority is derived from the role
        boolean isManager = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority ->
                        grantedAuthority.getAuthority()
                                .equals("ROLE_MANAGER") // When a role becomes an authority we add the ROLE_ before the role
                );
        if (isManager) {
            setDefaultTargetUrl("/manager/affectation");
        } else {
            boolean isTech = authentication.getAuthorities().stream()
                    .anyMatch(grantedAuthority ->
                            grantedAuthority.getAuthority()
                                    .equals("ROLE_TECH_LEAD")
                    );

            if (isTech) {
                setDefaultTargetUrl("/employees");
            }

            else {
                setDefaultTargetUrl("/");
            }
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
