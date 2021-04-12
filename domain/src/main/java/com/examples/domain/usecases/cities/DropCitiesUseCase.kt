package com.examples.domain.usecases.cities

import com.examples.data.repository.AppRepository
import com.examples.domain.base.LocalUseCase
import javax.inject.Inject

/**
 * Created by Shehab Elsarky
 */
class DropCitiesUseCase @Inject constructor(
    private val appRepository: AppRepository
) : LocalUseCase<Unit, Unit>() {

    override suspend fun executeOnBackground(parameters: Unit) {
        return appRepository.deleteCitiesTable()
    }
}