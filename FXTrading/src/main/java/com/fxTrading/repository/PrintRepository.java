package com.fxTrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fxTrading.entity.BookedTrade;

@Repository
public interface PrintRepository extends JpaRepository<BookedTrade, Integer> {

}
