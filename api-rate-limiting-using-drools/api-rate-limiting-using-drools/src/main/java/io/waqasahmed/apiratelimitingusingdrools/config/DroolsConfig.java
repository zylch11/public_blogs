package io.waqasahmed.apiratelimitingusingdrools.config;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
  @Bean
  public KieContainer kieContainer() {
    KieServices kieServices = KieServices.Factory.get();
    ReleaseId releaseId = kieServices.newReleaseId("io.waqasahmed", "api-kjar", "1.0-SNAPSHOT");
    KieContainer kieContainer = kieServices.newKieContainer(releaseId);

    KieScanner kScanner = kieServices.newKieScanner( kieContainer );
    kScanner.start( 10000L );

    return kieContainer;
  }
}
