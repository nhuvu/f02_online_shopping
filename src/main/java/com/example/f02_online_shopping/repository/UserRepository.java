package com.example.f02_online_shopping.repository;

import com.example.f02_online_shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByFullname(String fullname);

}
