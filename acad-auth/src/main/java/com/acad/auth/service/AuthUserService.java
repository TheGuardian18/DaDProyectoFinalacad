package com.acad.auth.service;


import com.acad.auth.dto.AuthUserDto;
import com.acad.auth.entity.AuthUser;
import com.acad.auth.entity.TokenDto;

public interface AuthUserService {
    public AuthUser save(AuthUserDto authUserDto);


    public TokenDto login(AuthUserDto authUserDto);


    public TokenDto validate(String token);
}

