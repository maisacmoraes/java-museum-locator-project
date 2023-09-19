package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.controller.CollectionTypeController;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeControllerTest {


  @Test
  @DisplayName("Should return 404 when no museums are found")
  public void testGetCollectionTypesCount() {
    // Crie uma instância do serviço
    CollectionTypeService service = Mockito.mock(CollectionTypeService.class);

    // Crie uma instância do controlador injetando o serviço
    CollectionTypeController controller = new CollectionTypeController(service);

    // Defina o comportamento simulado do serviço
    String typesList = "Type1,Type2,Type3";
    CollectionTypeCount expectedResult = new CollectionTypeCount(new String[]{"Type1", "Type2", "Type3"}, 10);
    Mockito.when(service.countByCollectionTypes(typesList)).thenReturn(expectedResult);

    // Chame o método do controlador
    ResponseEntity<CollectionTypeCount> responseEntity = controller.getCollectionTypesCount(typesList);

    // Verifique o status da resposta
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    // Verifique se o resultado da resposta corresponde ao esperado
    assertEquals(expectedResult, responseEntity.getBody());
  }
}
