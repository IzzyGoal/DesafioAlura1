package com.desafiobackendalura.AluraChallenger.Controller;

import com.desafiobackendalura.AluraChallenger.Controller.Dto.VideoDto;
import com.desafiobackendalura.AluraChallenger.Controller.Form.AtualizaVideoForm;
import com.desafiobackendalura.AluraChallenger.Controller.Form.VideoForm;
import com.desafiobackendalura.AluraChallenger.Model.Video;
import com.desafiobackendalura.AluraChallenger.Repositori.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/videos")
public class VideoController {
    @Autowired
    private VideoRepository videoRepository;


    @GetMapping(path = "/{id}")
    public ResponseEntity<VideoDto> buscaPorId (@PathVariable Integer id){
        Optional<Video> video = videoRepository.findById(id);

        if (video.isPresent()) {
            return ResponseEntity.ok(new VideoDto(video.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<VideoDto> listaVideos () {
        List<Video> videos = videoRepository.findAll();
        return VideoDto.converter(videos);
    }

    @PostMapping
    public ResponseEntity<VideoDto> cadastraVideo (@RequestBody @Valid VideoForm videoForm, UriComponentsBuilder uriBuilder){
        Video video = videoForm.converter();
        videoRepository.save(video);
        URI uri = uriBuilder.path("videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDto(video));

    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<VideoDto> atualizaVideo (@PathVariable Integer id, @RequestBody @Valid AtualizaVideoForm videoAtualizadoForm){
        Optional <Video> videoProcurado = videoRepository.findById(id);
        if (videoProcurado.isPresent()){
            Video video = videoAtualizadoForm.atualizar(id, videoRepository);
            return ResponseEntity.ok(new VideoDto(video));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<VideoDto> deletarVideo(@PathVariable Integer id){
        Optional<Video> video = videoRepository.findById(id);

        if (video.isPresent()){
            videoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
