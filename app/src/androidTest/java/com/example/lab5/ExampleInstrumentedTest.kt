package com.example.lab5

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testButton() {
        val bView = onView(withId(R.id.button))
        val tView = onView(withId(R.id.editText))

        bView.check(ViewAssertions.matches(withText("Change text!")))
        tView.check(ViewAssertions.matches(withText("1")))
        bView.perform(click())
        tView.perform(replaceText("42"))
        bView.check(ViewAssertions.matches(withText("Lab5")))
        tView.check(ViewAssertions.matches(withText("42")))
        activityTestRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        bView.check(ViewAssertions.matches(withText("Change text!")))
        tView.check(ViewAssertions.matches(withText("42")))
    }
}