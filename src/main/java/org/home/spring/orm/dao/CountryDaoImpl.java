package org.home.spring.orm.dao;

import org.hibernate.SessionFactory;
import org.home.spring.orm.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
@Transactional
public class CountryDaoImpl implements CountryDao {
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void save(@Nonnull Country country) {
        sessionFactory.getCurrentSession()
                      .save(country);
    }

    @Nonnull
    @Override
    public List<Country> findAllCountries() {
        //noinspection unchecked
        return sessionFactory.getCurrentSession()
                             .createCriteria(Country.class)
                             .list();
    }

    @Nonnull
    @Override
    public Country findCountryByName(@Nonnull String name) {
        return (Country) sessionFactory.getCurrentSession()
                                       .createCriteria(Country.class)
                                       .add(eq("name", name))
                                       .list()
                                       .get(0);
    }
}
