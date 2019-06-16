package com.how2java.springboot.service.impl;

import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
import com.how2java.springboot.service.CategoryService;
import com.how2java.springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "category")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;


    @Override
    @Cacheable(key = "'category '+#p0.offset+'-'+#p0.pageSize")
    public Page4Navigator<Category> list(Pageable pageable) {

        Page<Category> pageFromJPA=categoryDAO.findAll(pageable);
        Page4Navigator<Category> page=new Page4Navigator<>(pageFromJPA,5);
        return page;
    }

    @Override
    @CacheEvict(allEntries = true)
    public void save(Category category) {
        categoryDAO.save(category);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void delete(int id) {

        categoryDAO.delete(id);
    }

    @Override
    @Cacheable(key = "'category '+#p0")
    public Category get(int id) {
        Category c=categoryDAO.findOne(id);
        return c;
    }
}
