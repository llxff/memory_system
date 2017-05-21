package com.github.llxff;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemoryPagesQueueTest {
  @Test
  public void isEmptyWithEmptyQueue() {
    MemoryPagesQueue queue = new MemoryPagesQueue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void getLengthWithEmptyQueue() {
    MemoryPagesQueue queue = new MemoryPagesQueue();
    assertEquals(0, queue.getLength());
  }

  @Test
  public void enqueueWithEmptyQueue() {
    MemoryPagesQueue queue = new MemoryPagesQueue();
    queue.enqueue(new MemoryPage(1, "status"));

    assertEquals(1, queue.getLength());
    assertFalse(queue.isEmpty());
  }

  @Test
  public void dequeueWithEmptyQueue() {
    MemoryPagesQueue queue = new MemoryPagesQueue();

    assertNull(queue.dequeue());
    assertEquals(0, queue.getLength());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void dequeueOneElement() {
    MemoryPagesQueue queue = new MemoryPagesQueue();
    MemoryPage page = new MemoryPage(1, "status");

    queue.enqueue(page);

    assertEquals(page, queue.dequeue());
    assertEquals(0, queue.getLength());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void dequeueFirstElement() {
    MemoryPagesQueue queue = new MemoryPagesQueue();
    MemoryPage page = new MemoryPage(1, "status");

    queue.enqueue(page);
    queue.enqueue(new MemoryPage(2, "status"));

    assertEquals(page, queue.dequeue());
    assertEquals(1, queue.getLength());
    assertFalse(queue.isEmpty());
  }

  @Test
  public void getWithEmptyList() {
    MemoryPagesQueue queue = new MemoryPagesQueue();

    assertNull(queue.get(0));
    assertTrue(queue.isEmpty());
    assertEquals(0, queue.getLength());
  }

  @Test
  public void getWithSeveralItems() {
    MemoryPagesQueue queue = new MemoryPagesQueue();

    MemoryPage page1 = new MemoryPage(1, "status");
    MemoryPage page2 = new MemoryPage(2, "status");
    MemoryPage page3 = new MemoryPage(3, "status");

    queue.enqueue(page1);
    queue.enqueue(page2);
    queue.enqueue(page3);

    assertEquals(page1, queue.get(0));
    assertEquals(page2, queue.get(1));
    assertEquals(page3, queue.get(2));
    assertNull(queue.get(3));

    assertFalse(queue.isEmpty());
    assertEquals(3, queue.getLength());
  }

  @Test
  public void removeWithEmptyList() {
    MemoryPagesQueue queue = new MemoryPagesQueue();

    queue.remove(0);

    assertTrue(queue.isEmpty());
    assertEquals(0, queue.getLength());
  }

  @Test
  public void removeWithSeveralItems() {
    MemoryPagesQueue queue = new MemoryPagesQueue();

    MemoryPage page1 = new MemoryPage(1, "status");
    MemoryPage page2 = new MemoryPage(2, "status");
    MemoryPage page3 = new MemoryPage(3, "status");

    queue.enqueue(page1);
    queue.enqueue(page2);
    queue.enqueue(page3);

    queue.remove(1);

    assertEquals(page1, queue.get(0));
    assertEquals(page3, queue.get(1));

    assertFalse(queue.isEmpty());
    assertEquals(2, queue.getLength());
  }
}
