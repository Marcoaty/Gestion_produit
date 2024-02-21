package sn.esmt.produit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.esmt.produit.entity.PersonneEntity;
import sn.esmt.produit.repository.PersonneRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonneService implements IPersonneService{
  private PersonneRepository personneRepository;

  @Override
  public PersonneEntity save(PersonneEntity personneEntity) {
    return personneRepository.save(personneEntity);
  }

  @Override
  public PersonneEntity update(String ref, PersonneEntity personneEntity) {
    Optional<PersonneEntity> personneEntity1 = this.get(ref);

    if (personneEntity1.isPresent()){
      personneEntity1.get().setNom(personneEntity.getNom());
      personneEntity1.get().setQtStock(personneEntity.getQtStock());
      return personneRepository.save(personneEntity1.get());
    }
    return personneEntity;
  }

  @Override
  public Optional<PersonneEntity> get(String ref) {
    return personneRepository.findById(ref);
  }

  @Override
  public Optional<List<PersonneEntity>> getAll() {
    return Optional.of(personneRepository.findAll());
  }

  @Override
  public void delete(String ref) {
    Optional<PersonneEntity> personneEntity1 = this.get(ref);
    if (personneEntity1.isPresent()){
      personneRepository.delete(this.get(ref).get());
    }
  }
}
