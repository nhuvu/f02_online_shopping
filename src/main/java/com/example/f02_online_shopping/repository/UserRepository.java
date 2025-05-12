package com.example.f02_online_shopping.repository;

import com.example.f02_online_shopping.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByFullname(String fullname);

    @Query(value = "SELECT u.* FROM Users u WHERE u.id = :id", nativeQuery = true)
    User findByUserId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Users u SET u.fullname = :fullname, u.email = :email, u.password = :password WHERE u.id = :id",
            nativeQuery = true)
    int updateUser(Integer id, String fullname, String email, String password);
}
