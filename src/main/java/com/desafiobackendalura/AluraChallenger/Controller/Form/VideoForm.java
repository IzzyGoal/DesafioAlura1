package com.desafiobackendalura.AluraChallenger.Controller.Form;

import com.desafiobackendalura.AluraChallenger.Model.Categoria;
import com.desafiobackendalura.AluraChallenger.Model.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoForm {
    public Integer id;

    @NotBlank
    public String titulo;

    @NotBlank
    public String descricao;

    @NotBlank
    public String url;

    public Categoria categoria;

    public Video converter() {
        return new Video(titulo, descricao, url, categoria);
    }
}
