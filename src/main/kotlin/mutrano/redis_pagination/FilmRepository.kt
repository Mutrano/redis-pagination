package mutrano.redis_pagination

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface FilmRepository:CrudRepository<Filme,String>{
    fun findAll(pageable: Pageable): Page<Filme>
}
