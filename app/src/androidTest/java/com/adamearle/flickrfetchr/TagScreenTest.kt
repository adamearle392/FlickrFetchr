package com.adamearle.flickrfetchr

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adamearle.flickrfetchr.presentation.tag.TagScreen
import com.adamearle.flickrfetchr.presentation.theme.FlickrFetchrTheme
import com.adamearle.flickrfetchr.presentation.util.Screen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class TagScreenTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val rule = createComposeRule()
    private val tag = Screen.Tag.route

    private val column = rule.onNodeWithTag(
        "${tag}_Column",
        true
    )

    private val title = rule.onNodeWithTag(
        "${tag}_Text_TagTitle",
        true
    )

    private val lazyColumn = rule.onNodeWithTag(
        "${tag}_LazyColumn",
        true
    )

    @Before
    fun inject() {
        hiltRule.inject()
    }

    @Test
    fun init() {
        rule.setContent {
            FlickrFetchrTheme {
                TagScreen(tag = "cute")
            }
        }

        // Check initial layout elements exist
        column.assertExists()
        title.assertExists()
        lazyColumn.assertExists()
    }
}