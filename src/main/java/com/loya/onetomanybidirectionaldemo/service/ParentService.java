package com.loya.onetomanybidirectionaldemo.service;

import com.loya.onetomanybidirectionaldemo.dao.ParentDao;
import com.loya.onetomanybidirectionaldemo.entity.Author;
import com.loya.onetomanybidirectionaldemo.entity.Parent;
import com.loya.onetomanybidirectionaldemo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    @Autowired
    ParentDao parentDao;

    public Parent createParent(Parent parent) {
        return parentDao.save(parent);
    }

}
