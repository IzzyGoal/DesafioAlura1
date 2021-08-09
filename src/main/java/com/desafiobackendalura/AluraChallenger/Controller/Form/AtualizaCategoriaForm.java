package com.desafiobackendalura.AluraChallenger.Controller.Form;

import com.desafiobackendalura.AluraChallenger.Model.Categoria;
import com.desafiobackendalura.AluraChallenger.Repositori.CategoriaRepository;

import javax.validation.constraints.NotBlank;

public class AtualizaCategoriaForm {
    @NotBlank
    private String tituloCategoria;

    @NotBlank
    private String corCategoria;

    public String getTituloCategoria() {
        return tituloCategoria;
    }

    public void setTituloCategoria(String tituloCategoria) {
        this.tituloCategoria = tituloCategoria;
    }

    public String getCorCategoria() {
        return corCategoria;
    }

    public void setCorCategoria(String corCategoria) {
        this.corCategoria = corCategoria;
    }

    public Categoria atualizar(Integer idCategoria, CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.getById(idCategoria);
        categoria.setTituloCategoria(this.tituloCategoria);
        categoria.setCorCategoria(this.corCategoria);
        return categoria;
    }
}
