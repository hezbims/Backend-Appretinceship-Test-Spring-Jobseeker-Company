package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy;

public class VacancyErrors {
    public static final String descriptionMust1To5000Char = "Panjang description harus 1-5000 karakter";
    public static final String vacancyNameMustBe2To75Char = "Panjang vacancyName harus 2-75 karakter";
    public static final String maxAgeNotNegative = "maxAge harus >= 0";
    public static final String minYearsExpNotNegative = "minimumYearsExperience harus >= 0 dan <= 30";
    public static final String salaryMax1Milliion = "Maksimal salary adalah 1 milyar";
    public static final String salaryNotNegative = "salary tidak boleh negatif";
    public static final String vacancyid24CharHexString = "vacancyId harus berupa 24 character hexadecimal-string";

}
