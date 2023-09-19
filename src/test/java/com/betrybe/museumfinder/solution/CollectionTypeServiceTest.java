package com.betrybe.museumfinder.solution;


import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.service.CollectionTypeService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CollectionTypeServiceTest {

 @MockBean
 MuseumFakeDatabase database;
 @Autowired
 CollectionTypeService service;

  @Test
  @DisplayName("Should count museums by collection type")
  public void testCountByCollectionTypes() {
    Mockito.when(database.countByCollectionType("Type1")).thenReturn(3L);

    CollectionTypeService service = new CollectionTypeService(database);
    service.countByCollectionTypes("Type1,Type2");

    assert (service.countByCollectionTypes("Type1,Type2").collectionTypes().length == 2);
    assert (service.countByCollectionTypes("Type1,Type2").collectionTypes()[0].equals("Type1"));
    assert (service.countByCollectionTypes("Type1,Type2").collectionTypes()[1].equals("Type2"));
    assert (service.countByCollectionTypes("Type1,Type2").count() == 3);
  }
}