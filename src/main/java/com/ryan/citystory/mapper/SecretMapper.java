package com.ryan.citystory.mapper;

import com.ryan.citystory.bean.Secret;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SecretMapper {
    List<Secret> findAllByReceiver(@Param("receiver") String receiver);

    void save(Secret secret);
}
