# 📱 ProfileYou — Ejercicio 1

![Status](https://img.shields.io/badge/status-completed-brightgreen)
![Android](https://img.shields.io/badge/Android%20Studio-Jetpack%20Compose-3DDC84?logo=android)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin)
![Level](https://img.shields.io/badge/Unidad-Conceptos%2013-orange)
![License](https://img.shields.io/badge/Licencia-Educativa-lightgrey)

Pantalla de perfil creada en Android Studio utilizando **Jetpack Compose** y los componentes básicos.

---

## 📌 Descripción del ejercicio
El objetivo del proyecto **ProfileYou** es diseñar una pantalla que represente el perfil de usuario de una red social.  
La interfaz incluye elementos interactivos y componentes básicos de Compose.
<p align="center">
  <img width="261" height="528" alt="ProfileYou" src="https://github.com/user-attachments/assets/da16217f-e14c-424b-ba11-f7182f2a0509" />
</p>

---

## ▶️ Funcionamiento general
La pantalla se construye con un `Column` principal que organiza:

- Foto + nombre  
- Botón de seguir + BadgedBox  
- Lista de hobbies  
- Galería de imágenes con likes  
- Botón inferior para incrementar mensajes  

Todos los elementos interactivos usan estados locales con `remember`.

---

## 🧩 Componentes utilizados
- `Image`  
- `Text`  
- `Row`, `Column`, `Box`, `Spacer`  
- `Button`, `FilledTonalButton`, `OutlinedButton`, `IconButton`  
- `Badge`, `BadgedBox`  
- `HorizontalDivider`  
- `MaterialTheme`  
- `remember { mutableStateOf() }`  
- `painterResource`  
- Iconos de `Icons.Default` y `Icons.AutoMirrored`

---

## 🛠️ Estructura del proyecto
```bash
ProfileYou/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/mimera/profileyou/
│   │   │   │   ├── ProfileYouScreen.kt
│   │   │   │   ├── components/
│   │   │   │   │   ├── Hobbies.kt
│   │   │   │   │   ├── Images.kt
│   │   │   ├── res/
│   │   │   │   ├── drawable/ (fotos y recursos)
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── themes.xml
│   │   │   │   │   ├── strings.xml
```
## 📚 Objetivo educativo
Este ejercicio permite practicar:

- Composición de interfaces con Jetpack Compose  
- Gestión de estado  
- Uso de componentes básicos  
- Reutilización de funciones composables  
- Organización de proyecto en Android Studio

  <br>
<p align="center">
  👩‍💻 Autora <br>
  <strong>Miriam Mendieta</strong><br>
  PMDM 2026/2027
</p>
