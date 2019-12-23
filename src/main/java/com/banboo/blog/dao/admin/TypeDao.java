package com.banboo.blog.dao.admin;

import com.banboo.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDao extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
