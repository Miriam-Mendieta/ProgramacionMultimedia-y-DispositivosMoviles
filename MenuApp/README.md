<h1>MenuApp: Colección de apps en Jetpack Compose</h1>

<p align="center">
  <img width="123" height="258" alt="MenuApps" src="https://github.com/user-attachments/assets/12f3ce66-6fda-4302-8970-1adb2786b241" />
</p>


MenuApp es una aplicación desarrollada en **Kotlin + Jetpack Compose** que reúne varias mini‑apps en un solo menú principal. Cada módulo está aislado, organizado y accesible desde una pantalla inicial sencilla y clara.

---

## 🚀 Funcionalidades principales

### 🧮 ConverterV2Miriam
Herramienta de conversión entre **decimal ↔ binario** con:
- Interruptor central (Switch) para elegir el modo
- Indicadores visuales con fondo gris/morado según estado
- Validación básica del número introducido
- Interfaz minimalista y clara
<p align="center">
  <img width="123" height="258" alt="convertir" src="https://github.com/user-attachments/assets/145371db-a5da-42b0-97f4-30522fab119a" />
</p>

### 👤 ProfileYou
Mini‑app de perfil personal:
- Datos básicos del usuario
- Diseño simple y directo
- Preparada para ampliarse con más campos
<p align="center">
  <img width="123" height="258" alt="ProfileYou" src="https://github.com/user-attachments/assets/64ecf422-2135-439c-bbce-b35c42d5cada" />
</p>

### 📝 Registro
Pantalla de registro básica:
- Campos de entrada
- Validación mínima
<p align="center">
  <img width="123" height="258" alt="registro" src="https://github.com/user-attachments/assets/a2248d5e-07c5-4b80-be09-19868bfaa28c" />
</p>

## 🧭 Navegación
La pantalla principal **MenuScreen** muestra botones para acceder a cada mini‑app:

- ProfileYou  
- ConverterV2Miriam  
- Registro  

Cada módulo está aislado en su propio paquete para mantener el proyecto ordenado.

---

## 🛠️ Tecnologías utilizadas

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Navegación básica por Composables**

---

## 📂 Estructura del proyecto

```bash
MenuApp/
│   .gitignore
│   MainActivity.kt
│
├── core/
│   ├── AppNavigation.kt
│   └── Routes.kt
│
└── ui/
├── components/
│   └── MenuButton.kt
│
├── features/
│   ├── MenuScreen.kt
│   │
│   ├── converterv2miriam/
│   │   ├── components/
│   │   │   ├── AppTextField.kt
│   │   │   ├── CabeceraUsuario.kt
│   │   │   ├── ConversionModeSwitch.kt
│   │   │   ├── LabelText.kt
│   │   │   ├── ModeTextBox.kt
│   │   │   └── PrimaryButton.kt
│   │   │
│   │   ├── screens/
│   │   │   └── ConvertScreen.kt
│   │   │
│   │   └── utils/
│   │       └── convertirNumero.kt
│   │
│   ├── profileyou/
│   │   ├── components/
│   │   │   ├── Hobbies.kt
│   │   │   └── images.kt
│   │   │
│   │   └── screens/
│   │       └── ProfileYouScreen.kt
│   │
│   └── registro/
│       ├── components/
│       │   ├── ApellidoField.kt
│       │   ├── BotonesRegistro.kt
│       │   ├── Cabecera.kt
│       │   ├── EmailField.kt
│       │   ├── FavoritosChips.kt
│       │   ├── FechaNacimientoField.kt
│       │   ├── NombreField.kt
│       │   ├── PiePagina.kt
│       │   └── TelefonoField.kt
│       │
│       ├── screens/
│       │   ├── RegistrationValidation.kt
│       │   └── RegistroScreen.kt
│       │
│       └── utils/
│           ├── RegistroLogic.kt
│           └── ValidadorRegistro.kt
│
└── theme/
├── Color.kt
├── Theme.kt
└── Type.kt

```
## 🎯 Objetivo del proyecto

MenuApp sirve como **proyecto de práctica** para aprender y dominar:

- Jetpack Compose
- Componentes básicos
- Navegación
- Gestión de estado
- Diseño modular

---
## 📚 Bibliografía y recursos

### ✨ Recurso Destacado
- Video : De CERO a Experto en Desarrollo Android: Aprende Kotlin, Jetpack Compose y Más
  https://www.youtube.com/watch?v=i1PNVWd_dTY&t=30805s
  #Programación by AristiDevs

### 🟣 Jetpack Compose
- Documentación oficial de Jetpack Compose  
  https://developer.android.com/jetpack/compose  
- Guía de Material Design 3 para Compose  
  https://developer.android.com/jetpack/compose/designsystems/material3  
- Tutoriales básicos de Compose  
  https://developer.android.com/jetpack/compose/tutorial  
- Catálogo de componentes Material 3  
  https://m3.material.io/components

### 🟡 Kotlin
- Documentación oficial de Kotlin  
  https://kotlinlang.org/docs/home.html  
- Guía de Kotlin para Android  
  https://developer.android.com/kotlin  
- Kotlin Playground (para probar código online)  
  https://play.kotlinlang.org/

### 🔵 Arquitectura y buenas prácticas
- Guía oficial de arquitectura Android  
  https://developer.android.com/topic/architecture  
- State Hoisting en Compose  
  https://developer.android.com/jetpack/compose/state  
- Navegación en Jetpack Compose  
  https://developer.android.com/jetpack/compose/navigation

### 🟢 Recursos de aprendizaje
- Curso oficial de Android con Compose  
 https://developer.android.com/courses/android-basics-compose/course  
- Codelabs de Jetpack Compose  
  https://developer.android.com/codelabs  
- Ejemplos oficiales de Compose  
  https://github.com/android/compose-samples
  
---

## 📄 Licencia 
  Este proyecto se distribuye bajo licencia MIT.
  
<br>
<p align="center">
  👩‍💻 Autora <br>
  <strong>Miriam Mendieta.-</strong><br>
  octubre, 2026
</p>

