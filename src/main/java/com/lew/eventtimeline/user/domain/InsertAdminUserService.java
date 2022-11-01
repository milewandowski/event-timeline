package com.lew.eventtimeline.user.domain;

import com.lew.eventtimeline.common.security.Role;
import com.lew.eventtimeline.user.domain.port.db.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
// Only for demo purposes
public class InsertAdminUserService {

    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    @EventListener(ContextRefreshedEvent.class)
    public void insertAdminUser() {
        User user = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin1234"))
                .role(Role.ROLE_ADMIN.name())
                .authorities(Role.ROLE_ADMIN.getAuthorities())
                .isActive(true)
                .isNotLocked(true)
                .build();

        userRepository.save(user);
    }
}
