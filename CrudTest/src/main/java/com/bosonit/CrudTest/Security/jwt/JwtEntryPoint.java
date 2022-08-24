package com.bosonit.CrudTest.Security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private final static Logger logger= LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fail en el método commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
}

//https://www.youtube.com/watch?v=fg8KO8CGUZU&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=5