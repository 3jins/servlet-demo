package com.example.servletdemo.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        log.info("HelloServlet.service");

        log.info("request = {}", request);
        log.info("response = {}", response);
        /*
         * request = org.apache.catalina.connector.RequestFacade@6a6d020c
         * response = org.apache.catalina.connector.ResponseFacade@3eb57254
         *
         * HttpServletRequest, HttpServletResponse는 인터페이스. 위의 apache...Facade는 그에 대한 구현체.
         */

        String username = request.getParameter("username");
        log.info("username = {}", username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("Hello, " + username);
    }
}
