package com;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.logging.*;


public class LoggerDisplay extends HttpFilter implements Filter {
       

    public LoggerDisplay() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Logger logger =Logger.getLogger("LoggerDisplay");
		logger.info("Pote Hote client :"+ request.getRemoteHost());
		logger.info("Address IP du client :"+ request.getRemoteAddr());
		logger.info("Num de port du client "+ request.getRemotePort());
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
