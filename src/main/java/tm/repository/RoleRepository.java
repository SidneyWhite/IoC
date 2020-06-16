package tm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tm.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByName(String name);
}