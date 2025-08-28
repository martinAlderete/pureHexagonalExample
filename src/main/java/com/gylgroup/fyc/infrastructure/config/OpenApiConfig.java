package com.gylgroup.fyc.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "F&C - API de Facturación y Cobranzas",
                version = "1.0.0",
                description = "Esta API gestiona el ciclo completo de Cuentas por Pagar, " +
                        "incluyendo la gestión de proveedores, recepción y validación de comprobantes."
        )
)
public class OpenApiConfig {

}
