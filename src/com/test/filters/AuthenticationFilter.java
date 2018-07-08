package com.test.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;


public class AuthenticationFilter implements javax.servlet.Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //pre-processing
        if(request.getRequestURI ().startsWith ("/HPlusSample/orderHistory")||
                request.getRequestURI ().startsWith ("/HPlusSample/getProfileDetails")){
            HttpSession session = request.getSession ();
            if(session.getAttribute ("username")==null){
                request.getRequestDispatcher ("/html/login.jps").forward (request, servletResponse);
            }
        }

        filterChain.doFilter (request, servletResponse);
        //post-processing
    }

    @Override
    public void destroy() {

    }
}
