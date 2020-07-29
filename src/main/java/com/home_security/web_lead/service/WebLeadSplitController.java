package com.home_security.web_lead.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.home_security.web_lead.WebLeadSplit;

@Controller
@RequestMapping(value = "/api/webleadsplit")
public class WebLeadSplitController {

    private WebLeadSplitRepository repository;

    @Autowired
    public WebLeadSplitController(WebLeadSplitRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public List<WebLeadSplit> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    /*@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String createFruit(@RequestBody(required = false) WebLeadSplit webLeadSplit) {
        repository.save(webLeadSplit);
        return "redirect:/";
    }*/

    @GetMapping("/{id}")
    public WebLeadSplit getWebLeadSplit(@PathVariable("id") Long id) {
        return repository.findById(id)
                            .orElse(null);
    }

    @GetMapping("/{name}")
    public WebLeadSplit getWebLeadSplit(@PathVariable("name") String name) {
        return (WebLeadSplit)repository.findByName(name)
        /* .orElse(null) */;
    }

    @PutMapping("/{id}")
    public WebLeadSplit updateWebLeadSplit(@PathVariable("id") Long id, @RequestBody(required = false) WebLeadSplit w) {
        //w.setId(id);
        return repository.save(w);
    }

    /*@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }*/

}