package br.com.dio.app.repositories.domain

import br.com.dio.app.repositories.core.UseCase
import br.com.dio.app.repositories.data.model.Repositores
import br.com.dio.app.repositories.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositiryUseCase(private val repository: RepoRepository):
    UseCase<String, List<Repositores>>() {
    override suspend fun execute(param: String): Flow<List<Repositores>> {
        return repository.listRepositories(param)
    }
}