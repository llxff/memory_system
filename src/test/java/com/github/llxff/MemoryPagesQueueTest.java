package com.github.llxff;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemoryPagesQueueTest {
  @Test
  public void accessorsWithEmptyQueue() {
    MemoryPagesQueue queue = new MemoryPagesQueue(6);

    assertTrue(queue.isEmpty());
    assertFalse(queue.isFull());
    assertEquals(0, queue.getLength());
  }

  @Test
  public void enqueueWithEmptyQueue() {
    MemoryPagesQueue queue = new MemoryPagesQueue(6);
    queue.enqueue(new MemoryPage(1, "status"));

    assertEquals(1, queue.getLength());
    assertFalse(queue.isEmpty());
    assertFalse(queue.isFull());
  }

  @Test
  public void dequeueWithEmptyQueue() {
    MemoryPagesQueue queue = new MemoryPagesQueue(6);

    assertNull(queue.dequeue());
    assertEquals(0, queue.getLength());
    assertTrue(queue.isEmpty());
    assertFalse(queue.isFull());
  }

  @Test
  public void dequeueOneElement() {
    MemoryPagesQueue queue = new MemoryPagesQueue(6);
    MemoryPage page = new MemoryPage(1, "status");

    queue.enqueue(page);
    assertEquals(1, queue.getLength());
    assertFalse(queue.isEmpty());

    assertEquals(page, queue.dequeue());

    assertEquals(0, queue.getLength());
    assertTrue(queue.isEmpty());
    assertFalse(queue.isFull());
  }

  @Test
  public void dequeueFirstElement() {
    MemoryPagesQueue queue = new MemoryPagesQueue(6);
    MemoryPage page = new MemoryPage(1, "status");

    queue.enqueue(page);
    queue.enqueue(new MemoryPage(2, "status"));

    assertEquals(2, queue.getLength());
    assertFalse(queue.isEmpty());
    assertFalse(queue.isFull());

    assertEquals(page, queue.dequeue());
    assertEquals(1, queue.getLength());
    assertFalse(queue.isEmpty());
    assertFalse(queue.isFull());
  }


  @Test
  public void dequeueWithSeveralItems() {
    MemoryPagesQueue queue = new MemoryPagesQueue(6);

    MemoryPage page1 = new MemoryPage(1, "status");
    MemoryPage page2 = new MemoryPage(2, "status");
    MemoryPage page3 = new MemoryPage(3, "status");
    MemoryPage page4 = new MemoryPage(4, "status");
    MemoryPage page5 = new MemoryPage(5, "status");
    MemoryPage page6 = new MemoryPage(6, "status");

    queue.enqueue(page1);
    queue.enqueue(page2);
    queue.enqueue(page3);
    queue.enqueue(page4);
    queue.enqueue(page5);
    queue.enqueue(page6);

    assertFalse(queue.isEmpty());
    assertEquals(6, queue.getLength());
    assertTrue(queue.isFull());

    assertEquals(page1, queue.dequeue());
    assertEquals(page2, queue.dequeue());
    assertEquals(page3, queue.dequeue());
    assertEquals(page4, queue.dequeue());
    assertEquals(page5, queue.dequeue());
    assertEquals(page6, queue.dequeue());
    assertNull(queue.dequeue());

    assertTrue(queue.isEmpty());
    assertEquals(0, queue.getLength());
    assertTrue(queue.isFull());
  }
}
