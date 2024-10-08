package com.example.exbancodedados;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProdutoDao {
    @Insert
    void insert(Produto produto);

    @Query("SELECT * FROM Produto")
    LiveData<List<Produto>> getAll();
}
