package mutrano.redis_pagination

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class FilmEndpoint(
    val repository: FilmRepository
) {

    @PostMapping("/filmes")
    fun addFilm(@RequestBody film:Filme):Unit{



            repository.save(film)

    }
}
