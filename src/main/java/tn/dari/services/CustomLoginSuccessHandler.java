package tn.dari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import tn.dari.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	public static int idConnectedUser;
    @Autowired
    private UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomerUserDetails userDetails = (CustomerUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        if (user.getFailedAttempt() > 0){
            userService.resetFailedAttempt(user.getUsername());
           
        }
        super.onAuthenticationSuccess(request, response, authentication);
        idConnectedUser = user.getId();
    }
}
