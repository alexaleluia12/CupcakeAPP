package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.cupcake.CupcakeApp
import com.example.cupcake.CupcakeScreen
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CupcakeScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupCupcakeNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            CupcakeApp(navController = navController)
        }
    }

    @Test
    fun cupcakeNavHost_verifyStartDestination() {
        // sem helper function
        // assertEquals(CupcakeScreen.Start.name, navController.currentBackStackEntry?.destination?.route)
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)

        // sem hf
        // composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.my_string))
        composeTestRule.onNodeWithStringId(com.example.cupcake.R.string.app_name)

        // os testes nao estao completos pq nao consigo executar teste intrumental no meu pc
        // https://developer.android.com/codelabs/basic-android-kotlin-compose-test-cupcake?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-test-cupcake#4
    }
}