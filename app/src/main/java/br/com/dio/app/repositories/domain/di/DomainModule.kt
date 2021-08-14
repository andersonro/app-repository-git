package br.com.dio.app.repositories.domain.di

import br.com.dio.app.repositories.domain.ListUserRepositiryUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule(): Module {
        return module {
            factory {
                ListUserRepositiryUseCase(get())
            }
        }
    }
}