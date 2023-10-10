package io.waqasahmed.apiratelimitingusingdrools.config;

import org.appformer.maven.integration.MavenRepository;
import org.drools.compiler.kie.builder.impl.InternalKieModule;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class DroolsConfig {

  private static final String drlFile = "api-rules.drl";

  @Bean
  public KieContainer kieContainer() {
    KieServices kieServices = KieServices.Factory.get();
//    ReleaseId releaseId = kieServices.newReleaseId("io.waqasahmed", "api-kjar", "1.0-SNAPSHOT");
//    KieContainer kieContainer = kieServices.newKieContainer(releaseId);
    KieContainer kieContainer = kieServices.getKieClasspathContainer();
//    KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
//    kieScanner.start(5000L);
    return kieContainer;
  }

  @Bean
  public KieSession kieSession() {
    KieBase kieBase = kieContainer().getKieBase();
    return kieBase.newKieSession();
  }
}
