package com.example.exbd;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ParMoedaDao {
    @Insert
    void inserir(ParMoeda ParMoeda);

    @Update
    void atualizar(ParMoeda ParMoeda);

    @Delete
    void deletar(ParMoeda ParMoeda);

    @Query("SELECT * FROM ParMoeda")
    LiveData<List<ParMoeda>> listar();

    @Query("SELECT * FROM ParMoeda WHERE id = :id LIMIT 1")
    ParMoeda SelectId(int id);

}
