package com.gf.magic.store.front.repository;

import com.gf.magic.store.front.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/12/23
 */
public interface RoleRepo extends JpaRepository<Role,Long>{

    Role findByName(String name);
}
