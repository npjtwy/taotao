package com.taotao.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * TestPageHelper
 *
 * @author Yang
 * @date 2018/7/17
 */
public class TestPageHelper {

    @Test
    public void testPageHelper() throws Exception {
        //1. 在 mybatis 中配置分页插件
        //2. 执行查询之前配置分页条件
        PageHelper.startPage(1, 10);

        // 3.
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);

        TbItemExample example = new TbItemExample();

        List<TbItem> list = itemMapper.selectByExample(example);

        PageInfo<TbItem> pageInfo = new PageInfo<>(list);

        System.out.println("总记录数： " + pageInfo.getTotal());
        System.out.println("总页数: " + pageInfo.getPages());
        System.out.println("返回记录数: " + list.size());

    }
}
