package com.home_security.web_lead.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.home_security.web_lead.WebLeadSplit;

@Controller
@RequestMapping(value = "/")
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

    /*
     * @ResponseStatus(HttpStatus.CREATED)
     * 
     * @PostMapping public String create(@RequestBody(required = false) WebLeadSplit
     * webLeadSplit) { repository.save(webLeadSplit); return "redirect:/"; }
     */

    @GetMapping("/id/{id}")
    public Optional <WebLeadSplit> get(@PathVariable("id") Long id) {
        System.out.println(">>>>>>>>>>>> read by id = "+id);
        return repository.findById(id);
            //.orElse(null);
    }

    @GetMapping("/read/{name}")
    public WebLeadSplit get(@PathVariable("name") String name) {
        System.out.println(">>>>>>>>>>>> read by name = "+name);
        return repository.lookupByName(name);
            //.orElse(null);
    }

    @PutMapping("/update/{name}")
    public WebLeadSplit put(@PathVariable("name") String name, @RequestBody(required = false) WebLeadSplit w) {
        return repository.save(w);
    }

    /*@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void delete(@PathVariable("name") String name) {
        repository.deleteById(id);
    }*/

}