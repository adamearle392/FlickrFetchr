package com.adamearle.flickrfetchr

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adamearle.flickrfetchr.presentation.MainActivity
import com.adamearle.flickrfetchr.presentation.util.Screen
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()
    private val tag = Screen.Home.route

    private val column = rule.onNodeWithTag(
        "${tag}_Column",
        true
    )

    private val title = rule.onNodeWithTag(
        "${tag}_Text_GalleryTitle",
        true
    )

    private val lazyColumn = rule.onNodeWithTag(
        "${tag}_LazyColumn",
        true
    )

    @Test
    fun init() {
        // Check initial layout elements exist
        column.assertExists()
        title.assertExists()
        lazyColumn.assertExists()
    }
}