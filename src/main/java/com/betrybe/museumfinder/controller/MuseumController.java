package com.betrybe.museumfinder.controller;

import static com.betrybe.museumfinder.util.ModelDtoConverter.dtoToModel;
import static com.betrybe.museumfinder.util.ModelDtoConverter.modelToDto;

import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** Controller class to handle museum related operations. */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface museumService;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  /**
   * Create a museum.
   *
   * @param museumDto the museum to be created.
   * @return the created museum.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MuseumDto createMuseum(@RequestBody MuseumDto museumDto) {
    Museum museum = museumService.createMuseum(
        dtoToModel(museumDto)
    );

    return modelToDto(museum);
  }

  /**
   * Get the closest museum to a given coordinate.
   *
   * @param lat the latitude of the coordinate.
   * @param lng the longitude of the coordinate.
   * @param maxDistKm the maximum distance in kilometers.
   * @return the closest museum.
   */
  @GetMapping("/closest")
  @ResponseStatus(HttpStatus.OK)
  public MuseumDto getClosestMuseum(@RequestParam double lat, double lng,
      @RequestParam(name = "max_dist_km") double maxDistKm) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum museum = museumService.getClosestMuseum(coordinate, maxDistKm);

    return modelToDto(museum);
  }

}
