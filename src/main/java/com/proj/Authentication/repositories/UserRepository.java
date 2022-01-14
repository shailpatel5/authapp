package com.proj.Authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.Authentication.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
