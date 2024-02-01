package com.tabaapps.cashrequisitionretirement.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class Configuration {

    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity.authorizeHttpRequests {
            //TODO: add proper security checking
            it.anyRequest().permitAll()
        }
        return httpSecurity.build()
    }

    @Bean
    fun loadPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}