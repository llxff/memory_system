package com.github.llxff;

import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;

public class Main {
  public static void main(String[] args) {
    save();
    load();
  }

  private static void save() {
    try {
      VirtualMachine machine = new VirtualMachine("/tmp/foo.xml");

      ProcessesList processes = new ProcessesList();
      processes.add(new Process(1));

      Process process = new Process(2);
      process.addMemoryPage(new MemoryPage(1, "active"));
      process.addMemoryPage(new MemoryPage(2, "disabled"));
      processes.add(process);
      processes.add(new Process(3));

      machine.save(processes);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void load() {
    try {
      VirtualMachine machine1 = new VirtualMachine("/tmp/foo.xml");

      ProcessesList list = machine1.load();

      VirtualMachine machine2 = new VirtualMachine("/tmp/foo2.xml");
      machine2.save(list);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
