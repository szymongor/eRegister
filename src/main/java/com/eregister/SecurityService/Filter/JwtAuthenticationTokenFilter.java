package com.eregister.SecurityService.Filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Szymon on 08.04.2017.
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    //private final Log logger = LogFactory.getLog(this.getClass());

    //@Autowired
    //private UserDetailsService userDetailsService;

    //@Autowired
    //private JwtTokenUtil jwtTokenUtil;

    //@Value("${jwt.header}")
    //private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authToken = request.getHeader("Authorization");
        if("Hujowy token".equals(authToken)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authToken);
        }
        chain.doFilter(request, response);
    }
}