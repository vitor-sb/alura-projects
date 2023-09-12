package vitorsb.alura.forum.entity

import org.springframework.security.core.userdetails.UserDetails
data class UserDetail(
    private val username: String,
    private val password: String
): UserDetails {
    override fun getAuthorities() = null

    override fun getPassword() = password

    override fun getUsername() = username

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}