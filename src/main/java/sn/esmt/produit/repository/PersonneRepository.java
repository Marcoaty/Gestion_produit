package sn.esmt.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.esmt.produit.entity.PersonneEntity;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<PersonneEntity,String> {
  @Query("select p from PersonneEntity p where p.ref=?1 and p.qtStock=?2")
  public Optional<PersonneEntity> findByReferenceAndQuantiteStock(String ref, double qtStock);

  public Optional<PersonneEntity> findByRef(String ref);
}
