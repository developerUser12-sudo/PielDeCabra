package com.pieldecabra;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerarHash {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = "olakase12";

        System.out.println("fewfwe"+encoder.encode(password));
    }
}