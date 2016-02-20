package org.home.spring.orm.dao;

import org.home.spring.orm.model.Country;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;

public interface CountryDao {
    void save(@Nonnull Country country);

    @NotNull @Nonnull List<Country> findAllCountries();

    @Nonnull Country findCountryByName(@Nonnull String name);
}