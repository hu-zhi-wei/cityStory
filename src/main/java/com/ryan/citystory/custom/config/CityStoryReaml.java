package com.ryan.citystory.custom.config;

import com.alibaba.fastjson.JSON;
import com.ryan.citystory.bean.User;
import com.ryan.citystory.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Component
public class CityStoryReaml extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("**********   进入授权方法   **********");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("**********   进入认证方法   **********");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User loginUser = userService.findByUserName(token.getUsername());
        if ( loginUser != null ){
            return new SimpleAuthenticationInfo(loginUser, loginUser.getPassword(),loginUser.getUserName());
        }
        return null;
    }

    public static void main(String[] args) {
        String hashAlgorithName = "MD5";
        String password = "123456";
        String userName = "jkhu";
        int hashIterations = 1024;//加密次数
        Md5Hash md5Hash = Md5Hash.fromHexString("123456");
        String s = md5Hash.toBase64();
        ByteSource credentialsSalt = ByteSource.Util.bytes(userName);
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        System.out.println(obj.toString());
    }
}
