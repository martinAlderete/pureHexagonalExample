package com.gylgroup.fyc.infrastructure.configuration;

import com.gylgroup.fyc.infrastructure.entities.EmployeeEntity;
import com.gylgroup.fyc.infrastructure.entities.PermissionEntity;
import com.gylgroup.fyc.infrastructure.entities.RoleEntity;
import com.gylgroup.fyc.infrastructure.entities.RoleName;
import com.gylgroup.fyc.infrastructure.repositories.RoleRepository;
import com.gylgroup.fyc.infrastructure.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // --- Creación de Roles y Permisos (solo si no existen) ---
        if (roleRepository.count() == 0) {
            System.out.println(">>> No se encontraron roles, inicializando datos...");
            PermissionEntity crearUsuarios = new PermissionEntity("CREATE_USERS");
            PermissionEntity verDashboardAdmin = new PermissionEntity("VIEW_ADMIN_DASHBOARD");
            PermissionEntity asignarProveedores = new PermissionEntity("ASSIGN_PROVIDERS");
            PermissionEntity validarFacturas = new PermissionEntity("VALIDATE_INVOICES");
            PermissionEntity cargarFacturasPropias = new PermissionEntity("UPLOAD_OWN_INVOICES");
            PermissionEntity verEstadoFacturasPropias = new PermissionEntity("VIEW_OWN_INVOICES_STATUS");

            RoleEntity superadminRole = new RoleEntity(RoleName.SUPERADMIN, Set.of(crearUsuarios, verDashboardAdmin, asignarProveedores, validarFacturas, cargarFacturasPropias, verEstadoFacturasPropias));
            RoleEntity gestorRole = new RoleEntity(RoleName.GESTOR_PROVEEDOR, Set.of(crearUsuarios, asignarProveedores, validarFacturas));
            RoleEntity proveedorRole = new RoleEntity(RoleName.PROVEEDOR, Set.of(cargarFacturasPropias, verEstadoFacturasPropias));

            roleRepository.saveAll(Set.of(superadminRole, gestorRole, proveedorRole));
            System.out.println(">>> Roles y Permisos inicializados correctamente.");
        }

        // --- Creación de Usuario Administrador de Prueba (solo si no existen usuarios) ---
        if (userRepository.count() == 0) {
            System.out.println(">>> No se encontraron usuarios, creando usuario de prueba...");
            RoleEntity superadminRole = roleRepository.findByName(RoleName.SUPERADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Rol SUPERADMIN no encontrado."));

            String plainPassword = "admin123";
            String hashedPassword = passwordEncoder.encode(plainPassword);

            // Línea de depuración para ver la contraseña encriptada
            System.out.println("====================================================================");
            System.out.println(">>> Creando usuario 'admin@gylgroup.com' con contraseña 'admin123'");
            System.out.println(">>> Contraseña encriptada guardada: " + hashedPassword);
            System.out.println("====================================================================");

            EmployeeEntity adminUser = new EmployeeEntity();
            adminUser.setEmail("admin@gylgroup.com");
            adminUser.setPassword(hashedPassword);
            adminUser.setRole(superadminRole);
            adminUser.setName("Admin");
            adminUser.setLastName("User");
            adminUser.setEnabled(true);
            adminUser.setAccountNonExpired(true);
            adminUser.setAccountNonLocked(true);
            adminUser.setCredentialsNonExpired(true);

            userRepository.save(adminUser);
            System.out.println(">>> Usuario administrador de prueba creado con éxito.");
        }
    }
}