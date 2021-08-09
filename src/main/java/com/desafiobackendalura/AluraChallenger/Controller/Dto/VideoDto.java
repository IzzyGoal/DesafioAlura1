package com.desafiobackendalura.AluraChallenger.Controller.Dto;

import com.desafiobackendalura.AluraChallenger.Model.Video;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class VideoDto {
    public Integer id;
    public String titulo;
    public String descricao;
    public String url;
    private Integer idCategoria;

    public VideoDto (Video video) {
        this.id = video.getId();
        this.titulo = video.getTitulo();
        this.descricao = video.getDescricao();
        this.url = video.getUrl();

    }

    public static List<VideoDto> converter(List<Video> videos){
        return videos.stream().map(VideoDto::new).collect(Collectors.toList());
    }
}
