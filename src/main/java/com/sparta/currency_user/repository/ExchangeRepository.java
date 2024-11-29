package com.sparta.currency_user.repository;

import com.sparta.currency_user.dto.ReadExchangeResponseDto;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange,Long> {
    List<Exchange> findAllByUser(User user);

    default Exchange findByIdOrElseThrow(Long id){
        if(id == null){
            return null;
        }
        return findById(id).orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 요청입니다"));
    }
}
