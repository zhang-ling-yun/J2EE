package cn.edu.scut.ssm.service.impl;

import cn.edu.scut.ssm.dao.CategoryDao;
import cn.edu.scut.ssm.entity.Category;
import cn.edu.scut.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-20 00:05
 * @description: ssm
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> selectCategoryList() {
        return categoryDao.selectCategoryList();
    }
}
