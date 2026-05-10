package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest {

    @Test
    void givenEmptyCafe_whenGettingCatCount_thenReturnZero() {
        CatCafe cafe = new CatCafe();

        long result = cafe.getCatCount();

        assertEquals(0, result);
    }

    @Test
    void givenOneCat_whenAddingCat_thenCatCountIsOne() {
        CatCafe cafe = new CatCafe();

        FelineOverLord cat =
            new FelineOverLord("Yuna", 4);

        cafe.addCat(cat);

        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void givenExistingCat_whenSearchingByName_thenReturnCorrectCat() {
        CatCafe cafe = new CatCafe();

        FelineOverLord cat =
            new FelineOverLord("Milo", 5);

        cafe.addCat(cat);

        FelineOverLord result =
            cafe.getCatByName("Milo");

        assertEquals(cat, result);
    }

    @Test
    void givenUnknownCatName_whenSearchingByName_thenReturnNull() {
        CatCafe cafe = new CatCafe();

        FelineOverLord result =
            cafe.getCatByName("Cookie");

        assertNull(result);
    }

    @Test
    void givenNullName_whenSearchingByName_thenReturnNull() {
        CatCafe cafe = new CatCafe();

        FelineOverLord result =
            cafe.getCatByName(null);

        assertNull(result);
    }

    @Test
    void givenNullCat_whenAddingCat_thenThrowException() {
        CatCafe cafe = new CatCafe();

        assertThrows(
            NullPointerException.class,
            () -> cafe.addCat(null));
    }

    @Test
    void givenMatchingWeight_whenSearchingByWeight_thenReturnCat() {
        CatCafe cafe = new CatCafe();

        FelineOverLord cat =
            new FelineOverLord("Miauzi", 6);

        cafe.addCat(cat);

        FelineOverLord result =
            cafe.getCatByWeight(5, 7);

        assertEquals(cat, result);
    }

    @Test
    void givenNegativeMinWeight_whenSearchingByWeight_thenReturnNull() {
        CatCafe cafe = new CatCafe();

        FelineOverLord result =
            cafe.getCatByWeight(-1, 5);

        assertNull(result);
    }

    @Test
    void givenInvalidWeightRange_whenSearchingByWeight_thenReturnNull() {
        CatCafe cafe = new CatCafe();

        FelineOverLord result =
            cafe.getCatByWeight(10, 5);

        assertNull(result);
    }

    @Test
    void givenNoMatchingWeight_whenSearchingByWeight_thenReturnNull() {
        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("yuna", 3));

        FelineOverLord result =
            cafe.getCatByWeight(10, 20);

        assertNull(result);
    }
}
