package dev.assesment.java_assesment_auth.repository;

import dev.assesment.java_assesment_auth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmail(String email);

    @Procedure(name = "USER.VERIFIED")
    ResponseEntity<Void> verifiedAccount(@Param("v_id_user") String id, @Param("v_verified") Boolean verify);

}
