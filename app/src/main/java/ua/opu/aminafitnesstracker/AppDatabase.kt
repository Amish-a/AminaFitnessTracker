package ua.opu.aminafitnesstracker

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Training::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun trainingDao(): TrainingDao

    companion object {
        // Міграція для переходу з версії 1 на версію 2
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(sqLiteDatabase: SupportSQLiteDatabase) {
                // Приклад міграції: додавання нового стовпця в таблицю "training"
                sqLiteDatabase.execSQL("ALTER TABLE training ADD COLUMN new_column INTEGER DEFAULT 0 NOT NULL")
            }
        }
    }
}
