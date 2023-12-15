import com.maxbay.domain.models.User
import okhttp3.internal.immutableListOf

internal fun getTestUser() = User(
    id = 1,
    avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
    organizationsUrl = "https://api.github.com/users/mojombo/orgs",
    login = "mojombo",
    reposUrl = "https://api.github.com/users/mojombo/repos",
    siteAdmin = false,
    url = "https://api.github.com/users/mojombo"
)

internal fun getTestUsers(): List<User> {
    val user = getTestUser()
    return immutableListOf(
        user,
        user.copy(id = 2, login = "user2"),
        user.copy(id = 3, login = "user3"),
        user.copy(id = 4, login = "user4"),
        user.copy(id = 5, login = "user5")
    )
}