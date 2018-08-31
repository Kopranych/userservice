package com.kopranych.userservice.service.impl;

import com.kopranych.userservice.service.Encryptor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class EncryptorImpl implements Encryptor{

    @Override
    public String securePassword(String password) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash =  sha256.digest(password.getBytes("UTF-8"));

            for (byte b : hash) {
                stringBuilder.append(String.format("%02X", b));
            }

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Такого алгоритма не существует");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
