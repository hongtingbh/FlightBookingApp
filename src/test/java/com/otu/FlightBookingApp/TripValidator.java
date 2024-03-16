public class TripValidatorTest {

    @Test
    public void testValidateTripForNonCyclic() {
        TripValidator validator = new TripValidator();
        Trip trip = new Trip(/* non-cyclic trip details */);

        assertTrue("Trip should be valid", validator.validateTrip(trip));
    }

    @Test
    public void testValidateTripForCyclic() {
        TripValidator validator = new TripValidator();
        Trip trip = new Trip(/* cyclic trip details */);

        assertFalse("Cyclic trip should be invalid", validator.validateTrip(trip));
    }
}
