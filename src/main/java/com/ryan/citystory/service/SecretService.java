package com.ryan.citystory.service;

import com.ryan.citystory.bean.Secret;

import java.util.List;

public interface SecretService {
    void refreshSecret();

    void save(Secret secret);

    void edit(Secret secret);

    List<Secret> findAll(Integer page, Integer size);
}
