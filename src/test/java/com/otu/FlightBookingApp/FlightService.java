public class FlightServiceTest {

    @Test
    public void testCalculateTotalFlightTimeForDirectFlight() {
        FlightService service = new FlightService();
        List<Flight> flights = Arrays.asList(/* direct flight details */);
        int totalTime = service.calculateTotalFlightTime(flights);

        assertEquals("Total time should match expected for direct flight", /*expected time*/, totalTime);
    }

    @Test
    public void testCalculateTotalFlightTimeForMultiStopFlight() {
        FlightService service = new FlightService();
        List<Flight> flights = Arrays.asList(/* multi-stop flight details */);
        int totalTime = service.calculateTotalFlightTime(flights);

        assertEquals("Total time should match expected for multi-stop flight", /*expected time*/, totalTime);
    }
}
