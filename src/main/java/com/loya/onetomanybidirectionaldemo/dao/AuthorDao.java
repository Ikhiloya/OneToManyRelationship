package com.loya.onetomanybidirectionaldemo.dao;

import com.loya.onetomanybidirectionaldemo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {

}
