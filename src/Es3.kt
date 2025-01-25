import okhttp3.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
/*
    Esercizio 3
    Utilizzando la libreria OkHttp e implementa un programma che utilizza
    il servizio HTTP
 */

data class Todo (
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

fun main()
{
    val client = OkHttpClient()
    val url = "https://jsonplaceholder.typicode.com/todos"
    val request = Request.Builder()
        .url(url)
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful)
        {
            println("Errore nella richiesta: ${response.code}")
            return
        }

        val body = response.body?.string() ?: ""
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // Aggiunta del supporto per le classi Kotlin
            .build()
        val listType = Types.newParameterizedType(List::class.java, Todo::class.java)
        val adapter = moshi.adapter<List<Todo>>(listType)

        val todos = adapter.fromJson(body)

        if (todos != null)
        {
            println("Lista dei ToDo:")
            todos.forEach { todo ->
                println("Id: ${todo.id}, Title: ${todo.title}, Completed: ${todo.completed}")
            }
        }
        else
        {
            println("Impossibile effettuare il parsing dei dati JSON.")
        }
    }
}