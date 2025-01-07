package com.picpay.picpay.repository;

import com.picpay.picpay.domain.entity.ContaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaUser,Integer> {
}
