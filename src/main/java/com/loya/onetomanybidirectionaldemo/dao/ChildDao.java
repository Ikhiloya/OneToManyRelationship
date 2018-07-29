package com.loya.onetomanybidirectionaldemo.dao;

import com.loya.onetomanybidirectionaldemo.entity.Child;
import com.loya.onetomanybidirectionaldemo.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildDao extends JpaRepository<Child, Integer> {

}
