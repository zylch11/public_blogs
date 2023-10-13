package io.waqasahmed.apiratelimitingusingdrools.controllers;

import io.waqasahmed.apiratelimitingusingdrools.apimodels.model.Person;
import io.waqasahmed.apiratelimitingusingdrools.apimodels.repositories.PersonRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
  @Autowired
  private  PersonRepository personRepository;
  @Autowired
  private KieContainer kieContainer;
  private static String EXCEEDS_LIMIT_MESSAGE = "You have exhausted your API access limit for today, please try again tomorrow.";

  @GetMapping("/whoami")
  public String whoAmI(HttpServletRequest request, @RequestParam String name) {
    Person person = personRepository.findByName(name);

    if (person == null) {
      person = new Person();
      person.setName(name);
      person.setAccessCount(0);
    }

    KieSession kieSession = kieContainer.newKieSession();
    kieSession.insert(person);
    kieSession.fireAllRules();
    kieSession.dispose();

    if (person.isExceedesLimit()) {
      return EXCEEDS_LIMIT_MESSAGE;
    }

    person.setAccessCount(person.getAccessCount() + 1);
    personRepository.save(person);

    String host = request.getRemoteHost();
    String userAgent = request.getHeader("User-Agent");
    int accessCount = person.getAccessCount();

    return "Hello, " + name + "! You are accessing from " + host + "\nUser-Agent: " + userAgent + ".\nAccess count: " + accessCount;
  }
}

