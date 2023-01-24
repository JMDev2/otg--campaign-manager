package com.example.otg_campaigns.fragments
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.otg_campaigns.R
import com.example.otg_campaigns.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4ClassRunner::class)

class DashboardFragmentTest {
    private lateinit var navController: NavController

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        navController = TestNavHostController(

            ApplicationProvider.getApplicationContext()

        )
        launchFragmentInHiltContainer<DashboardFragment>(
            themeResId = androidx.fragment.testing.R.style
                .FragmentScenarioEmptyFragmentActivityTheme
        ) {
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(requireView(), navController)
        }
    }


    @Test
    fun checkCancelImageView() {
        onView(withId(R.id.cancel_imageview)).perform(click())
            .check(matches(isClickable()))
    }

    @Test
    fun checkTextView() {
        Thread.sleep(30000)
        onView(withId(R.id.campaignRecyclerView)).perform(click())
    }

    @Test
    fun checkProgressBar() {

        onView(withId(R.id.progressBar2)).perform(click())
            .check(matches(isEnabled()))
    }
}
