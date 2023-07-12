package com.c.controlu.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.c.controlu.models.RoleEntity;




@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
