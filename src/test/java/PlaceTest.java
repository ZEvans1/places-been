import models.Place;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaceTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        //Place.clearAllPlaces();

    }

    @Test
    public void NewPlaceObjectInstantiatesCorrectly_true() throws Exception {
        Place newPlace = setupNewPlace();
        assertEquals(true, newPlace instanceof Place);
    }

    @Test
    public void newPlace_getName_String() {
        Place newPlace = setupNewPlace();
        assertEquals("The Moon", newPlace.getName());
        assertEquals("cold", newPlace.getWeather());
        assertEquals("a week", newPlace.getStayLength());
        assertEquals("B", newPlace.getGrade());
    }

    @Test
    public void newPlaces_correctlyReturned_true() {
        Place newPlace = setupNewPlace();
        Place otherPlace = new Place("Antarctica", "also cold", "two days", "D");
        assertEquals(2, Place.getAll().size());
        assertTrue(Place.getAll().contains(newPlace));
        assertTrue(Place.getAll().contains(otherPlace));
    }


//    helper method
    public Place setupNewPlace() {
        return new Place("The Moon", "cold", "a week", "B" );
    }
}
