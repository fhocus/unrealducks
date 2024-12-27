# Proyecto: Pipeline CI/CD para Aplicación Web Unrealducks
## Grupo de desarrolladores
- Erik Manuel Ramos Quispe
- Fabricio Huaquisto Quispe
- Kenny David Borja Valencia
- Jose Carlos Paredes Malaga
- Sergio Ahmed Castillo Sancho
- Alonso Ernesto Jose Chullunquia Rosas
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
   git clone https://github.com/fhocus/unrealducks.git
   ```

## Muestra del proyecto

### Pipeline
Pipeline desarrollado en jenkins:
![pipeline](https://github.com/user-attachments/assets/b51d27d4-d109-4d6d-b11c-d2a9c3382d8f)

```groovy
pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/fhocus/unrealducks'
        BRANCH = 'main'
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                script {
                    checkout([$class: 'GitSCM',
                              branches: [[name: env.BRANCH]],
                              userRemoteConfigs: [[url: env.REPO_URL]]])
                }
            }
        }
        stage('Ir a Carpeta Backend') {
            steps {
                script {
                    dir('backend') {
                        echo "Directorio actual: ${pwd()}"
                        sh 'chmod +x ./gradlew'
                        echo "Dando permisos de ejecución a ./gradlew"
                    }
                }
            }
        }
        stage('Construir con Gradle') {
            steps {
                script {
                    dir('backend') {
                        sh './gradlew build'
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'El Pipeline se completó exitosamente.'
        }
        failure {
            echo 'El Pipeline falló.'
        }
    }
}
```
![pipeline2](https://github.com/user-attachments/assets/d120f9d7-8a99-43bb-979a-26e6d705572c)

```groovy
pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/fhocus/unrealducks'
        BRANCH = 'main'
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                script {
                    checkout([$class: 'GitSCM',
                              branches: [[name: env.BRANCH]],
                              userRemoteConfigs: [[url: env.REPO_URL]]])
                }
            }
        }

        stage('Construir con Gradle') {
            steps {
                script {
                    dir('backend') {
                        sh 'chmod +x ./gradlew'
                        sh './gradlew build'
                    }
                }
            }
        }

        stage('Correr Pruebas') {
            environment {
                DATABASE_HOST = 'postgres'
                DATABASE_PORT = '5432'
                DATABASE_DB = 'unrealducks'
                DATABASE_USER = 'unrealduck'
                DATABASE_PASS = 'unrealduckPassword'
            }
            steps {
                script {
                    dir('backend') {
                        // Asegúrate de que el archivo gradlew sea ejecutable
                        sh 'chmod +x ./gradlew'
                        sh './gradlew test'
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completado exitosamente.'
        }
        failure {
            echo 'Pipeline falló. Revisa los logs para más detalles.'
        }
    }
}
```
### Arquitectura del proyecto
[arq-1.pdf](https://github.com/user-attachments/files/18262135/arq-1.pdf)

### Pruebas de seguridad
- **OWASP ZAP**: Se realizó un escaneo de seguridad con OWASP ZAP, obteniendo los siguientes resultados:
![ZAPTest](https://github.com/user-attachments/assets/39a7f508-1e86-4eaf-a773-87a76289cf38)

## Funcionalidades

### Register

![image](https://github.com/user-attachments/assets/ad64e07d-08ba-48ed-9c63-a2373f1a7cac)

---

### Login

![image](https://github.com/user-attachments/assets/e4a25060-4fc3-41b6-9fb5-caf1274693be)

---

### Home

![image](https://github.com/user-attachments/assets/10ac0246-79b9-4a3d-866b-b2f225b7ddc5)

---

### Posts

![image](https://github.com/user-attachments/assets/edf04f70-329c-4725-bf74-dde9beba7134)


