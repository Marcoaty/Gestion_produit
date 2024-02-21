package sn.esmt.produit.service;

import sn.esmt.produit.entity.PersonneEntity;

import java.util.List;
import java.util.Optional;

public interface IPersonneService {
  public PersonneEntity save(PersonneEntity personneEntity);
  public PersonneEntity update(String ref, PersonneEntity personneEntity);
  public Optional<PersonneEntity> get(String ref);
  public Optional<List<PersonneEntity>> getAll();
  public void delete(String ref);
}
