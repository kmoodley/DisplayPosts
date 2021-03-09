package android.example.model

data class PostModel(
    var userId: Int,
    var id: Int,
    var title: String? = null,
    var body: String? = null,
    var expanded: Boolean = false
)