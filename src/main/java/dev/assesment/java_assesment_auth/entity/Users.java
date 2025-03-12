package dev.assesment.java_assesment_auth.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "USER.VERIFIED",
                procedureName = "MIDAS_PKG.VERIFIED_ACCOUNT",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "v_id_user", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "v_verified", type = Boolean.class)
                }
        )
})
public class Users implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullname;

    private Boolean isVerified = false;

    private String resetToken;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }



}
