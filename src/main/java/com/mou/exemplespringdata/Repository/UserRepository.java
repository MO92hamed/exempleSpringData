package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
