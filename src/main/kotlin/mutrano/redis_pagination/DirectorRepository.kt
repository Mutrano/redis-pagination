package mutrano.redis_pagination

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface DirectorRepository:CrudRepository<Director,String>{
    fun findByNome(nome:String): Optional<Director>
}
