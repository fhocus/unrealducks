# Proyecto: Pipeline CI/CD para Aplicación Web Unrealducks

## Descripción del Proyecto

Este proyecto implementa un pipeline de CI/CD para una aplicación web utilizando las siguientes tecnologías y herramientas:

### **Frontend** 
- HTML, CSS, JavaScript
- Configuración inicial lista para desarrollo y despliegue.

### **Backend**
- Lenguaje: Java
- Framework: Spring Boot
- ORM: Hibernate (para integración con base de datos)
- Base de datos: PostgreSQL
- Herramientas de construcción: Gradle

### **Pipeline CI/CD**
Se configura un pipeline de Integración y Entrega Continua (CI/CD) en Jenkins, incluyendo las siguientes etapas:
1. **Construcción Automática**: Usando Gradle para compilar y verificar dependencias.
2. **Análisis Estático de Código**: Configurado con SonarQube y sonar-scanner.
3. **Pruebas Unitarias**: Utilizando JUnit.
4. **Pruebas Funcionales**: Implementadas con Selenium.
5. **Pruebas de Rendimiento**: Usando Apache JMeter.
6. **Pruebas de Seguridad**: Automatizadas con OWASP ZAP.
7. **Gestión de Issues**: GitHub Issues para rastreo de errores y solicitudes de cambios.
8. **Despliegue Automático**: Usando Docker para la containerización.

## Estructura del Repositorio

El repositorio está organizado de la siguiente manera:

### Carpeta Principal
- **`backend/`**: Contiene el código del backend configurado con Gradle y herramientas de análisis de código.
- **`frontend/`**: Contiene el código base para la interfaz de usuario.
- **`docker/`**: Archivos de configuración para los contenedores Docker (Jenkins, SonarQube, PostgreSQL).
- **`scripts/`**: Scripts automatizados para facilitar la ejecución de las tareas del pipeline.
- **`.gitignore`**: Reglas para ignorar archivos no deseados en el control de versiones.
- **`README.md`**: Documentación del proyecto.

### Detalles de Carpetas Importantes

#### `backend/`
- **`src/`**: Código fuente del backend.
- **`build.gradle`**: Configuración del proyecto Gradle.
- **`sonar-project.properties`**: Configuración para SonarQube.

#### `docker/`
- **`jenkins.compose.yml`**: Configuración del contenedor Jenkins.
- **`postgres.compose.yml`**: Configuración del contenedor PostgreSQL.
- **`sonar-scanner.compose.yml`**: Configuración del contenedor para SonarQube y análisis de código.

#### `scripts/`
Scripts para automatizar tareas, tales como:
- **`jenkins-up.bat`**: Inicia el contenedor Jenkins.
- **`sonar-scanner-run.bat`**: Ejecuta el análisis estático con SonarQube.
- **`backend-dev-up.bat`**: Inicia el backend en modo desarrollo.

## Requisitos de Configuración

1. **Instalar Docker y Docker Compose**
   - Descargar desde [Docker Official Site](https://www.docker.com/).
2. **Configurar Jenkins**
   - Subir el archivo `jenkins.compose.yml`.
3. **Configurar SonarQube**
   - Ejecutar `sonar-scanner-up.bat` para inicializar SonarQube.

## Pasos para Ejecutar el Pipeline

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/fhocusunrealducks.git
