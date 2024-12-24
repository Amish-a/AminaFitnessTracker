package ua.opu.aminafitnesstracker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingDao {

    @Insert
    suspend fun insert(training: Training): Long

    @Query("SELECT * FROM training_tracker")
    fun getAllTrainings(): Flow<List<Training>>

    @Query("SELECT SUM(calories) FROM training_tracker")
    fun getTotalCalories(): Flow<Int>
}