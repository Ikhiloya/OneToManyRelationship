package com.loya.onetomanybidirectionaldemo.dao;

import com.loya.onetomanybidirectionaldemo.entity.Author;
import com.loya.onetomanybidirectionaldemo.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.security.krb5.internal.PAData;

@Repository
public interface ParentDao extends JpaRepository<Parent, Integer> {

}
