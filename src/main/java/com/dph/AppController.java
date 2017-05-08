package com.dph;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AppController {

    @RequestMapping("/status")
    public String status() {
        return "ok";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object search(@RequestParam(value="query", required=true) String query,
                         @RequestParam(value="items", required=true) String items,
                         @RequestParam(value="approach", required=true) WeightingApproach approach,
                         @RequestParam(value="service", required=true) Service service,
                         @RequestParam(value="min_downloads", required=true) int minDownloads,
                         @RequestParam(value="page_size", required=true) int pageSize, @RequestParam(value="offset", required=true) int offset)
    {
        Map<Integer,String> links = new HashMap<>();

        links.put(73762843, "http://st2.depositphotos.com/thumbs/1809585/73762843/thumb_380.jpg");
        links.put(61540443,"http://st2.depositphotos.com/thumbs/1491329/61540443/thumb_380.jpg");
        links.put(64678541, "http://st2.depositphotos.com/thumbs/1075946/64678541/thumb_380.jpg");
        links.put(14784249, "http://st.depositphotos.com/thumbs/1345889/14784249/thumb_380.jpg");
        links.put(54936569, "http://st2.depositphotos.com/thumbs/1606463/54936569/thumb_380.jpg" );
        links.put(149154232, "http://st3.depositphotos.com/thumbs/11433272/149154232/thumb_380.jpg");
        links.put(67922675, "http://st2.depositphotos.com/thumbs/1715570/67922675/thumb_380.jpg" );
        links.put(25288983, "http://st.depositphotos.com/thumbs/1001594/25288983/thumb_380.jpg");
        links.put(149688692, "http://st3.depositphotos.com/thumbs/9880800/149688692/thumb_380.jpg");
        links.put(59864489, "http://st2.depositphotos.com/thumbs/1158045/59864489/thumb_380.jpg" );

        List<ItemEntry> searchResult = new ArrayList<>();

        searchResult.add(new ItemEntry(73762843, 0.01, links.get(73762843)));
        searchResult.add(new ItemEntry(61540443, 0.01/2, links.get(61540443)));
        searchResult.add(new ItemEntry(64678541, 0.01/3, links.get(64678541)));
        searchResult.add(new ItemEntry(14784249, 0.01/4, links.get(14784249)));
        searchResult.add(new ItemEntry(54936569, 0.01/4, links.get(54936569)));
        searchResult.add(new ItemEntry(149154232, 0.01/4, links.get(149154232)));
        searchResult.add(new ItemEntry(67922675, 0.01/4, links.get(67922675)));
        searchResult.add(new ItemEntry(25288983, 0.01/4, links.get(25288983)));
        searchResult.add(new ItemEntry(149688692, 0.01/4, links.get(149688692)));
        searchResult.add(new ItemEntry(59864489, 0.01/4, links.get(59864489)));

        List<Integer> itemIds = new ArrayList<>();
        Scanner scanner = new Scanner(items);
        scanner.useDelimiter(",");

        List<ItemEntry> itemsBlock = new ArrayList<>();

        while (scanner.hasNextInt()) {
            int itemId = scanner.nextInt();
            itemsBlock.add(new ItemEntry(itemId, 0.0, links.get(itemId)));
        }

        Map<String,Object> response = new HashMap<>();

        response.put("searchResult", searchResult);
        response.put("itemsBlock", itemsBlock);

        return response;
    }

    @RequestMapping(value = "/links", method = RequestMethod.GET)
    public Object links(@RequestParam(value="items", required=true) String items)
    {
        List<Integer> itemIds = new ArrayList<>();
        Scanner scanner = new Scanner(items);
        scanner.useDelimiter(",");

        while (scanner.hasNextInt())
            itemIds.add(scanner.nextInt());


        Map<Integer,String> links = new HashMap<>();

        links.put(73762843, "http://st2.depositphotos.com/thumbs/1809585/73762843/thumb_380.jpg");
        links.put(61540443,"http://st2.depositphotos.com/thumbs/1491329/61540443/thumb_380.jpg");
        links.put(64678541, "http://st2.depositphotos.com/thumbs/1075946/64678541/thumb_380.jpg");
        links.put(14784249, "http://st.depositphotos.com/thumbs/1345889/14784249/thumb_380.jpg");
        links.put(54936569, "http://st2.depositphotos.com/thumbs/1606463/54936569/thumb_380.jpg" );
        links.put(149154232, "http://st3.depositphotos.com/thumbs/11433272/149154232/thumb_380.jpg");
        links.put(67922675, "http://st2.depositphotos.com/thumbs/1715570/67922675/thumb_380.jpg" );
        links.put(25288983, "http://st.depositphotos.com/thumbs/1001594/25288983/thumb_380.jpg");
        links.put(149688692, "http://st3.depositphotos.com/thumbs/9880800/149688692/thumb_380.jpg");
        links.put(59864489, "http://st2.depositphotos.com/thumbs/1158045/59864489/thumb_380.jpg" );

        Map<Integer,String> response = new HashMap<>();

        for (Integer itemId : itemIds) {
            response.put(itemId, links.get(itemId));
        }

        return response;
    }



}