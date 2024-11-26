package com.jpa.test.basicall.Repo;

import com.jpa.test.basicall.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cardRepo extends JpaRepository<Card,Integer> {
}
