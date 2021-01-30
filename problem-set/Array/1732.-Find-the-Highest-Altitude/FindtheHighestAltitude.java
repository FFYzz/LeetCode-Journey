class FindtheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0, currMax = 0;
        for (int i : gain) {
            currMax += i;
            max = Math.max(max, currMax);
        }
        return max;
    }
}
