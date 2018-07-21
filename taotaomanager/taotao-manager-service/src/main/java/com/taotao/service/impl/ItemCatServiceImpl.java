package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemCatServiceImpl
 *
 * @author Yang
 * @date 2018/7/21
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemList(long parentId) {

        //根据父节点的id 查找子节点

        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria =  example.createCriteria();

        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> list = itemCatMapper.selectByExample(example);

        List<EasyUITreeNode> resultList = new ArrayList<>();

        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();

            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent() ? "closed" : "open");

            resultList.add(node);
        }


        return resultList;
    }
}
