package com.nbr.auth.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbr.auth.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
