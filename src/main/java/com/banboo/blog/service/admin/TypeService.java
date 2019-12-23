package com.banboo.blog.service.admin;

import com.banboo.blog.NotFoundException;
import com.banboo.blog.dao.admin.TypeDao;
import com.banboo.blog.po.Type;
import com.banboo.blog.serviceinterface.admin.TypeServiceIntreface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TypeService implements TypeServiceIntreface {

    @Resource
    private TypeDao typeDao;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeDao.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getOne(id);
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeDao.findByName(name);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeDao.findAll(pageable);
    }

    @Override
    public Type updateType(Long id, Type type) {
        Type type1 = typeDao.getOne(id);
        if (type1 == null) {
            throw new NotFoundException("存在该类型");
        }
        BeanUtils.copyProperties(type, type1);
        return typeDao.save(type1);
    }

    @Override
    public void deleteType(Long id) {
        typeDao.deleteById(id);
    }
}
