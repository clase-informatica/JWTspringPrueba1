package com.ejemplo.JWTprueba.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse) servletResponse;

        String token= httpRequest.getParameter("token");

        if(token==null)
        {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Acces denied");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicializar el filtro aquí, si es necesario
    }

    @Override
    public void destroy() {
        // Liberar recursos aquí, si es necesario
    }

}

