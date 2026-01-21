class ParkingSystem {

    private int[] availableSlots = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        availableSlots[0] = big;
        availableSlots[1] = medium;
        availableSlots[2] = small;
    }
    
    public boolean addCar(int carType) {
        if (availableSlots[carType-1] > 0){
            availableSlots[carType-1]--;
            return true;
        }
        return false;
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */