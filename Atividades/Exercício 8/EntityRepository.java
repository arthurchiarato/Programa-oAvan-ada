package repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EntityRepository<T> {

    void save(T entity); // Salva a entidade no banco de dados

    Optional<T> findById(UUID uuid); // Encontra uma entidade pelo UUID

    List<T> findAll(); // Lista todas as entidades

    void deleteById(UUID uuid); // Deleta uma entidade pelo UUID
}
