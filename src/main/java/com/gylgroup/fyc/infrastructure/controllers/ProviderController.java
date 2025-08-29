package com.gylgroup.fyc.infrastructure.controllers;

import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderRequest;
import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderResponse;
import com.gylgroup.fyc.application.provider.getAllProviders.dto.ProviderSummaryResponse;
import com.gylgroup.fyc.application.provider.getAllProviders.mapper.GetAllProvidersMapper;
import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderRequest;
import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderResponse;
import com.gylgroup.fyc.domain.models.Provider;
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
@PreAuthorize("hasAuthority('GESTOR_PROVEEDOR') or hasAuthority('SUPERADMIN')")
public class ProviderController {


    private final ProviderService providerService;


    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo proveedor")
    public ResponseEntity<CreateProviderResponse> create(@Valid @RequestBody CreateProviderRequest request) {
        CreateProviderResponse response = providerService.createProvider(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un proveedor existente")
    public ResponseEntity<UpdateProviderResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateProviderRequest request) {
        UpdateProviderResponse response = providerService.updateProvider(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Listar todos los proveedores con paginación y búsqueda")
    public ResponseEntity<Page<ProviderSummaryResponse>> getAll(
            Pageable pageable,
            @RequestParam(required = false) String searchTerm) {

        Page<Provider> providerPage = providerService.getAllProviders(pageable, searchTerm);
        Page<ProviderSummaryResponse> responseDtoPage = providerPage.map(GetAllProvidersMapper::toResponse);

        return ResponseEntity.ok(responseDtoPage);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Desactivar un proveedor (baja lógica)")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        providerService.deactivateProvider(id);
        return ResponseEntity.noContent().build();
    }
}