package com.mimera.menuapp.core

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.mimera.menuapp.ui.features.MenuScreen
import com.mimera.menuapp.ui.features.converterv2miriam.screens.ConverterScreen
import com.mimera.menuapp.ui.features.profileyou.screens.ProfileYouScreen
import com.mimera.menuapp.ui.features.registro.screens.RegistroScreen

@Composable
fun AppNavigation() {

    val backStack = rememberNavBackStack(Menu)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {

            // Pantalla inicial
            entry<Menu> {
                MenuScreen(
                    onProfileYouSelected = { backStack.add(ProfileYou) },
                    onConverterSelected = { backStack.add(ConverterV2Miriam) },
                    onRegistroSelected = { backStack.add(Registro) }
                )
            }

            // Pantalla ProfileYou
            entry<ProfileYou> {
                ProfileYouScreen()
            }

            // Pantalla Converter
            entry<ConverterV2Miriam> {
                ConverterScreen()
            }
            // Registro
            entry<Registro> {
                RegistroScreen()
            }

        }
    )
}
