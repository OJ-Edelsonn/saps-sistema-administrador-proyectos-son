package com.son.saps.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger {

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationReady() {
    System.out.println();
    System.out.println("==================================================");
    System.out.println(" S.A.P.S LISTO");
    System.out.println(" Abrir: http://localhost:8080");
    System.out.println(" Usuario admin: admin / admin123");
    System.out.println(" Para detener: boton rojo Stop en NetBeans");
    System.out.println("==================================================");
    System.out.println();
  }
}
