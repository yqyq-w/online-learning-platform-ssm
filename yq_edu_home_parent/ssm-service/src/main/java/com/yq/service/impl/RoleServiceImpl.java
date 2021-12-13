package com.yq.service.impl;

import com.yq.dao.RoleMapper;
import com.yq.domain.*;
import com.yq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleid) {
        List<Integer> menuByRoleId = roleMapper.findMenuByRoleId(roleid);

        return menuByRoleId;
    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {

        //1. 清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        //2. 为角色分配菜单

        for (Integer mid : roleMenuVo.getMenuIdList()) {

            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());

            //封装数据
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);

            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");


            roleMapper.roleContextMenu(role_menu_relation);
        }

    }

    @Override
    public void deleteRole(Integer roleid) {

        // 调用根据roleid清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleid);

        roleMapper.deleteRole(roleid);
    }

    /*
    assn604 获取当前角色拥有的资源信息
    */
    @Override
    public List<ResourceCategory> findResourceListByRoleId(Integer roleid) {
        // 调用dao中的两个方法分别获取资源分类数据和资源数据, 将资源数据封装到对应的分类下
        List<Resource> resourceList = roleMapper.findResourceByRoleId(roleid);
        if (resourceList.isEmpty()) return null;

        List<ResourceCategory> resourceCategoryList = roleMapper.findResourceCategoryByRoleId(roleid);
        for (Resource r : resourceList) {
            for (ResourceCategory c : resourceCategoryList) {
                if (r.getCategoryId() == c.getId()) {
                    c.getResourceList().add(r);
                    break;
                }
            }
        }

        return resourceCategoryList;
    }

    /*
    为角色分配资源
    */
    public void roleContextResource(RoleResourceVo roleResourceVo){
        //1. 先清空之前中间表的关联关系
        roleMapper.deleteRoleContextResource(roleResourceVo.getRoleId());

        //2. 为角色分配资源
        for (Integer resourceId : roleResourceVo.getResourceIdList()) {

            //补全信息
            RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
            roleResourceRelation.setResourceId(resourceId);
            roleResourceRelation.setRoleId(roleResourceVo.getRoleId());

            //封装数据
            Date date = new Date();
            roleResourceRelation.setCreatedTime(date);
            roleResourceRelation.setUpdatedTime(date);

            roleResourceRelation.setCreatedBy("system");
            roleResourceRelation.setUpdatedBy("system");

            // 插入新的关联关系
            roleMapper.roleContextResource(roleResourceRelation);
        }

    }

}
