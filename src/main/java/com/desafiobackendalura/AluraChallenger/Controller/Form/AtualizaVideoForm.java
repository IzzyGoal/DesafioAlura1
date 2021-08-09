package com.desafiobackendalura.AluraChallenger.Controller.Form;

import com.desafiobackendalura.AluraChallenger.Model.Video;
import com.desafiobackendalura.AluraChallenger.Repositori.VideoRepository;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AtualizaVideoForm {
    @NotBlank
    public String titulo;

    @NotBlank
    public String descricao;

    public Video atualizar(Integer id, VideoRepository videoRepository) {
        Video video = videoRepository.getById(id);
        video.setTitulo(this.titulo);
        video.setDescricao(this.descricao);
        return video;
    }
}
