package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * ItemCatService
 *
 * @author Yang
 * @date 2018/7/21
 */
public interface ItemCatService {

    List<EasyUITreeNode> getItemList(long parentId);
}
