package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class CustomFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    private UUID uudi;

    public void init(final FilterConfig filterConfig) throws ServletException {
        // Init Filter Component
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.uudi = UUID.randomUUID();
        MDC.put("transaction-id", uudi.toString());
        chain.doFilter(request, response);
    }
}
