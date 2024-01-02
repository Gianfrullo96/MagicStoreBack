package com.gf.magic.store.front.service;

import com.gf.magic.store.front.model.Role;
import com.gf.magic.store.front.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/12/23
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepo roleRepo;


    @Override
    public Role save(Role role){
        log.info("Saving {} role to the database ",role.getName());
        return roleRepo.save(role);
    }
}
