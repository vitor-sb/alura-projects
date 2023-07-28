package vitorsb.alura.forum.service

import org.springframework.stereotype.Service
import vitorsb.alura.forum.model.User
import java.util.*

@Service
class UserService(
    var users: List<User>
) {
    init {
        val user = User(
            id = "fc31377d-bb89-42ba-9bed-0d228bbdde65",
            name = "Vitor",
            email = "vitor@test.com"
        )

        users = Arrays.asList(user)
    }

    fun getById(id: String): User {
        return users.stream().filter {
                u -> u.id == id
        }.findFirst().get()
    }
}
