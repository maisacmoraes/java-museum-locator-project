package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeControllerTest {

  @MockBean
  CollectionTypeService service;

  @Autowired
  MockMvc mockMvc;


  @Test
  @DisplayName("Should return 200 when museums are found")
  public void testGetCollectionTypesCount() throws Exception {

    Mockito.when(service.countByCollectionTypes(Mockito.any()))
        .thenReturn(new CollectionTypeCount(new String[]{"Type1", "Type2"}, 3L));

    mockMvc.perform(MockMvcRequestBuilders.get("/collections/count/Type1,Type2"))
        .andExpect(result -> assertEquals(HttpStatus.OK.value(), result
            .getResponse()
            .getStatus()))
        .andExpect(result -> assertEquals(
            "{\"collectionTypes\":[\"Type1\",\"Type2\"],\"count\":3}", result
                .getResponse()
                .getContentAsString()));
  }

  @Test
  @DisplayName("Should return 404 when museums are not found")
  public void testGetCollectionTypesCountNotFound() throws Exception {

    Mockito.when(service.countByCollectionTypes(Mockito.any()))
        .thenReturn(new CollectionTypeCount(new String[]{"Type1", "Type2"}, 0L));

    mockMvc.perform(MockMvcRequestBuilders.get("/collections/count/Type1,Type2"))
        .andExpect(result -> assertEquals(HttpStatus.NOT_FOUND.value(), result
            .getResponse()
            .getStatus()));
  }
}