package com.yq.service;

import com.github.pagehelper.PageInfo;
import com.yq.domain.ResponseResult;
import com.yq.domain.Role;
import com.yq.domain.User;
import com.yq.domain.UserVo;

import java.util.List;

public interface UserService {

    /*
        用户分页&多条件查询
     */
    public PageInfo findAllUserByPage(UserVo userVo);

    /*
        用户登陆
     */

    public User login(User user) throws Exception;

    /*
        分配角色（回显）
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /*
        用户关联角色
     */
    public void userContextRole(UserVo userVo);

    /*
        获取用户权限，进行菜单动态展示
     */
    public ResponseResult getUserPermissions(Integer userid);


}
