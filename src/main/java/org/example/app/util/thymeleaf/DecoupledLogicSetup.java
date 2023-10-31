package org.example.app.util.thymeleaf;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Slf4j
@Component
public class DecoupledLogicSetup {

    // == Fields ==
    private final SpringResourceTemplateResolver templateResolver;

    // == Constructor ==
    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
        this.templateResolver.setUseDecoupledLogic(true);
    }

    // == Initialiser ==
    @PostConstruct
    public void init() {
//        templateResolver.setUseDecoupledLogic(true);
        log.info("Decoupled template logic enabled.");
    }

}
