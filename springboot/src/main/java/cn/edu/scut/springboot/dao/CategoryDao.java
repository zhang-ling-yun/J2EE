package cn.edu.scut.springboot.dao;

import cn.edu.scut.springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: rain
 * @date: 2019-4-22 15:19
 * @description: springboot
 */
public interface CategoryDao extends JpaRepository<Category,Integer> {
}
