package com.example.f02_online_shopping.repository;

import com.example.f02_online_shopping.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT u.* FROM Users u WHERE u.fullname = :fullname", nativeQuery = true)
    User findByFullname(@Param("fullname") String fullname);

    @Query(value = "SELECT u.* FROM Users u WHERE u.id = :id", nativeQuery = true)
    User findByUserId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Users u SET u.fullname = :fullname, u.email = :email, u.password = :password WHERE u.id = :id",
            nativeQuery = true)
    int updateUserInfo(Integer id, String fullname, String email, String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Users u SET u.status = :status WHERE u.id = :id", nativeQuery = true)
    int updateUserStatus(Integer id, String status);

    @Query(value = "SELECT u.* FROM Users u WHERE u.role = :role", nativeQuery = true)
    List<User> findAllByRole(@Param("role") String role);

    User findByEmail(String email);

    @Query(value = "SELECT * FROM Users WHERE role = :role AND email = :email ", nativeQuery = true)
    User findUserByEmail(String role, String email);
}
