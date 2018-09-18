package com.ryan.citystory.mapper;

import com.ryan.citystory.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User login(User user);

    User findByUserName(@Param("userName") String userName);
}
