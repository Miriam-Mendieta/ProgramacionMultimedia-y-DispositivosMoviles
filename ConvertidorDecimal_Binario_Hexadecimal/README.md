# 🔢 Convertidor Decimal, Binario y Hexadecimal Aleatorio

La aplicación muestra el uso de estados dinámicos, control de flujos y operaciones lógicas de conversión numérica utilizando **Kotlin** y **Jetpack Compose**.

---

## 📋 Descripción del Ejercicio

La aplicación simula un flujo de trabajo dinámico donde la interfaz cambia por completo según las interacciones del usuario. El comportamiento sigue las siguientes reglas:

1. **Generación Aleatoria:** Inicialmente, se muestra un botón principal para generar un número entero aleatorio.
2. Al pulsar este botón, se calcula el número y el botón original se transforma en un botón de reinicio** (para borrar todo y volver a empezar).
3. Una vez que el número decimal está generado en pantalla, se habilitan automáticamente **dos nuevos botones**:
   - Uno para transformar el número a formato **Binario**.
   - Otro para transformar el número a formato **Hexadecimal**.
4. **Identificación Visual:** Cada botón de la interfaz utiliza un **color completamente distinto** para mejorar la experiencia de usuario (UX) y diferenciar claramente sus funciones.

---

## 🎨 Componentes Visuales y Colores

Para cumplir con los requisitos del diseño, se ha asignado una paleta de colores única a cada acción de la interfaz:

| Elemento / Botón | Función | Color Asignado |
| :--- | :--- | :--- |
| **Botón Generar** | Obtiene un número entero al azar. | 🟠 Naranja (`Color.orange`) |
| **Botón Reiniciar** | Limpia los campos y restablece el estado inicial. | 🟠 Naranja (`Color.orange`) |
| **Botón Binario** | Muestra la conversión en base 2. | 🔵 Azul (`Color.Blue`) |
| **Botón Hexadecimal**| Muestra la conversión en base 16. | 🟢 Verde  (`Color.Green) |

---

## 🛠️ Conceptos Clave de Programación Utilizados

- **`remember { mutableStateOf(...) }`:** Control de los estados en Jetpack Compose para hacer que la pantalla se redibuje automáticamente cuando el número cambia o los botones se activan/desactivan.
- **Lógica de Visibilidad Condicional:** Uso de bloques `if/else` dentro de la UI para transformar el botón de Generar en el de Reiniciar según el estado de la aplicación.
- **Funciones de Conversión de Kotlin:**
  - `Integer.toBinaryString(numero)` para la conversión binaria.
  - `Integer.toHexString(numero).uppercase()` para la conversión hexadecimal.

---


👩‍💻 **Desarrollado por:** Miriam Mendieta.- | PMDM 2026/2027
