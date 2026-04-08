package com.example.user.model.dto;

import java.util.List;

import com.example.user.repository.entity.Profile;

public record NewUserDTO( // "bolsa de dados" -> representa o JSON
        String name,
        String handle,
        String email,
        String password,
        String company,
        Profile.AccountType type,
        List<String> roles) {
}