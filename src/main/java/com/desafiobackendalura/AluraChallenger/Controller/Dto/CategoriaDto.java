package com.desafiobackendalura.AluraChallenger.Controller.Dto;

import com.desafiobackendalura.AluraChallenger.Model.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDto {
    private Integer idCategoria;
    private String tituloCategoria;
    private String corCategoria;

    public CategoriaDto(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.tituloCategoria = categoria.getTituloCategoria();
        this.corCategoria = categoria.getCorCategoria();
    }

    public static List<CategoriaDto> converterParaDto(List <Categoria> categoria){
        return categoria.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public String getTituloCategoria() {
        return tituloCategoria;
    }

    public String getCorCategoria() {
        return corCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setTituloCategoria(String tituloCategoria) {
        this.tituloCategoria = tituloCategoria;
    }

    public void setCorCategoria(String corCategoria) {
        this.corCategoria = corCategoria;
    }
}
