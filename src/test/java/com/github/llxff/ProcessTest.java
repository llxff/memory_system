package com.github.llxff;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessTest {
  @Test
  public void retrieveMemoryPageWithEmptyList() {
    Process process = new Process(1);

    assertNull(process.retrieveMemoryPage());
  }

  @Test
  public void retrieveMemoryPageWithPages() {
    Process process = new Process(1);
    MemoryPage page1 = new MemoryPage(1, "status");
    MemoryPage page2 = new MemoryPage(2, "status");

    process.addMemoryPage(page1);
    process.addMemoryPage(page2);

    assertEquals(page1, process.retrieveMemoryPage());
    assertEquals(page2, process.retrieveMemoryPage());
  }
}
