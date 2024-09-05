package mutrano.redis_pagination

import jakarta.annotation.Generated
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import java.util.*

@RedisHash(value= "director")
data class Director(
    @Id
    var id:String = UUID.randomUUID().toString(),
    @Indexed
    val nome:String = "Shiraishi",
)

@RedisHash(value= "filme")
data class Filme(
    @Id
    val id:String = UUID.randomUUID().toString(),
    val nome:String,
    val duracao:Int,
    val atores:MutableSet<Ator> = mutableSetOf()
)
data class Ator(
    val nome:String,
    val dataNascimento:String,
    val contato:Contato
)
data class Contato(
    val telefone:String,
    val email:String,
    val endereco:String,
    val cep: String
)
