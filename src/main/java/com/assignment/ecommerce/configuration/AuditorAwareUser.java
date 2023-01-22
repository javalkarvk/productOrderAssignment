package com.assignment.ecommerce.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareUser implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = "_api";
        return Optional.of(username);
    }
}
