package com.example.exbd;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ParMoeda {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String codigo;
    private String descricao;
    private double valor;

    public ParMoeda(String codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
