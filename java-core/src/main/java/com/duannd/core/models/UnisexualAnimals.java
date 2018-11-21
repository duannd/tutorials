package com.duannd.core.models;

/**
 * Created By ngdduan@gmail.com at 11/21/2018 10:51 AM
 */
public interface UnisexualAnimals extends Animals {

    @Override
    default String reproductionBy() {
        return "mating";
    }

    String birth();

}
