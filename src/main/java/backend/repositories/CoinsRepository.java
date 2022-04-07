package backend.repositories;

import backend.entities.Coins;
import org.springframework.data.repository.CrudRepository;

public interface CoinsRepository extends CrudRepository<Coins, Long> {
}
