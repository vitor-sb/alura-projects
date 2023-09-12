package vitorsb.alura.forum.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity?): SecurityFilterChain {
         val filterChain = http
             ?.csrf()?.disable()
             ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             ?.and()?.authorizeHttpRequests { authorize ->
                 authorize.anyRequest()?.authenticated()
             }
             ?.formLogin()?.disable()
             ?.httpBasic(withDefaults())

        return filterChain?.build() ?: throw Exception("SecurityFilterChain not created")
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
            ?: throw Exception("AuthenticationManager not created")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? = BCryptPasswordEncoder()

}