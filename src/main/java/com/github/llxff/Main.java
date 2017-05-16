package com.github.llxff;

public class Main {
  public static void main(String[] args) {

  }
}

class VirtualMachine {
  private LinkedList<Process> processes;

  public VirtualMachine() {
    VirtualMachine(new LinkedList<Process>());
  }

  public VirtualMachine(LinkedList<Process> processes) {
    this.processes = processes;
  }

  public Process add() {

  }
}

class Memory {
  private int capacity;
  private ArrayList<MemoryPage> pages;

  public MemoryPage newPage() {

  }
}

class Process {
  private int id;
  private ArrayList<MemoryPage> pages;
}

class MemoryPage {
  private int number;
  private String status;
  private int size;

  public MemoryPage() {

  }
}
