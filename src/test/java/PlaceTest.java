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

    }

    @Test
    public void NewPlaceObjectInstantiatesCorrectly_true() throws Exception {
        Place newPlace = setupNewPlace();
        assertEquals(true, newPlace instanceof Place);
    }

//    helper method
    public Place setupNewPlace() {
        return new Place("The Moon");
    }
}
