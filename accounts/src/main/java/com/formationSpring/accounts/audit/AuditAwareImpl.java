package com.formationSpring.accounts.audit;

import com.formationSpring.accounts.security.Session;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component("auditAwareComponent")
@AllArgsConstructor
public class AuditAwareImpl implements AuditorAware<String> {
    private Session session;
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(session.getAccount_name());
    }
}
