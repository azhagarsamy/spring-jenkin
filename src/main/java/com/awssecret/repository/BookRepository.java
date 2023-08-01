package com.awssecret.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awssecret.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
