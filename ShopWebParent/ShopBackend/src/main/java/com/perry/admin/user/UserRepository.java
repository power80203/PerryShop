package com.perry.admin.user;

import org.springframework.data.repository.CrudRepository;
import com.perry.common.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}


