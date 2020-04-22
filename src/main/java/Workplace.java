package main.java;

import java.util.List;
import main.java.Address;

/**
 *  Class representing a workplace
 */
public class Workplace {
    private String name;
    private String businessId;
    private Address addr;
    private List<String> workerIds;

    public Workplace(String name, Address addr, List<String> workerIds, String businessId) {
        this.name = name;
        this.addr = addr;
        this.workerIds = workerIds;
        this.businessId = businessId;
    }

    public Workplace(String name, String stName, int stNo, String aptLtr, int aptNo, List<String> workerIds, String businessId) {
        this.name = name;
        this.addr = new Address(stName, stNo, aptLtr, aptNo);
        this.workerIds = workerIds;
        this.businessId = businessId;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public List<String> getWorkerIds() {
        return workerIds;
    }

    public void setWorkerIds(List<String> workerIds) {
        this.workerIds = workerIds;
    }

    public void addWorker(String id){
        this.workerIds.add(id);
    }

    // Utility methods
    public boolean isWorkingHere(String id){
        return workerIds.contains(id);
    }
}