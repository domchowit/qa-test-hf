package com.hellofresh.challenge.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDataFeeder<T> {
  private ObjectMapper objectMapper;
  private byte[] jsonData;


  public T getModelInstance(String scenarioName, Class<T> modelClass) throws IOException {
    jsonData = new byte[0];
    jsonData = Files.readAllBytes(Paths.get(String.format("src/test/resources/testData/%s.json", scenarioName)));
    objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonData, modelClass);
  }
}
