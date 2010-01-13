var aj = {
    addEvent: function(elm, evType, fn, useCapture) {
        // cross-browser event handling for IE5+, NS6 and Mozilla
        // By Scott Andrew
        if (elm.addEventListener) {
            elm.addEventListener(evType, fn, useCapture);
            return true;
        } else if (elm.attachEvent) {
            var r = elm.attachEvent('on' + evType, fn);
            return r;
        } else {
            elm['on' + evType] = fn;
        }
    },

    addTextAreaCallback : function(textArea, callback, delay) {
        var timer = null;
        textArea.onkeypress = function() {
            if (timer) {
                window.clearTimeout(timer);
            }
            timer = window.setTimeout( function() {
                timer = null;
                callback();
            }, delay );
        };
        textArea = null;
    },

    ajaxSearch : function() {
        var searchVal = $("#search-field").val();
        if (searchVal.length > 3) {
            $("#search-status").empty();
            $("#search-status").append(document.createTextNode("Searching"));
            $("#search-status").fadeIn(500);
            $.ajax({
                url: "http://localhost:8080/UmuMeREST/search/" + searchVal + "?callback=?",
                success: aj.dataLoaded,
                error: aj.failure,
                type: "GET",
                dataType: "json",
                cache: false,
                processData: false
            });
        }
    },

    failure : function () {
        alert("hej hopp");
    },

    dataLoaded : function(data) {
        if (data == null) {
            $("#search-status").empty();
            $("#search-status").append(document.createTextNode("Found nothing"));
            $("#search-output").fadeOut(1000);
            return true;
        }
        $("#search-status").fadeOut(1000);
        var persons;
        if (isNaN(data.person.length)) {
            persons = data;
        } else {
            persons = data.person;
        }
        var output = $("#search-output");
        output.empty();
        var ul = $("<ul>");
        output.append(ul);
        $.each(persons, function(i, person) {
            var li = $("<li>");
            var a = $("<a>");
            a.attr("href", "?username=" + person.uid);
            a.append(document.createTextNode(person.givenName + " " + person.familyName + " <" + person.uid + ">"));
            li.append(a);
            ul.append(li);
        });
    },

    init : function() {
        aj.addTextAreaCallback(document.getElementById("search-field"), aj.ajaxSearch, 500);
    }
};
    aj.addEvent(window, 'load', aj.init, false);


    //           $.ajax({
    //                 type: "GET",
    //                 url: "http://mega.cs.umu.se:8080/UmuMeREST/search/" + searchVal,
    //                 data: dataString,
    //                 cache: false,
    //                 beforeSend: function(html) {
    //                     document.getElementById("insert_search").innerHTML = '';
    //                     $("#flash").show();
    //                     $("#searchword").show();
    //                     $(".searchword").html(search_word);
    //                     $("#flash").html('<img src="ajax-loader.gif" /> Loading Results...');
    //                 },

    //                 success: function(html) {
    //                     $("#insert_search").show();
    //                     $("#insert_search").append(html);
    //                     $("#flash").hide();
    //                 }
    //             });
