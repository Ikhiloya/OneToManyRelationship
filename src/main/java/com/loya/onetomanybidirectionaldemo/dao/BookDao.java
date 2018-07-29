package com.loya.onetomanybidirectionaldemo.dao;

import com.loya.onetomanybidirectionaldemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

}
