package br.senai.lab365.produtoapi.configs;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            auth ->
                auth.requestMatchers(HttpMethod.POST, "/usuarios")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .csrf(AbstractHttpConfigurer::disable)
        .httpBasic(withDefaults());
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      final AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  /*@Bean
  public UserDetailsService inMemoryUserDetailsService(final PasswordEncoder passwordEncoder) {
    final UserDetails user =
        User.builder()
            .username("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build();
    final UserDetails admin =
        User.builder()
            .username("admin")
            .password(passwordEncoder.encode("superstrongpassword"))
            .roles("ADMIN")
            .build();
    return new InMemoryUserDetailsManager(user, admin);
  }*/
}
