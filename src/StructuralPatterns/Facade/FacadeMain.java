package StructuralPatterns.Facade;

/*Предоставляет унифицировнный интерфейс вместо набора интерфейсов некоторой подсистемы*/

import java.util.Arrays;

/* Клиент */
public class FacadeMain {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startComputer();
    }
}

class CPU {
    public void freeze() {
        System.out.println("freeze");
    }
    public void jump(long position) {
        System.out.println("jump position = " + position);
    }
    public void execute() {
        System.out.println("execute");
    }
}
class Memory {
    public void load(long position, byte[] data) {
        System.out.println("load position = " + position + ", data = " + Arrays.toString(data));
    }
}
class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("read lba = " + lba + ", size = " + size);
        return new byte[size];
    }
}
/* Фасад */
class Computer {
    private final static long BOOT_ADDRESS = 1L;
    private final static long BOOT_SECTOR = 2L;
    private final static int SECTOR_SIZE = 3;

    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }
    public void startComputer() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}