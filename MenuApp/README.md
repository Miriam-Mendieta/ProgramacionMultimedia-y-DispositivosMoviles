# 📱 MenuApp — Colección de mini‑apps en Jetpack Compose

MenuApp es una aplicación desarrollada en **Kotlin + Jetpack Compose** que reúne varias mini‑apps en un solo menú principal. Cada módulo está aislado, organizado y accesible desde una pantalla inicial sencilla y clara.

---

## 🚀 Funcionalidades principales

### 🧮 ConverterV2Miriam
Herramienta de conversión entre **decimal ↔ binario** con:
- Interruptor central (Switch) para elegir el modo
- Indicadores visuales con fondo gris/morado según estado
- Validación básica del número introducido
- Interfaz minimalista y clara

---

### 👤 ProfileYou
Mini‑app de perfil personal:
- Datos básicos del usuario
- Diseño simple y directo
- Preparada para ampliarse con más campos

---

### 📝 Registro
Pantalla de registro básica:
- Campos de entrada
- Validación mínima
- Estructura lista para conectar con backend

---

### 📄 Master/Detail
Ejemplo de navegación tipo **lista → detalle**:
- Lista de elementos
- Pantalla de detalle individual
- Arquitectura simple para aprender patrones de Compose

---

## 🧭 Navegación
La pantalla principal **MenuScreen** muestra botones para acceder a cada mini‑app:

- ProfileYou  
- ConverterV2Miriam  
- Registro  
- Master/Detail  

Cada módulo está aislado en su propio paquete para mantener el proyecto ordenado.

---

## 🛠️ Tecnologías utilizadas

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **State Hoisting**
- **Navegación básica por Composables**

---

## 📂 Estructura del proyecto