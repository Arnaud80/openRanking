package biz.duhamel.openranking.repositories;

import biz.duhamel.openranking.entities.ERole;
import biz.duhamel.openranking.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
