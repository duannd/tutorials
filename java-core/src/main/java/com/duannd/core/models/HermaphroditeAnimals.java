package com.duannd.core.models;

/**
 * Created By ngdduan@gmail.com at 11/21/2018 10:52 AM
 */
public abstract class HermaphroditeAnimals implements Animals {

    @Override
    public String reproductionBy() {
        return "Itself";
    }
}
