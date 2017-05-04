package com.dph;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {

    @RequestMapping("/status")
    public String status() {
        return "ok";
    }

    @RequestMapping(value = "/search/sum", method = RequestMethod.GET)
    public Object search(@RequestParam(value="query", required=true) String query,
                         @RequestParam(value="items", required=true) String items,
                         @RequestParam(value="approach", required=true) WeightingApproach approach,
                         @RequestParam(value="service", required=true) Service service,
                         @RequestParam(value="min_downloads", required=true) int minDownloads,
                         @RequestParam(value="page_size", required=true) int pageSize, @RequestParam(value="offset", required=true) int offset)
    {
        List<ItemEntry> entries = new ArrayList<>();

        entries.add(new ItemEntry(73762843, 0.01));
        entries.add(new ItemEntry(61540443, 0.01/2));
        entries.add(new ItemEntry(64678541, 0.01/3));
        entries.add(new ItemEntry(14784249, 0.01/4));
        entries.add(new ItemEntry(54936569, 0.01/4));
        entries.add(new ItemEntry(149154232, 0.01/4));
        entries.add(new ItemEntry(67922675, 0.01/4));
        entries.add(new ItemEntry(25288983, 0.01/4));
        entries.add(new ItemEntry(149688692, 0.01/4));
        entries.add(new ItemEntry(59864489, 0.01/4));

        return entries;
    }

}