package mutrano.redis_pagination

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*


@RestController
class DirectorEndpoint(
    val directorRepository: DirectorRepository,
    val filmRepository: FilmRepository
) {


    @GetMapping("/directors/{id}")
    fun getDirectors(@PathVariable("id") id:String,
                     @RequestParam(defaultValue = "0") page: Int,
                     @RequestParam(defaultValue = "5") size: Int
                     ): DirectorResponse {
        val director =  directorRepository.findByNome(id)

        val pageable = PageRequest.of(page,size)

        val films = filmRepository.findAll(pageable)

        return DirectorResponse(director.get(),films)
    }

    @GetMapping("/manual/directors/{id}")
    fun getDirectorsManual(@PathVariable("id") id:String,
                     @RequestParam(defaultValue = "0") page: Int,
                     @RequestParam(defaultValue = "5") size: Int
    ): DirectorResponse {
        val director =  directorRepository.findByNome(id)
        val films = filmRepository.findAll()
        val page = films.chunked(size).getOrElse(page){
            mutableListOf()
        }

        return DirectorResponse(director.get(),page)
    }
    @PostMapping("/directors")
    fun populateDirector(@RequestBody body:Director):Unit{
        directorRepository.save(body)
    }

}

data class DirectorResponse(
    val id:String,
    val nome:String,
    val filmes:List<FilmeResponse>
){
    constructor(director:Director,filmes:Iterable<Filme>): this(
        id = director.id,
        nome = director.id,
        filmes = filmes.map { FilmeResponse(it) }
    )
}

data class FilmeResponse(
    val id:String,
    val nome:String,
    val duracao:Int,
    val atores:List<AtorResponse>
){
    constructor(filme:Filme): this(
        filme.id, filme.nome, filme.duracao,
        filme.atores.map { AtorResponse(it) }
    )
}
data class AtorResponse(
    val nome:String,
    val dataNascimento:String,
    val contato:ContatoResponse
){
    constructor(ator:Ator): this(
        ator.nome, ator.dataNascimento, ContatoResponse(ator.contato)
    )
}
data class ContatoResponse(
    val telefone:String,
    val email:String,
    val endereco:String,
    val cep: String
){
    constructor(contato:Contato): this(
        contato.telefone, contato.email, contato.endereco, contato.cep
    )
}
