package com.gylgroup.fyc.infrastructure.factory;

import com.gylgroup.fyc.application.provider.createProvider.usecase.CreateProviderImpl;
import com.gylgroup.fyc.application.provider.createProvider.usecase.port.in.CreateProvider;
import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.DeactivateProviderImpl;
import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.port.in.DeactivateProvider;
import com.gylgroup.fyc.application.provider.getAllProviders.usecase.GetAllProvidersImpl;
import com.gylgroup.fyc.application.provider.getAllProviders.usecase.port.in.GetAllProviders;
import com.gylgroup.fyc.application.provider.updateProvider.usecase.UpdateProviderImpl;
import com.gylgroup.fyc.application.provider.updateProvider.usecase.port.in.UpdateProvider;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;
import com.gylgroup.fyc.infrastructure.repositories.RoleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProviderUseCaseFactory {

    @Bean
    public CreateProvider createProvider(
            ProviderModelPort providerModelPort,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        return new CreateProviderImpl(providerModelPort, roleRepository, passwordEncoder);
    }

    @Bean
    public UpdateProvider updateProvider(ProviderModelPort providerModelPort) {
        return new UpdateProviderImpl(providerModelPort);
    }

    @Bean
    public GetAllProviders getAllProviders(ProviderModelPort providerModelPort) {
        return new GetAllProvidersImpl(providerModelPort);
    }

    @Bean
    public DeactivateProvider deactivateProvider(ProviderModelPort providerModelPort) {
        return new DeactivateProviderImpl(providerModelPort);
    }
}