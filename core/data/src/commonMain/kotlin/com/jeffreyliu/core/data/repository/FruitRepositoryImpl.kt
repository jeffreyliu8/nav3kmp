package com.jeffreyliu.core.data.repository

import com.jeffreyliu.core.data.model.MyFruit
import com.jeffreyliu.database.Fruittie
import com.jeffreyliu.database.FruittieDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class FruitRepositoryImpl(private val fruittieDao: FruittieDao) : FruitRepository {
    override suspend fun insert(message: String) {
        fruittieDao.insert(Fruittie(name = message, fullName = message, calories = message))
    }

    override fun getAllFruits(): Flow<List<MyFruit>> = fruittieDao.getAllAsFlow().map {
        it.map { singleFruit ->
            MyFruit(
                id = singleFruit.id,
                name = singleFruit.name,
                fullName = singleFruit.fullName,
                calories = singleFruit.calories
            )
        }
    }
}
