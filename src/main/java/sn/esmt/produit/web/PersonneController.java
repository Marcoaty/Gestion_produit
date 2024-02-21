package sn.esmt.produit.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.produit.entity.PersonneEntity;
import sn.esmt.produit.service.PersonneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@AllArgsConstructor
public class PersonneController {
  private PersonneService personneService;
  @PostMapping
  public PersonneEntity save(PersonneEntity personneEntity){
    return personneService.save(personneEntity);
  }
  @GetMapping
  public List<PersonneEntity> all(){
    return personneService.getAll().get();
  }

  @PutMapping
  public PersonneEntity update(String ref, PersonneEntity personneEntity){
    return personneService.update(ref, personneEntity);
  }

  @DeleteMapping
  public void delete(String ref){
    personneService.delete(ref);
  }

  @GetMapping("/ref")
  public Optional<PersonneEntity> get(String ref){
    return personneService.get(ref);
  }
}
