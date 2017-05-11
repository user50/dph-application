
$('#searchBtn').on('click',function(){
    search();
});


function chooseItem(e){
        $('#items')[0].value = $('#items')[0].value + "," + $(e.currentTarget).children().first().attr('id');
        search();
}

function renderResults( json ) {
        $('#searchResults').empty();

        var searchResult = json.searchResult;

        searchResult.forEach(function(item, i, searchResult){
            $("<a/>", {
                href: '#',
                html: '<img src="' + item.link + '" id="' + item.itemId + '">',
                click: chooseItem
            }).appendTo("#searchResults");
        });

        $('#itemsParam').empty();

        var itemsBlock = json.itemsBlock;

        itemsBlock.forEach(function(item, i, itemsBlock){
            $("<a/>", {
                href: '#',
                html: '<img src="' + item.link + '" itemId="' + item.itemId + '">'
            }).appendTo("#itemsParam");
        });
}

function search(){

    var query = $('#query')[0].value;
    var items = $('#items')[0].value;
    var approach = $('#approach')[0].value;
    var service = $('#service')[0].value;
    var min_downloads = $('#min_downloads')[0].value;
    var page_size = $('#page_size')[0].value;
    var offset = $('#offset')[0].value;

    $.ajax({

        // The URL for the request
        url: "/search",

        // The data to send (will be converted to a query string)
        data: {
            query: query,
            items: items,
            approach: approach,
            service: service,
            min_downloads: min_downloads,
            page_size: page_size,
            offset: offset
        },

        // Whether this is a POST or GET request
        type: "GET",

        // The type of data we expect back
        dataType : "json"
    })
        // Code to run if the request succeeds (is done);
        // The response is passed to the function
            .done(renderResults)
        // Code to run if the request fails; the raw request and
        // status codes are passed to the function
            .fail(function( xhr, status, errorThrown ) {
                alert( "Sorry, there was a problem!" );
                console.log( "Error: " + errorThrown );
                console.log( "Status: " + status );
            });

}

