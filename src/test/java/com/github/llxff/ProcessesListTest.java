package com.github.llxff;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessesListTest {
  @Test
  public void isEmptyWithEmptyList() {
    ProcessesList list = new ProcessesList();
    assertTrue(list.isEmpty());
  }

  @Test
  public void isEmptyWithOneElement() {
    ProcessesList list = new ProcessesList();
    list.add(new Process(1));

    assertFalse(list.isEmpty());
  }

  @Test
  public void getLengthWithEmptyList() {
    ProcessesList list = new ProcessesList();

    assertEquals(0, list.getLength());
  }

  @Test
  public void getLengthWithOneElement() {
    ProcessesList list = new ProcessesList();
    list.add(new Process(1));

    assertEquals(1, list.getLength());
  }

  @Test
  public void getHeadWithEmptyList() {
    ProcessesList list = new ProcessesList();

    assertNull(list.getHead());
  }

  @Test
  public void getHeadWithOneElement() {
    ProcessesList list = new ProcessesList();
    list.add(new Process(1));

    assertNotNull(list.getHead());
  }

  @Test
  public void removeWithEmptyList() {
    ProcessesList list = new ProcessesList();
    list.remove(0);

    assertTrue(list.isEmpty());
    assertEquals(0, list.getLength());
  }

  @Test
  public void removeWithOneElement() {
    ProcessesList list = new ProcessesList();
    list.add(new Process(1));

    list.remove(0);

    assertTrue(list.isEmpty());
    assertEquals(0, list.getLength());
  }

  @Test
  public void removeFirstElement() {
    ProcessesList list = new ProcessesList();
    list.add(new Process(1));

    Process item = new Process(2);

    list.add(item);

    list.remove(0);

    assertFalse(list.isEmpty());
    assertEquals(1, list.getLength());
    assertEquals(list.getHead().getProcess(), item);
  }

  @Test
  public void removeWithIndexMoreThanLength() {
    ProcessesList list = new ProcessesList();
    Process item = new Process(1);
    list.add(item);

    list.remove(1);

    assertFalse(list.isEmpty());
    assertEquals(1, list.getLength());
    assertEquals(list.getHead().getProcess(), item);
  }

  @Test
  public void removeWithLessThanZero() {
    ProcessesList list = new ProcessesList();
    Process item = new Process(1);
    list.add(item);

    list.remove(-1);

    assertFalse(list.isEmpty());
    assertEquals(1, list.getLength());
    assertEquals(list.getHead().getProcess(), item);
  }

  @Test
  public void getWithEmptyList() {
    ProcessesList list = new ProcessesList();

    assertNull(list.get(0));
  }

  @Test
  public void getWithOneElement() {
    ProcessesList list = new ProcessesList();
    Process process = new Process(1);
    list.add(process);

    assertEquals(process, list.get(0).getProcess());
  }

  @Test
  public void getWithTwoElements() {
    ProcessesList list = new ProcessesList();
    list.add(new Process(1));

    Process process = new Process(2);
    list.add(process);

    assertEquals(process, list.get(1).getProcess());
  }

  @Test
  public void getIfIndexMoreThanLength() {
    ProcessesList list = new ProcessesList();
    list.add(new Process(1));

    assertNull(list.get(2));
  }

  @Test
  public void getIfIndexLessThanZero() {
    ProcessesList list = new ProcessesList();
    list.add(new Process(1));

    assertNull(list.get(-1));
  }

  @Test
  public void addToEmptyList() {
    ProcessesList list = new ProcessesList();
    Process process = new Process(1);

    list.add(process);

    assertEquals(process, list.getHead().getProcess());
  }

  @Test
  public void addProcessWithHigherId() {
    ProcessesList list = new ProcessesList();

    Process process1 = new Process(1);
    Process process2 = new Process(2);

    list.add(process1);
    list.add(process2);

    ProcessesListItem head = list.getHead();

    assertEquals(process1, head.getProcess());
    assertEquals(process2, head.getNext().getProcess());
  }

  @Test
  public void addProcessWithSmallerId() {
    ProcessesList list = new ProcessesList();

    Process process1 = new Process(2);
    Process process2 = new Process(1);

    list.add(process1);
    list.add(process2);

    ProcessesListItem head = list.getHead();

    assertEquals(process2, head.getProcess());
    assertEquals(process1, head.getNext().getProcess());
  }
}
