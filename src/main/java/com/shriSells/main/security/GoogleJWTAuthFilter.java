package com.shriSells.main.security;

import com.shriSells.main.models.Customer;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.shriSells.main.interfaces.ICustomerRepository;
import java.io.IOException;
import java.util.Collections;

@Component
public class GoogleJWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    @Lazy
    ICustomerRepository customerRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {




        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            var payload = GoogleTokenVerifier.verify(token);

            if (payload != null) {
                String email = payload.getEmail();
                String name = (String) payload.get("name");
                String sub = payload.getSubject();

                Customer customer = customerRepository.findByProviderUserId(sub)
                        .orElseGet(() -> {
                            Customer newCustomer = new Customer();
                            newCustomer.setEmail(email);
                            newCustomer.setName(name);
                            newCustomer.setAuthProvider("google");
                            newCustomer.setProviderUserId(sub);
                            return customerRepository.save(newCustomer);
                        });
                //String email = payload.getEmail();
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(customer, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(auth);

                SecurityContextHolder.getContext().setAuthentication(auth);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
