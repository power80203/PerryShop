package com.perry.admin.user;
import org.springframework.stereotype.Repository;
import com.perry.common.entity.Role;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
