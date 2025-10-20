package com.example.s8153655assignment2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.s8153655_assignment2.ui.viewmodel.LoginViewModel
import com.example.s8153655assignment2.domain.usecase.LoginUseCase
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
class LoginViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var loginUseCase: LoginUseCase
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        loginUseCase = mock(LoginUseCase::class.java)
        viewModel = LoginViewModel(loginUseCase)
    }

    @After fun tearDown() { Dispatchers.resetMain() }

    @Test
    fun `successful login updates LiveData`() = runTest {
        `when`(loginUseCase.invoke("John","8153655","footscray"))
            .thenReturn("key123")

        viewModel.login("John","8153655","footscray")
        advanceUntilIdle()

        Assert.assertEquals("key123", viewModel.loginResult.value)
    }

    @Test
    fun `failed login sets LiveData to null`() = runTest {
        `when`(loginUseCase.invoke("Wrong","0000","footscray"))
            .thenReturn(null)

        viewModel.login("Wrong","0000","footscray")
        advanceUntilIdle()

        Assert.assertNull(viewModel.loginResult.value)
    }
}
