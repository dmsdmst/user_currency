package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByEmail(String email);

    default User findByIdOrElseThrow(Long id){
        if(id == null){
            return null;
        }
        return findById(id).orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 유저입니다"));
    }
}
