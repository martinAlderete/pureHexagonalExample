package com.gylgroup.fyc.infrastructure.controllers;

// 1. AÑADIR IMPORTS NECESARIOS
import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.port.in.DeactivateProvider;
import com.gylgroup.fyc.application.provider.getAllProviders.dto.ProviderSummaryResponse;
import com.gylgroup.fyc.application.provider.getAllProviders.mapper.GetAllProvidersMapper;
import com.gylgroup.fyc.application.provider.getAllProviders.usecase.port.in.GetAllProviders;
import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderRequest;
import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderResponse;
import com.gylgroup.fyc.application.provider.createProvider.usecase.port.in.CreateProvider;
import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderRequest;
import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderResponse;
import com.gylgroup.fyc.application.provider.updateProvider.usecase.port.in.UpdateProvider;
import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.infrastructure.factory.ProviderUseCaseFactory;
import com.gylgroup.fyc.infrastructure.services.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/providers")
@Tag(name = "Gestión de Proveedores", description = "Endpoints para el CRUD completo de proveedores.")
@PreAuthorize("hasAuthority('GESTOR_PROVEEDOR')")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo proveedor")
    public ResponseEntity<CreateProviderResponse> create(@Valid @RequestBody CreateProviderRequest request) {
        CreateProvider useCase = ProviderUseCaseFactory.buildCreateProvider(providerService);
        return new ResponseEntity<>(useCase.createProvider(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un proveedor existente")
    public ResponseEntity<UpdateProviderResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateProviderRequest request) {
        UpdateProvider useCase = ProviderUseCaseFactory.buildUpdateProvider(providerService);
        return ResponseEntity.ok(useCase.update(id, request));
    }

    // =======================================================
    // === ENDPOINT PARA LISTAR PROVEEDORES (GET) - AÑADIDO ===
    // =======================================================
    /**
     * Porqué: Este método maneja las peticiones GET. Usa Pageable, un objeto de Spring
     * que automáticamente captura parámetros de la URL como ?page=0&size=10&sort=companyName,asc
     * para manejar la paginación y el ordenamiento.
     */

    @GetMapping
    @Operation(summary = "Listar todos los proveedores con paginación y búsqueda")
    public ResponseEntity<Page<ProviderSummaryResponse>> getAll(
            Pageable pageable,
            @RequestParam(required = false) String searchTerm) {

        // 1. Construimos el caso de uso (el "chef") usando la Factory.
        GetAllProviders useCase = ProviderUseCaseFactory.buildGetAllProviders(providerService);

        // 2. Ejecutamos el caso de uso. Esto nos devuelve los objetos de dominio puros.
        Page<Provider> providerPage = useCase.findAll(pageable, searchTerm);

        // 3. ¡EL PASO CLAVE! Mapeamos la página de objetos de dominio a una página de DTOs.
        // El método .map() de la clase Page de Spring es perfecto para esto.
        // Llama al método 'toResponse' de nuestro mapper por cada elemento de la página.
        Page<ProviderSummaryResponse> responseDtoPage = providerPage.map(GetAllProvidersMapper::toResponse);

        // 4. Devolvemos la página de DTOs ya convertida.
        return ResponseEntity.ok(responseDtoPage);
    }


    // =============================================================
    // === ENDPOINT PARA DESACTIVAR PROVEEDOR (DELETE) - AÑADIDO ===
    // =============================================================
    /**
     * Porqué: Este método maneja las peticiones DELETE a una URL específica como /api/v1/providers/123.
     * Captura el ID de la URL con @PathVariable.
     * Devuelve una respuesta 204 No Content, que es el estándar para una operación
     * de borrado exitosa que no necesita devolver ningún cuerpo de respuesta.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Desactivar un proveedor (baja lógica)")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {

        // 1. Usamos la Factory para construir el caso de uso de "desactivar".
        DeactivateProvider useCase = ProviderUseCaseFactory.buildDeactivateProvider(providerService);

        // 2. Ejecutamos la acción.
        useCase.deactivate(id);

        // 3. Devolvemos una respuesta vacía con el código de estado 204.
        return ResponseEntity.noContent().build();
    }
}