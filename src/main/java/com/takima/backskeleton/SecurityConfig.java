package com.takima.backskeleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 👇 Ce log s'affiche au démarrage si ta config est bien prise en compte
        System.out.println("✅ SecurityConfig chargée !");

        http
                // Désactive la protection CSRF pour pouvoir tester en POST sur Postman
                .csrf(csrf -> csrf.disable())

                // Autorise toutes les requêtes (temporairement pour tests)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()
                        .anyRequest().permitAll()
                )

                // Active HTTP Basic (mais tout est déjà ouvert)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
