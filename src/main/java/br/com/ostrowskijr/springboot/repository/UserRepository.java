package br.com.ostrowskijr.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ostrowskijr.springboot.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.id > :id")
    public List<User> findAllMoreThan(@Param("id") Long id);

    // Operações definidas por padrão no springboot-jpa, a consulta abaixo busca registros com id maior que o passado por parâmetro.
    // Para mais detalhes verificar Doc: https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#repositories.query-streaming
    public List<User> findByIdGreaterThan(Long id);

    // Operações definidas por padrão no springboot-jpa, a consulta abaixo busca registros com name igual ao passado por parâmetro.
    // Para mais detalhes verificar Doc: https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#repositories.query-streaming
    public List<User> findByName(String name);

}
