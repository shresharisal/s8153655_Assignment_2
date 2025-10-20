package com.example.s8153655assignment2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.s8153655_assignment2.data.model.Entity
import com.example.s8153655_assignment2.ui.viewmodel.DashboardViewModel
import com.example.s8153655assignment2.domain.usecase.GetDashboardUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var getDashboardUseCase: GetDashboardUseCase
    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        getDashboardUseCase = mock(GetDashboardUseCase::class.java)
        viewModel = DashboardViewModel(getDashboardUseCase)
    }

    @After fun tearDown() { Dispatchers.resetMain() }

    @Test
    fun `loadDashboard posts entity list`() = runTest {
        val fakeList = listOf(
            Entity("A", "B", "Description 1"),
            Entity("C","D","Description 2")
        )

        `when`(getDashboardUseCase.invoke("key123")).thenReturn(fakeList)

        viewModel.loadDashboard("key123")
        advanceUntilIdle()

        Assert.assertEquals(2, viewModel.entities.value?.size)
        Assert.assertEquals("A", viewModel.entities.value?.first()?.property1)
    }

    @Test
    fun `loadDashboard handles null response`() = runTest {
        `when`(getDashboardUseCase.invoke("key123")).thenReturn(null)

        viewModel.loadDashboard("key123")
        advanceUntilIdle()

        Assert.assertTrue(viewModel.entities.value?.isEmpty() == true)
    }
}
