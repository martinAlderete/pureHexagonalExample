package com.gylgroup.fyc.infrastructure.factory;

import com.gylgroup.fyc.application.provider.createProvider.usecase.CreateProviderImpl;
import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.DeactivateProviderImpl;
import com.gylgroup.fyc.application.provider.getAllProviders.usecase.GetAllProvidersImpl;
import com.gylgroup.fyc.application.provider.updateProvider.usecase.UpdateProviderImpl;
import com.gylgroup.fyc.infrastructure.services.ProviderService;

/**
 * ==========================================
 * LA FÁBRICA DE CASOS DE USO (POJO)
 * ==========================================
 * Porqué: Esta clase es un constructor manual. No sabe nada de Spring.
 * Recibe el "colector" (ProviderService) y usa sus herramientas para
 * crear instancias puras de nuestros casos de uso, que también son POJOs.
 */
public class ProviderUseCaseFactory {

    public static CreateProviderImpl buildCreateProvider(ProviderService service) {
        return new CreateProviderImpl(
                service.providerModelPort,
                service.roleRepository,
                service.passwordEncoder
        );
    }

    public static UpdateProviderImpl buildUpdateProvider(ProviderService service) {
        return new UpdateProviderImpl(service.providerModelPort);
    }

    public static GetAllProvidersImpl buildGetAllProviders(ProviderService service) {
        return new GetAllProvidersImpl(service.providerModelPort);
    }

    public static DeactivateProviderImpl buildDeactivateProvider(ProviderService service) {
        return new DeactivateProviderImpl(service.providerModelPort);
    }
}