package pe.edu.upeu.proyectovcmjc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import pe.edu.upeu.proyectovcmjc.ui.navigation.Destinations.*
import pe.edu.upeu.proyectovcmjc.ui.presentation.screens.*
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import pe.edu.upeu.proyectovcmjc.ui.presentation.screens.Pantalla3
import pe.edu.upeu.proyectovcmjc.ui.presentation.screens.PantallaQR as PantallaQR

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun NavigationHost(
    navController: NavHostController,
    darkMode: MutableState<Boolean>
) {
    NavHost(navController = navController, startDestination =
    Pantalla1.route) {
        composable(Pantalla1.route) {
            Pantalla1(
                navegarPantalla2 = { newText ->

                    navController.navigate(Pantalla2.createRoute(newText))
                }
            )
        }
        composable(
            Pantalla2.route,
            arguments = listOf(navArgument("newText"){ defaultValue =
                "Pantalla 2" })
        ) { navBackStackEntry ->
            var newText =
                navBackStackEntry.arguments?.getString("newText")
            requireNotNull(newText)
            Pantalla2(newText, darkMode)
        }
        composable(Pantalla3.route) {
            Pantalla3()
        }
        composable(PantallaQR.route) {
            PantallaQR()
        }
        composable(
            Pantalla4.route,
            arguments = listOf(navArgument("newText"){ defaultValue =
                "Pantalla 4" })
        ) { navBackStackEntry ->
            var newText =
                navBackStackEntry.arguments?.getString("newText")
            requireNotNull(newText)
            Pantalla4(newText, darkMode)
        }

    }
}