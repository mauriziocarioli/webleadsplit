package com.home_security.web_lead.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.home_security.web_lead.WebLeadSplit;

@Repository
public interface WebLeadSplitRepository extends CrudRepository<WebLeadSplit, Long> {
    @Query("select w from WebLeadSplit w where w.name = ?1")
    WebLeadSplit lookupByName(String name);
    default Iterable<WebLeadSplit> findAllRows() {
        return findAll();
    }
}
