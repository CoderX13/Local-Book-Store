package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.entity.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Long>{

}
