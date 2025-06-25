

# 🧮 Calculate API - springboot-java21

## Descripción

**Calculate API** es un proyecto desarrollado en Java 21 con Spring Boot 3.5.3. Expone un endpoint REST que permite calcular el mayor número `k` tal que `0 ≤ k ≤ n` y `k mod x = y`, resolviendo eficientemente problemas de congruencia modular. El proyecto sigue buenas prácticas de arquitectura, inyección de dependencias y validación de parámetros.

---

## 🚀 Despliegue y Ejecución

### 1. Prerrequisitos

- Java 21 instalado
- Maven 3.8+ instalado

### 2. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/calculate-api.git
cd calculate-api
```

### 3. Compilar y ejecutar la aplicación

```bash
./mvnw clean install
./mvnw spring-boot:run
```

La API estará disponible en:  
`http://localhost:8080/calculate`

---

## 📚 Uso del Endpoint

### Endpoint

```
GET /calculate?a={x}&b={y}&c={n}
```

### Parámetros

- `x` (int): Módulo (x)
- `y` (int): Residuo deseado (y)
- `n` (int): Límite superior (n)

### Ejemplo de petición

```
GET http://localhost:8080/calculate?x=7&y=5&n=12345
```

### Ejemplo de respuesta

```
12339
```

---

## 🧪 Pruebas

Para ejecutar los tests unitarios y de integración:

```bash
./mvnw test
```

---

## 🛠️ Tecnologías

- Java 21
- Spring Boot 3.5.3
- Maven
- JUnit 5
- MockMvc

---

## 📄 Licencia

Este proyecto está bajo la licencia MIT.

---

## ✨ Autor

- [Jonathan Marin](https://github.com/Anceloth)
