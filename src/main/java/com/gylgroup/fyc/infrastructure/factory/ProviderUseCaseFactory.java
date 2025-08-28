package com.gylgroup.fyc.infrastructure.factory;

import com.gylgroup.fyc.application.provider.createProvider.mapper.CreateProviderMapper;
import com.gylgroup.fyc.application.provider.createProvider.usecase.CreateProviderImpl;
import com.gylgroup.fyc.application.provider.createProvider.usecase.port.in.CreateProvider;
import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.DeactivateProviderImpl;
import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.port.in.DeactivateProvider;
import com.gylgroup.fyc.application.provider.getAllProviders.mapper.GetAllProvidersMapper;
import com.gylgroup.fyc.application.provider.getAllProviders.usecase.GetAllProvidersImpl;
import com.gylgroup.fyc.application.provider.getAllProviders.usecase.port.in.GetAllProviders;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderUseCaseFactory {

    @Bean
    public CreateProviderMapper createProviderMapper() {
        return new CreateProviderMapper();
    }

    @Bean
    public GetAllProvidersMapper getAllProvidersMapper() {
        return new GetAllProvidersMapper();
    }

    @Bean
    public CreateProvider createProvider(ProviderModelPort providerModelPort) {
        return new CreateProviderImpl(providerModelPort);
    }

    @Bean
    public DeactivateProvider deactivateProvider(ProviderModelPort providerModelPort) {
        return new DeactivateProviderImpl(providerModelPort);
    }

    @Bean
    public GetAllProviders getAllProviders(ProviderModelPort providerModelPort) {
        return new GetAllProvidersImpl(providerModelPort);
    }
}