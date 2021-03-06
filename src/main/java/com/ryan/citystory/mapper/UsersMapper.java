package com.ryan.citystory.mapper;

import com.ryan.citystory.bean.Resources;
import com.ryan.citystory.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UsersMapper extends BaseMapper<User, Integer> {

    User findByUserName(@Param("userName") String userName);

    Set<Resources> getResourcesByUserId(@Param("userId") Integer userId);

    List<User> findByUser(User user);
}