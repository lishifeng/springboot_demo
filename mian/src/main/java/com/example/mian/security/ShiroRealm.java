package com.example.mian.security;

import com.example.mian.entity.UserBean;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //给当前角色授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        UserBean userBean = (UserBean) principalCollection.getPrimaryPrincipal();

        if (userBean.getName().equals("xslde")) {
            //设置该用户拥有user角色
            authorizationInfo.addRole("user");
            //设置该用户拥有query权限
            authorizationInfo.addStringPermission("user:query");
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //进行用户信息获取
        String username = (String) authenticationToken.getPrincipal();
        UserBean userBean=null;
        return  new SimpleAuthenticationInfo(userBean, userBean.getPassworld(), ByteSource.Util.bytes(userBean.getName()), getName());
    }
}
