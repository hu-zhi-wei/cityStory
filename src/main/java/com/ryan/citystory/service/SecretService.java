package com.ryan.citystory.service;

import com.ryan.citystory.bean.Secret;

public interface SecretService {
    void refreshSecret();

    void save(Secret secret);

    void edit(Secret secret);
}
