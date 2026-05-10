package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest {

    @Test
    void add_cat_increases_cat_count() {
        // Given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Momo", 3);

        // When
        cafe.addCat(cat);

        // Then
        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void get_cat_count_returns_zero_for_empty_cafe() {
        // Given
        CatCafe cafe = new CatCafe();

        // When
        long catCount = cafe.getCatCount();

        // Then
        assertEquals(0, catCount);
    }

    @Test
    void get_cat_by_name_returns_correct_cat() {
        // Given
        CatCafe cafe = new CatCafe();
        FelineOverLord momo = new FelineOverLord("Momo", 3);
        FelineOverLord luna = new FelineOverLord("Luna", 5);
        cafe.addCat(momo);
        cafe.addCat(luna);

        // When
        FelineOverLord foundCat = cafe.getCatByName("Luna");

        // Then
        assertSame(luna, foundCat);
    }

    @Test
    void get_cat_by_name_returns_null_for_unknown_name() {
        // Given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Momo", 3));

        // When
        FelineOverLord foundCat = cafe.getCatByName("Garfield");

        // Then
        assertNull(foundCat);
    }

    @Test
    void get_cat_by_name_returns_null_for_null_name() {
        // Given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Momo", 3));

        // When
        FelineOverLord foundCat = cafe.getCatByName(null);

        // Then
        assertNull(foundCat);
    }

    @Test
    void get_cat_by_weight_returns_cat_within_range() {
        // Given
        CatCafe cafe = new CatCafe();
        FelineOverLord lightCat = new FelineOverLord("Light", 2);
        FelineOverLord heavyCat = new FelineOverLord("Heavy", 7);
        cafe.addCat(lightCat);
        cafe.addCat(heavyCat);

        // When
        FelineOverLord foundCat = cafe.getCatByWeight(6, 8);

        // Then
        assertSame(heavyCat, foundCat);
    }

    @Test
    void get_cat_by_weight_uses_upper_limit_exclusively() {
        // Given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Momo", 5);
        cafe.addCat(cat);

        // When
        FelineOverLord foundCat = cafe.getCatByWeight(1, 5);

        // Then
        assertNull(foundCat);
    }

    @Test
    void get_cat_by_weight_returns_null_for_negative_minimum() {
        // Given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Momo", 3));

        // When
        FelineOverLord foundCat = cafe.getCatByWeight(-1, 5);

        // Then
        assertNull(foundCat);
    }

    @Test
    void get_cat_by_weight_returns_null_if_maximum_is_smaller_than_minimum() {
        // Given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Momo", 3));

        // When
        FelineOverLord foundCat = cafe.getCatByWeight(10, 5);

        // Then
        assertNull(foundCat);
    }

    @Test
    void add_cat_rejects_null() {
        // Given
        CatCafe cafe = new CatCafe();

        // When / Then
        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }
}
