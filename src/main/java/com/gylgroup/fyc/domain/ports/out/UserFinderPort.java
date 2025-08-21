package com.gylgroup.fyc.domain.ports.out;

import com.gylgroup.fyc.domain.models.User;
import java.util.Optional;


public interface UserFinderPort {
    Optional<User> findByEmail(String email);

}