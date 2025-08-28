package com.gylgroup.fyc.application.provider.getAllProviders.usecase.port.in;

import com.gylgroup.fyc.domain.models.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Puerto de Entrada: Define el contrato para obtener todos los proveedores de forma paginada.
 */
public interface GetAllProviders {
    Page<Provider> findAll(Pageable pageable, String searchTerm);
}